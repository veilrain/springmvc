package vestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainSiteController {
	@RequestMapping(value = "/")
	public String defualtView() { return "index"; }
	
	@RequestMapping(value = "/new")
	public String viewWhatsNew() { return "site/new"; }
}
