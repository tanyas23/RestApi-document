package org.RestApi.book;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;


@Path("myresource")
@Produces(MediaType.APPLICATION_JSON)
public class MyResource {

	

	@Path("{bookid}")
    @GET
    public Book getbook(@PathParam("bookid") int bookid)  {
		
		BookDao bd=new BookDao();
		Book bi=new Book();
		try {
			bi=bd.getbookDao(bookid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bi;
	
    }
	

    @GET
    public List<Book> getbookbyname(@QueryParam("bookname") String bookname)  {
		
		BookDao bd=new BookDao();
		List<Book> bi=new ArrayList<Book>();
		try {
			bi=bd.getbookDaobookname(bookname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bi;
	
    }
	
	@Path("/post")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response addBook(Book book, @Context UriInfo uriinfo)
	{
		BookDao bd=new BookDao();
		Book bi=new Book();
		try {
			bi=bd.addBookDao(book);
		} catch (SQLException e) {
			e.printStackTrace();}
		
		return  Response.status(Status.CREATED)
				   .entity(bi)
				   .build();
		
	}
	
	@Path("/put")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Book updateBook(Book book)
	{
		BookDao bd=new BookDao();
		Book bi=new Book();
		try {
			bi=bd.updateBookDao(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bi;
		
	}
	
	
	@Path("/{bookid}")
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
	public void deleteBook(@PathParam("bookid") int bookid)
	{
		BookDao bd=new BookDao();
		try {
			bd.deleteBookDao(bookid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
