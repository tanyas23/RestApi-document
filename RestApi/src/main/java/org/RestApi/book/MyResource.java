package org.RestApi.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("myresource")
@Produces(MediaType.APPLICATION_JSON)
public class MyResource {

	

	@Path("{bookid}")
    @GET
    public Book getbook(@PathParam("bookid") int bookid)  {
		
		BookDao bd=new BookDao();
		Book bi=new Book();
		bi=bd.getbookDao(bookid);
		return bi;
	
    }
	
	@Path("/post")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Book addBook(Book book)
	{
		BookDao bd=new BookDao();
		Book bi=new Book();
		try {
			bi=bd.addBookDao(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bi;
		
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
