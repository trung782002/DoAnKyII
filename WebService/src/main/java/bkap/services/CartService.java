package bkap.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import bkap.dao.impl.CartDAOImpl;
import bkap.entities.Accounts;
import bkap.entities.Carts;
import bkap.entities.Products;
import bkap.entities.dto.CartsDTO;

@Path("/cartService")
public class CartService {
	@GET
	@Path("/getList/{accId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getList(@PathParam("accId") Integer accId) {
		List<Carts> list = new CartDAOImpl().getList(accId);
		Gson son = new Gson();
		List<CartsDTO> data = new ArrayList<CartsDTO>();
		for (Carts c : list) {
			CartsDTO cDTO = new CartsDTO(c.getCartId(), c.getObjAccountOfCart().getAccId(),
					c.getObjProductOfCart().getProId(), c.getQuantity(), c.getTotalPrice());
			data.add(cDTO);
		}
		String Data = son.toJson(data);
		return Data;
	}

	@GET
	@Path("/check/{accId}/{proId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String check(@PathParam("accId") Integer accId, @PathParam("proId") Integer proId) {
		List<Carts> list = new CartDAOImpl().check(accId, proId);
		Gson son = new Gson();
		List<CartsDTO> data = new ArrayList<CartsDTO>();
		for (Carts c : list) {
			CartsDTO cDTO = new CartsDTO(c.getCartId(), c.getObjAccountOfCart().getAccId(),
					c.getObjProductOfCart().getProId(), c.getQuantity(), c.getTotalPrice());
			data.add(cDTO);
		}
		String Data = son.toJson(data);
		return Data;
	}

	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(String cart) {
		Gson son = new Gson();
		CartsDTO objDTO = son.fromJson(cart, CartsDTO.class);
		Accounts objAccounts = new Accounts();
		objAccounts.setAccId(objDTO.getAccId());
		Products objProducts = new Products();
		objProducts.setProId(objDTO.getProId());
		Carts objCart = new Carts(0, objDTO.getQuantity(), objDTO.getTotalPrice(), objAccounts, objProducts);
		boolean bl = new CartDAOImpl().insert(objCart);
		String data = son.toJson(bl);
		return data;
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String update(String c) {
		Gson son = new Gson();
		CartsDTO objDTO = son.fromJson(c, CartsDTO.class);
		Accounts objAccounts = new Accounts();
		objAccounts.setAccId(objDTO.getAccId());
		Products objProducts = new Products();
		objProducts.setProId(objDTO.getProId());
		Carts objCart = new Carts(objDTO.getCartId(), objDTO.getQuantity(), objDTO.getTotalPrice(), objAccounts, objProducts);
		boolean bl = new CartDAOImpl().update(objCart);
		String data = son.toJson(bl);
		return data;
	}

	@DELETE
	@Path("/delete/{Id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteCity(@PathParam("Id")Integer CartId) {
		Gson son = new Gson();
		boolean bl = new CartDAOImpl().delete(CartId);
		String data = son.toJson(bl);
		return data;

	}

	@GET
	@Path("/getById/{cartId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("cartId")Integer cartId) {
		Carts c = new CartDAOImpl().getById(cartId);
		Gson son = new Gson();
		CartsDTO cDTO = new CartsDTO(c.getCartId(), c.getObjAccountOfCart().getAccId(),
				c.getObjProductOfCart().getProId(), c.getQuantity(), c.getTotalPrice());
		String Data = son.toJson(cDTO);
		return Data;
	}
}
