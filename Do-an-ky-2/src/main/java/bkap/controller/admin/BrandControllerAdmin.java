package bkap.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/admin"})
public class BrandControllerAdmin {
	@RequestMapping(value = {"/brandManagement"})
	public String brandManagement(Model model) {
		return "admin/pages/brandManagement";
	}
}
