package vestore.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.multipart.MultipartFile;

import vestore.dao.DataAccessor;
import vestore.model.Product;
import vestore.model.User;

@Controller
public class SiteConsoleController {
	/* DAO connects to the table of Products */
	@Autowired
	private DataAccessor<Product> productTable;
	@Autowired
	private DataAccessor<User> userTable;
	
	private Path path;
	private String url = "G:/upload/images/";
	
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
		MultipartFile productImg = newProduct.getProductImg();
		path = Paths.get(url + String.valueOf(newProduct.getId()) + ".png");
		if (productImg != null && !productImg.isEmpty()) {
			try {
				productImg.transferTo(new File(path.toString()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw  new RuntimeException("Save failed because of the ProductImg");
			}
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
