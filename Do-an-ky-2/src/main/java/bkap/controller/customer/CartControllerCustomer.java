package bkap.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartControllerCustomer {
	@RequestMapping(value = "/insertcart")
	public String insertcart(Model model) {
		int AccId = 1;
		if(AccId == 1) {
			
		}
		return "customer/pages/cart";
	}
}
