package bkap.controller.customer;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import bkap.entities.CartsDTO;
import bkap.entities.ProductsDTO;

@Controller
public class CartControllerCustomer {

	public List<CartsDTO> getListCart(Client client, Gson gson, Integer accId) {
		WebResource webResource = client.resource("http://localhost:8080/WebService/rest/cartService/getList/" + accId);
		String cart = webResource.get(String.class);
		GenericType<List<CartsDTO>> listtypecart = new GenericType<List<CartsDTO>>() {
		};
		List<CartsDTO> carts = gson.fromJson(cart, listtypecart.getType());
		return carts;
	}

	public ProductsDTO getByIdProduct(Client client, Gson gson, Integer proId) {
		WebResource webResource2 = client
				.resource("http://localhost:8080/WebService/rest/productService/getById/" + proId);
		String data = webResource2.get(String.class);
		ProductsDTO productsDTO = gson.fromJson(data, ProductsDTO.class);
		return productsDTO;
	}

	public List<CartsDTO> getCartproIdaccId(Client client, Gson gson, Integer accId, Integer proId) {
		WebResource webResource = client
				.resource("http://localhost:8080/WebService/rest/cartService/check/" + accId + "/" + proId);
		String cart = webResource.get(String.class);
		GenericType<List<CartsDTO>> listtypecart = new GenericType<List<CartsDTO>>() {
		};
		List<CartsDTO> carts = gson.fromJson(cart, listtypecart.getType());
		return carts;
	}

	public CartsDTO getById(Client client, Gson gson, Integer cartId) {
		WebResource webResource = client
				.resource("http://localhost:8080/WebService/rest/cartService/getById/" + cartId);
		String data = webResource.get(String.class);
		CartsDTO carts = gson.fromJson(data, CartsDTO.class);
		return carts;
	}

	@RequestMapping(value = "/listCart")
	public String listCart(Model model) {
		Client client = Client.create();
		Gson gson = new Gson();
		Integer accId = 1;
		if (accId != null) {
			WebResource webResource = client.resource("http://localhost:8080/WebService/rest/productService/getList");
			String data = webResource.get(String.class);
			GenericType<List<ProductsDTO>> listtype = new GenericType<List<ProductsDTO>>() {
			};
			List<ProductsDTO> products = gson.fromJson(data, listtype.getType());

			List<CartsDTO> cartsDTOs = getListCart(client, gson, accId);
            CartsDTO cartDTO = new CartsDTO();
			model.addAttribute("cart", cartDTO);
			model.addAttribute("products", products);
			model.addAttribute("carts", cartsDTOs);
			return "customer/pages/cart";
		} else {
			return "redirect:/signUp";
		}
	}

	@RequestMapping(value = "/insertcart")
	public String insertcart(@RequestParam("proId") Integer proId, @RequestParam("quantity") Integer quantitycart,
			Model model) {
		Client client = Client.create();
		Gson gson = new Gson();
		Integer accId = 1;
		if (accId != null) {
			List<CartsDTO> listCart = getCartproIdaccId(client, gson, accId, proId);
			if (listCart.size() > 0) {
				Integer cartId = null;
				for (CartsDTO cartsDTO : listCart) {
					cartId = cartsDTO.getCartId();
				}
				Integer quantity = null;
				CartsDTO cartsDTO = getById(client, gson, cartId);
				quantity = cartsDTO.getQuantity() + quantitycart;
				Double TotalPrice = (double) (getByIdProduct(client, gson, proId).getPrice()
						- getByIdProduct(client, gson, proId).getDiscount()) * quantity;
				CartsDTO cartsDTO2 = new CartsDTO(cartId, accId, proId, quantity, TotalPrice);

				String data = gson.toJson(cartsDTO2);
				WebResource webResource = client.resource("http://localhost:8080/WebService/rest/cartService/update");
				ClientResponse clientResponse = webResource.type("application/json").put(ClientResponse.class, data);
				String re = clientResponse.getEntity(String.class);
				boolean bt = gson.fromJson(re, boolean.class);
			} else {
				Integer quantity = quantitycart;
				Double TotalPrice = (double) (getByIdProduct(client, gson, proId).getPrice()
						- getByIdProduct(client, gson, proId).getDiscount()) * quantity;
				CartsDTO cartsDTO = new CartsDTO(0, 1, proId, quantity, TotalPrice);
				String datacart = gson.toJson(cartsDTO);
				WebResource webResourcecart = client
						.resource("http://localhost:8080/WebService/rest/cartService/insert");
				ClientResponse clientResponse = webResourcecart.type("application/json").post(ClientResponse.class,
						datacart);
				String re = clientResponse.getEntity(String.class);
				boolean bt = gson.fromJson(re, boolean.class);
			}
		} else {
			return "redirect:/signUp";
		}
		return "redirect:/listCart";
	}
	@RequestMapping(value = "/updateCart")
	public String updateCart(@RequestParam("cartId") Integer[] cartId,@RequestParam("quantity") Integer[] quantity, Model model) {
		Client client = Client.create();
		Gson gson = new Gson();
		for (int i = 0; i < cartId.length; i++) {
			for (int j = 0; j < quantity.length; j++) {
				if(i == j) {
					WebResource webResource = client.resource("http://localhost:8080/WebService/rest/cartService/getById/"+cartId[i]);
					String data = webResource.get(String.class);
					CartsDTO cartsDTO = gson.fromJson(data, CartsDTO.class);
					
					CartsDTO cartsDTO2 = new CartsDTO(cartId[i], cartsDTO.getAccId(), cartsDTO.getProId(), quantity[j],cartsDTO.getTotalPrice());
					
					data = gson.toJson(cartsDTO2);
					webResource = client.resource("http://localhost:8080/WebService/rest/cartService/update");
					ClientResponse clientResponse = webResource.type("application/json").put(ClientResponse.class, data);
					String re = clientResponse.getEntity(String.class);
					boolean bt = gson.fromJson(re, boolean.class);
				}
			} 			
		}
		
		return "redirect:/listCart";
	}
	
	
	
	@RequestMapping(value = "/deleteCart")
	public String deleteCart(@RequestParam("cartId") Integer cartId,Model model) {
		Client client = new Client();
		Gson gson = new Gson();
		WebResource webResource1 = client.resource("http://localhost:8080/WebService/rest/cartService/delete/"+cartId);
		String data1 = webResource1.type("application/json").delete(String.class);
	    boolean bl = gson.fromJson(data1,boolean.class);
	    return "redirect:/listCart";
	}
}
