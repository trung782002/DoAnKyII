package bkap.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpServerErrorException;

@Controller
@RequestMapping(value = {"/admin"})
public class AdminController {
	
	@RequestMapping(value = {"/dashboard"})
	public String admin(Model model, HttpSession session) {
		return "admin/pages/index";
	}
	
}
