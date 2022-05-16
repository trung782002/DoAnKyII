package bkap.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/admin"})
public class ReviewControllerAdmin {
	@RequestMapping(value = {"/reviewManagement"})
	public String reviewManagement(Model model) {
		return "admin/pages/reviewManagement";
	}
}
