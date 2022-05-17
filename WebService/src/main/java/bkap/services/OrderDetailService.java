package bkap.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import bkap.dao.impl.OrderDAOImpl;
import bkap.dao.impl.OrderDetailDAOImpl;
import bkap.entities.OrderDetails;
import bkap.entities.Orders;
import bkap.entities.Products;
import bkap.entities.dto.OrderDetailsDTO;
import bkap.entities.dto.OrdersDTO;

@Path("/orderDetailService/")
public class OrderDetailService {
	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getList() {
		List<OrderDetails> listOrderDetail = new OrderDetailDAOImpl().getByOrderId(null);
		Gson son = new Gson();
		List<OrderDetailsDTO> listOrderDetailDTO = new ArrayList<OrderDetailsDTO>();
		for (OrderDetails orderDetail : listOrderDetail) {
			OrderDetailsDTO orderDetailDTO = new OrderDetailsDTO(orderDetail.getId(),
					orderDetail.getObjOrderOfOrderDetail().getOrderId(),
					orderDetail.getObjProductOfOrderDetail().getProId(), orderDetail.getQuantity(),
					orderDetail.getPrice());
			listOrderDetailDTO.add(orderDetailDTO);
		}
		String data = son.toJson(listOrderDetailDTO);
		return data;
	}
	
	@GET
	@Path("/getOrderStatus/{accId}/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getOrderAccId(@PathParam("accId") Integer id,@PathParam("status") Integer status) {		
		List<OrderDetails> listOrderDetail = new OrderDetailDAOImpl().getOrderStatus(id, status);
		Gson son = new Gson();
		List<OrderDetailsDTO> listOrderDetailDTO = new ArrayList<OrderDetailsDTO>();
		for (OrderDetails orderDetail : listOrderDetail) {
			OrderDetailsDTO orderDetailDTO = new OrderDetailsDTO(orderDetail.getId(),
					orderDetail.getObjOrderOfOrderDetail().getOrderId(),
					orderDetail.getObjProductOfOrderDetail().getProId(), orderDetail.getQuantity(),
					orderDetail.getPrice());
			listOrderDetailDTO.add(orderDetailDTO);
		}
		String data = son.toJson(listOrderDetailDTO);
		return data;
	}

	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(String jsonOrderDetail) {
		Gson son = new Gson();
		OrderDetailsDTO orderDetailDTO = son.fromJson(jsonOrderDetail, OrderDetailsDTO.class);
		Orders objorder = new Orders();
		objorder.setOrderId(orderDetailDTO.getOrderId());
		Products objproduct = new Products();
		objproduct.setProId(orderDetailDTO.getProId());
		OrderDetails orderDetail = new OrderDetails(orderDetailDTO.getId(), orderDetailDTO.getQuantity(),
				orderDetailDTO.getPrice(), objorder, objproduct);
		boolean bl = new OrderDetailDAOImpl().insert(orderDetail);
		String data = son.toJson(bl);
		return data;
	}
}
