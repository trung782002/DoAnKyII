package bkap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	@RequestMapping(value = {"/loginAdmin"})
	public String login(Model model) {
		return "admin/pages/login";
	}
	
	@RequestMapping(value = {"/admin"})
	public String admin(Model model) {
		return "admin/pages/index";
	}
	
	@RequestMapping(value = {"/orderManagement"})
	public String orderManagement(Model model) {
		return "admin/pages/orderManagement";
	}
}
