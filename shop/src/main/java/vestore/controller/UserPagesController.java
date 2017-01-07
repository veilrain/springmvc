package vestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserPagesController {

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
}
