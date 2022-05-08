package bkap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
	
	@RequestMapping(value = "/category")
	public String category(Model model) {
		return "customer/pages/category";
	}
	
	@RequestMapping(value = "/product")
	public String product(Model model) {
		return "customer/pages/product";
	}
	
	@RequestMapping(value = "/checkOut")
	public String checkOut(Model model) {
		return "customer/pages/checkOut";
	}
	
	@RequestMapping(value = "/contact")
	public String contact(Model model) {
		return "customer/pages/contact";
	}
}
