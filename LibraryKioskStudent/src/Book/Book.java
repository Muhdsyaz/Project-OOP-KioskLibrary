package Book;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import JDBC.ConnectionDemo;
import JDBC.DBController;


public class Book {
	private static String bookISBN;
	private static String bookTitle;
	private static String bookAuthor;
	private static String bookPublisher;
	private static String yearOfPublish;
	
	public  String getBookISBN() {
		return bookISBN;
	}
	public  void setBookISBN(String bookISBN) {
		Book.bookISBN = bookISBN;
	}
	
	public  String getBookTitle() {
		return bookTitle;
	}
	public  void setBookTitle(String bookTitle) {
		Book.bookTitle = bookTitle;
	}
	public  String getBookAuthor() {
		return bookAuthor;
	}
	public  void setBookAuthor(String bookAuthor) {
		Book.bookAuthor = bookAuthor;
	}
	
	public  String getBookPublisher() {
		return bookPublisher;
	}
	public  void setBookPublisher(String bookPublisher) {
		Book.bookPublisher = bookPublisher;
	}
	
	public  String getYearOfPublish() {
		return yearOfPublish;
	}
	public  void setYearOfPublish(String yearOfPublish) {
		Book.yearOfPublish = yearOfPublish;
	}
	
	

    }
	
	
	
