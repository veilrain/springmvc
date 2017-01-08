package vestore.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vestore.dao.DataAccessor;
import vestore.model.Order;
import vestore.model.Product;
import vestore.model.User;

@Controller
public class SiteConsoleController {
	/* DAO connects to the table of Products */
	@Autowired
	private DataAccessor<Product> productTable;
	@Autowired
	private DataAccessor<User> userTable;
	@Autowired
	private DataAccessor<User> orderTable;
	
	/* View Handlers */
	
	@RequestMapping(value = "/console")
	public String viewConsole() { return "console/index"; }
	
	@RequestMapping(value = "/console/product-list")
	public String viewProductList(Model model) {
		model.addAttribute("products", productTable.retrieveAll());
		return "console/product-list";
	}
	
	@RequestMapping(value = "/console/submit-product")
	public String viewSubmitProduct(
			@RequestParam(value = "id", required = false) 
			String id, Model model
		) {
		List<Product> products = productTable.retrieveBy("id", id);
		model.addAttribute(
			"newProduct", 
			products.isEmpty() ?  new Product() : products.get(0)
		);
		return "console/submit-product";
	}
	
	@RequestMapping(value = "/console/submit-product", method = RequestMethod.POST)
	public String submitProduct(
		@Valid @ModelAttribute("newProduct") 
		Product newProduct, 
		BindingResult result, 
		Model model,
		HttpServletRequest request
	) {
		if (!result.hasErrors()) {
			newProduct.setLastTimeModified(new Date(Calendar.getInstance().getTime().getTime()));
			productTable.update(newProduct);
		}
		
		return viewProductList(model);
	}
	
	@RequestMapping(value = "/console/delete")
	public String deleteProduct(
			@RequestParam(value = "id", required = true) 
			String id, Model model
		) {
		productTable.delete(productTable.retrieveBy("id", id).get(0));
		return viewProductList(model);
	}
	
	@RequestMapping(value = "/console/user-list")
	public String viewUserList(Model model) {
		model.addAttribute("users", userTable.retrieveAll());
		return "console/user-list";
	}
	
	@RequestMapping(value = "/console/submit-user")
	public String viewSubmitUser(
			@RequestParam(value = "id", required = false) 
			String id, Model model
		) {
		List<User> users = userTable.retrieveBy("user_id", id);
		model.addAttribute(
			"newUser", 
			users.isEmpty() ?  new User() : users.get(0)
		);
		return "console/submit-user";
	}
	
	@RequestMapping(value = "/console/submit-user", method = RequestMethod.POST)
	public String submitUser(
		@Valid @ModelAttribute("newUser") 
		User newUser, 
		BindingResult result, 
		Model model,
		HttpServletRequest request
	) {
		if (!result.hasErrors()) {
			userTable.update(newUser);
		}
		return viewUserList(model);
	}
	
	@RequestMapping(value = "/console/delete-user")
	public String deleteUser(
			@RequestParam(value = "id", required = true) 
			String id, Model model
		) {
		userTable.delete(userTable.retrieveBy("id", id).get(0));
		return viewUserList(model);
	}
}
