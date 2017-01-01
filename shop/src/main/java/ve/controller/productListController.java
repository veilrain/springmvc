package ve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class productListController {
	
	@RequestMapping(value="/viewProductList")
	public String productList() {
		return "viewProductList";
	}
}
