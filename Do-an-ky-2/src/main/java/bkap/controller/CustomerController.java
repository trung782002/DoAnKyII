package bkap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
	@RequestMapping(value = {"/", "/home"})
	public String home(Model model) {
		return "customer/pages/index";
	}
	
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
	
	@RequestMapping(value = "/cart")
	public String cart(Model model) {
		return "customer/pages/cart";
	}
	
	@RequestMapping(value = "/blog")
	public String blog(Model model) {
		return "customer/pages/blog";
	}
	
	@RequestMapping(value = "/blogDetail")
	public String blogDetail(Model model) {
		return "customer/pages/blogDetail";
	}
	
	@RequestMapping(value = "/contact")
	public String contact(Model model) {
		return "customer/pages/contact";
	}
	
	@RequestMapping(value = "/login")
	public String login(Model model) {
		return "customer/pages/login";
	}
	
	@RequestMapping(value = "/signUp")
	public String signUp(Model model) {
		return "customer/pages/signUp";
	}
}
