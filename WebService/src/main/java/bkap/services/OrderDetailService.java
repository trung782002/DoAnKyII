package bkap.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import bkap.dao.impl.OrderDetailDAOImpl;
import bkap.entities.OrderDetails;
import bkap.entities.Orders;
import bkap.entities.Products;
import bkap.entities.dto.OrderDetailsDTO;

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

	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(String jsonOrderDetail) {
		Gson son = new Gson();
		OrderDetailsDTO orderDetailDTO = son.fromJson(jsonOrderDetail, OrderDetailsDTO.class);
		Orders order = new Orders();
		order.setOrderId(orderDetailDTO.getOrderId());
		Products product = new Products();
		product.setProId(orderDetailDTO.getProId());
		OrderDetails orderDetail = new OrderDetails(orderDetailDTO.getId(), orderDetailDTO.getQuantity(),
				orderDetailDTO.getPrice(), order, product);
		boolean bl = new OrderDetailDAOImpl().insert(orderDetail);
		String data = son.toJson(bl);
		return data;
	}
}
