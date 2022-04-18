package bkap.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import bkap.dao.impl.OrderDAOImpl;
import bkap.entities.Orders;
import bkap.entities.dto.OrdersDTO;

@Path("/orderService/")
public class OrderService {
	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getList() {
		List<Orders> listOrder = new OrderDAOImpl().getList();
		Gson son = new Gson();
		List<OrdersDTO> listOrderDTO = new ArrayList<OrdersDTO>();
		for (Orders order : listOrder) {
			OrdersDTO orderDTO = new OrdersDTO(order.getOrderId(), order.getObjAccountOfOrder().getAccId(),
					order.getFullName(), order.getAddress(), order.getPhone(), order.getNote(), order.getTotalPrice(),
					order.getStatus(), order.getCreatedAt(), order.getUpdatedAt());
			listOrderDTO.add(orderDTO);
		}
		String data = son.toJson(listOrderDTO);
		return data;
	}

	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(String jsonOrder) {
		Gson son = new Gson();
		OrdersDTO orderDTO = son.fromJson(jsonOrder, OrdersDTO.class);
		Orders order = new Orders(0, orderDTO.getFullName(), orderDTO.getAddress(), orderDTO.getPhone(),
				orderDTO.getNote(), orderDTO.getTotalPrice(), orderDTO.getStatus(), orderDTO.getCreatedAt(), null, null, null);
		boolean bl = new OrderDAOImpl().insert(order);
		String data = son.toJson(bl);
		return data;
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String update(String jsonOrder) {
		Gson son = new Gson();
		OrdersDTO orderDTO = son.fromJson(jsonOrder, OrdersDTO.class);
		Orders order = new Orders(0, orderDTO.getFullName(), orderDTO.getAddress(), orderDTO.getPhone(),
				orderDTO.getNote(), orderDTO.getTotalPrice(), orderDTO.getStatus(), orderDTO.getCreatedAt(), null, null, null);
		boolean bl = new OrderDAOImpl().update(order);
		String data = son.toJson(bl);
		return data;
	}

	@GET
	@Path("/getById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("id") Integer id) {
		Gson son = new Gson();
		Orders order = new OrderDAOImpl().getById(id);
		OrdersDTO orderDTO = new OrdersDTO(order.getOrderId(), order.getObjAccountOfOrder().getAccId(),
				order.getFullName(), order.getAddress(), order.getPhone(), order.getNote(), order.getTotalPrice(),
				order.getStatus(), order.getCreatedAt(), order.getUpdatedAt());
		String Data = son.toJson(orderDTO);
		return Data;

	}
}
