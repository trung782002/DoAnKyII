package bkap.services;

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

import bkap.dao.impl.BlogDAOImpl;
import bkap.entities.Blogs;

@Path("/blogService/")
public class BlogService {
	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getListBlog() {
		List<Blogs> listBlog = new BlogDAOImpl().getList();
		Gson son = new Gson();
		String data = son.toJson(listBlog);
		return data;
	}
	
	@GET
	@Path("/getById/{Id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("Id")Integer Id) {
		Blogs blog = new BlogDAOImpl().getById(Id);
		Gson son = new Gson();		
		String data = son.toJson(blog);
		return data;
	}
	
	@GET
	@Path("/searchByName/{Name}")
	@Produces(MediaType.APPLICATION_JSON)
	public String searchByName(@PathParam("Name") String name) {
		List<Blogs> listBlog = new BlogDAOImpl().searchByName(name);
		Gson son = new Gson();		
		String data = son.toJson(listBlog);
		return data;
	}
	
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(String blog) {
		Gson son = new Gson();
		Blogs objDTO = son.fromJson(blog, Blogs.class);
		boolean bl = new BlogDAOImpl().insert(objDTO);
		String data = son.toJson(bl);
		return data;
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String update(String blog) {
		Gson son = new Gson();
		Blogs objDTO = son.fromJson(blog, Blogs.class);
		boolean bl = new BlogDAOImpl().update(objDTO);
		String data = son.toJson(bl);
		return data;
	}
	
	@DELETE
    @Path("/delete/{Id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("Id")Integer Id) {
        Gson son = new Gson();      
        boolean bl = new BlogDAOImpl().delete(Id);
        String data = son.toJson(bl);
        return data;
    }
}
