package vestore.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vestore.dao.DataAccessor;
import vestore.model.Order;
import vestore.model.OrderEntry;
import vestore.model.User;

@Controller
public class UserPagesController {
	@Autowired
	private DataAccessor<User> userTable;
	@Autowired
	private DataAccessor<OrderEntry> orderEntryTable;
	@Autowired
	private DataAccessor<Order> orderTable;
	
	@RequestMapping(value = "/login")
	public String viewAdminLogin(
		@RequestParam(value = "error", required = false) 
		String error,
		Model model
	) {
		if (error != null) {
			model.addAttribute(
				"error", 
				"login failed, please try again"
			);
		}
		
		return "users/login";
	}
	
	@RequestMapping(value = "/user/cart")
	public String viewCart(
		@RequestParam(value = "error", required = false) 
		String error,
		Principal principal,
		Model model, HttpServletRequest request
	) {
		User u = userTable.retrieveBy("username", "'" + principal.getName() + "'").get(0);
		Order cart = u.getCart();

		model.addAttribute("products", cart.getEntries());
		return "users/cart";
	}
	
	@RequestMapping(value = "/delete-from-cart")
	public String deleteFromCart(
			@RequestParam(value = "id", required = true) 
			String id, Model model, HttpServletRequest request
		) {
		OrderEntry e = orderEntryTable.retrieveBy("entryId", id).get(0);
		Order cart = e.getOrder();
		orderEntryTable.delete(e);
		
		cart = orderTable.retrieveBy("order_id", "" + cart.getOrderId()).get(0);
		
		model.addAttribute("products", cart.getEntries());
		return "redirect:" + request.getHeader("Referer");
	}
}
