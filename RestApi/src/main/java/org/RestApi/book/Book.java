package org.RestApi.book;

public class Book {

	int bookid;
	String bookname;
	String author;
	
	public Book() {
		
		
	}
	public Book(int bookid, String bookname, String author) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.author = author;
	}
	
	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
