package bkap.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactCotrollerAdmin {
	@RequestMapping(value = {"/contactManagement"})
	public String contactManagement(Model model) {
		return "admin/pages/contactManagement";
	}
}
