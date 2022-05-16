package bkap.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import bkap.dao.impl.ReviewDAOImpl;
import bkap.entities.Accounts;
import bkap.entities.Products;
import bkap.entities.Reviews;
import bkap.entities.dto.ReviewsDTO;

@Path("/reviewService/")
public class ReviewService {
	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getList() {
		Gson son = new Gson();
		List<Reviews> list = new ReviewDAOImpl().getList();
		List<ReviewsDTO> data = new ArrayList<ReviewsDTO>();
		for (Reviews r : list) {
			ReviewsDTO cDTO = new ReviewsDTO(r.getId(), r.getObjAccountOfReview().getAccId(),
					r.getObjProductOfReview().getProId(), r.getProductQuality(), r.getContentRated(), r.getReply(),
					r.isStatus(), r.getCreatedAt());
			data.add(cDTO);
		}
		String Data = son.toJson(data);
		return Data;
	}

	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(String c) {
		Gson son = new Gson();
		ReviewsDTO objDTO = son.fromJson(c, ReviewsDTO.class);
		Accounts objAccounts = new Accounts();
		objAccounts.setAccId(objDTO.getAccId());
		Products objProducts = new Products();
		objProducts.setProId(objDTO.getProId());
		Reviews objReview = new Reviews(0, objDTO.getProductQuality(), objDTO.getContentRated(), objDTO.getReply(),
				objDTO.isStatus(), objDTO.getCreatedAt(), objAccounts, objProducts);
		boolean bl = new ReviewDAOImpl().insert(objReview);
		String data = son.toJson(bl);
		return data;
	}

	@DELETE
	@Path("/delete/{Id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteCity(@PathParam("Id") Integer ReviewId) {
		Gson son = new Gson();
		boolean bl = new ReviewDAOImpl().delete(ReviewId);
		String data = son.toJson(bl);
		return data;

	}

	@GET
	@Path("/getById/{ReviewId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("ReviewId") Integer ReviewId) {
		Reviews r = new ReviewDAOImpl().getById(ReviewId);
		Gson son = new Gson();

		ReviewsDTO cDTO = new ReviewsDTO(r.getId(), r.getObjAccountOfReview().getAccId(),
				r.getObjProductOfReview().getProId(), r.getProductQuality(), r.getContentRated(), r.getReply(),
				r.isStatus(), r.getCreatedAt());
		String Data = son.toJson(cDTO);
		return Data;
	}
}
