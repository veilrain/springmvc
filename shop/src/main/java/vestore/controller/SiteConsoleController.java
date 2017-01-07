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

import vestore.dao.AbstractDAO;
import vestore.model.Product;

@Controller
public class SiteConsoleController {
	/* DAO connects to the table of Products */
	@Autowired
	private AbstractDAO<Product> productTable;
	
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
		boolean isEditing = !products.isEmpty();
		model.addAttribute(
			"newProduct", 
			isEditing ? products.get(0): new Product()
		);
		if (isEditing) {
			model.addAttribute("id", id);
		}
		return "console/submit-product";
	}
	
	/* POST Requests Handlers */
	
	@RequestMapping(value = "/console/submit-product", method = RequestMethod.POST)
	public String submitProduct(
		@Valid @ModelAttribute("newProduct") 
		Product newProduct, 
		BindingResult result, 
		Model model,
		HttpServletRequest request,
		@RequestParam(value = "id", required = false) 
		String id
	) {
		if (!result.hasErrors()) {
			try {
				newProduct.setId(Integer.parseInt(id));
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
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
}
