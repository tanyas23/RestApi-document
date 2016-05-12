package org.RestApi.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.PathParam;

public class BookDao {
	
	static Connection con;
	 Statement stmt;
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to a selected database...");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/booksdetail","root","root"); 
			System.out.println("Connected database successfully...");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	 public List<Book> getbookDaobookname(String bookname) throws SQLException
	 {
		 Book b;
		 List<Book> list=new ArrayList<Book>();
		 try {
	            stmt=con.createStatement();  
				 String sql = "SELECT * FROM books WHERE bookname='"+bookname+"'";
				
				// Where id_asp='"+ id +"'"
				 System.out.println("getting records from table...");
				 ResultSet rs = stmt.executeQuery(sql);
				 System.out.println(rs);
				 while(rs.next()){
					 
					 b = new Book();
						/*Retrieve one employee details 
						and store it in employee object*/
						b.setBookid(rs.getInt("bookid"));
						b.setBookname(rs.getString("bookname"));
						b.setAuthor(rs.getString("author"));
						
						//add each book to the list
						list.add(b);
				 }
				 
				
			} catch (SQLException e) {
				con.close();
				 System.out.println("connection closed");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
	 }
	 
	 public Book getbookDao(int bookid) throws SQLException
	 {
		 Book b=new Book();
		 try {
	            stmt=con.createStatement();  
				 String sql = "SELECT * FROM books WHERE bookid="+bookid;
				// String sql = "INSERT INTO books (bookname) " + "VALUES (" + "\"" + bookid + "\"" + ");";
				 System.out.println("getting records from table...");
				 ResultSet rs = stmt.executeQuery(sql);
				 int bookId = 0 ;
				 String bookname="";
				 String author="";
				 while(rs.next()){
			         //Retrieve by column name
			       bookId = rs.getInt("bookid");
			       bookname = rs.getString("bookname");
			       author = rs.getString("author");
				 }
				 System.out.println(bookId+""+bookname+""+author);
				 //Book bookob=new Book(bookId,);
				
				b.setBookid(bookId);
				b.setBookname(bookname);
				b.setAuthor(author);
				 
				
			} catch (SQLException e) {
				con.close();
				 System.out.println("connection closed");
				e.printStackTrace();
			}
			return b;
	 }
	 
	 public Book addBookDao(Book book) throws SQLException
	 {
		 int x=book.getBookid();
			String y=book.getBookname();
			String z=book.getAuthor();
			System.out.println(book.getBookid()+""+book.getBookname()+""+book.getAuthor());
			try {
				
				stmt=con.createStatement();  
				String sql = "insert into books values ('" + x +"','" + y + "','" + z + "')";
		        stmt.executeUpdate(sql);
				System.out.println("Inserted records into the table...");

				 
				
				
			} catch (SQLException e) {
				con.close();
				 System.out.println("connection closed");
				e.printStackTrace();
			}
			
			return book;
	 }
	 
	 public Book updateBookDao(Book book) throws SQLException
	 {
		 int x=book.getBookid();
			String y=book.getBookname();
			String z=book.getAuthor();
			System.out.println(book.getBookid()+""+book.getBookname()+""+book.getAuthor());
			try {
				
				stmt=con.createStatement();  
			
				
				String sql = "UPDATE books SET bookid='" + x +"',bookname= '" + y + "',author='" + z + "' WHERE bookid='"+x+"'";
				
		        stmt.executeUpdate(sql);
				System.out.println("update records into the table...");

				 
				 
				
			} catch (SQLException e) {
				con.close();
				 System.out.println("connection closed");
				e.printStackTrace();
			}
			
			return book; 
	 }
	 
	 public void deleteBookDao(int bookid) throws SQLException
	 {
		 try {
				
				stmt=con.createStatement();  
				
				
				
				String sql = "DELETE FROM books WHERE bookid='"+bookid+"'";
				
		        stmt.executeUpdate(sql);
				System.out.println("delete records from the table...");

				 
				
				
			} catch (SQLException e) {
				 con.close();
				 System.out.println("connection closed");
				e.printStackTrace();
			}
	 }
}
