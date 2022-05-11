package bkap.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactControllerCustomer {
	@RequestMapping(value = "/contact")
	public String contact(Model model) {
		return "customer/pages/contact";
	}
}
