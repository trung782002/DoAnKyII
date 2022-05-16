package bkap.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/admin"})
public class OrderControllerAdmin {
	@RequestMapping(value = {"/orderManagement"})
	public String orderManagement(Model model) {
		return "admin/pages/orderManagement";
	}
}
