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
	
	@RequestMapping(value = {"/categoryManagement"})
	public String categoryManagement(Model model) {
		return "admin/pages/categoryManagement";
	}
	
	@RequestMapping(value = {"/brandManagement"})
	public String brandManagement(Model model) {
		return "admin/pages/brandManagement";
	}
	
	@RequestMapping(value = {"/listProducts"})
	public String listProducts(Model model) {
		return "admin/pages/listProducts";
	}
	
	@RequestMapping(value = {"/insertProduct"})
	public String insertProduct(Model model) {
		return "admin/pages/insertProduct";
	}
	
	@RequestMapping(value = {"/orderManagement"})
	public String orderManagement(Model model) {
		return "admin/pages/orderManagement";
	}
	
	@RequestMapping(value = {"/accountManagement"})
	public String accountManagement(Model model) {
		return "admin/pages/accountManagement";
	}
	
	@RequestMapping(value = {"/reviewManagement"})
	public String reviewManagement(Model model) {
		return "admin/pages/reviewManagement";
	}
	
	@RequestMapping(value = {"/contactManagement"})
	public String contactManagement(Model model) {
		return "admin/pages/contactManagement";
	}
	
	
}
