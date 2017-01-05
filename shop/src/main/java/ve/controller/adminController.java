package ve.controller;

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

import ve.dao.ProductDao;
import ve.model.Product;

@Controller
public class adminController {

	@Autowired
	private ProductDao productDao;

	@RequestMapping(value = "/admin")
	public String admin() {
		return "admin";
	}

	@RequestMapping(value = "/admin/showProduct")
	public String showProduct(Model model) {
		List<Product> product = productDao.getAllProducts();
		model.addAttribute("product", product);
		return "showProduct";
	}

	@RequestMapping(value = "/admin/addProduct")
	public String addProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "addProduct";
	}

	@RequestMapping(value = "/admin/addProduct", method = RequestMethod.POST)
	public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addProduct";
		}
		productDao.addProduct(product);
		return "redirect:/admin/showProduct";
	}
}
