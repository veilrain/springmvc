package vestore.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vestore.dao.DataAccessor;
import vestore.model.Order;
import vestore.model.OrderEntry;
import vestore.model.Product;
import vestore.model.User;

@Controller
public class MainSiteController {
	@Autowired
	private DataAccessor<User> userTable;
	@Autowired
	private DataAccessor<Product> productTable;
	@Autowired
	private DataAccessor<Order> orderTable;
	@Autowired
	private DataAccessor<OrderEntry> orderEntryTable;
	
	@RequestMapping(value = "/")
	public String defualtView() { return "index"; }
	
	@RequestMapping(value = "/new")
	public String viewWhatsNew() { return "site/new"; }
	
	@RequestMapping(value = "/product")
	public String productDetailView() { return "site/product-detail"; }
	
	@RequestMapping(value = "/all-products")
	public String allProductList(Model model) {
		model.addAttribute("products", productTable.retrieveAll());
		return "site/all-products";
	}
	
	@RequestMapping(value = "/user/add-to-cart")
	public String addToCart(
			@RequestParam(value = "id", required = true) 
			String id, 
			Model model,
			Principal principal,
			HttpServletRequest request
		) {
		User u = userTable.retrieveBy("username", "'" + principal.getName() + "'").get(0);
		Order cart = u.getCart();
		
		if (cart == null) {
			cart = new Order(u);
			u.setCart(cart);
			
			orderTable.update(cart);
			userTable.update(u);
		}
		
		Product p = productTable.retrieveBy("id", id).get(0);
		
		List<OrderEntry> result = 
			orderEntryTable.retrieveBy("product_id", id + " and order_id = " + cart.getOrderId());
		
		OrderEntry newEntry;
		if (result.isEmpty()) {
			newEntry = new OrderEntry(cart, p);
			cart.getEntries().add(newEntry);
		} else {
			newEntry = result.get(0);
			newEntry.setCount(newEntry.getCount() + 1);
		}
		orderEntryTable.update(newEntry);
		
		cart = orderTable.retrieveBy("order_id", "" + cart.getOrderId()).get(0);
//		model.addAttribute("products", cart.getEntries());
 		return "redirect:" + request.getHeader("Referer");
	}
}
