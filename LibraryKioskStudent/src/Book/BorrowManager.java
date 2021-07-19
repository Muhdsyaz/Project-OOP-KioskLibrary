package Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

import Book.Book;
import GUI.ReturnBookGUI;
import JDBC.DBController;
import Student.Student;

public class BorrowManager extends ReturnBookGUI{
	
	private DBController dbCtrl;
	
	Student student = new Student();

    public BorrowManager()
    {
        dbCtrl = new  DBController();
    }
	
	 public void displayBorrowBook()
	    {
	    	DefaultTableModel  borrowBook = new DefaultTableModel();
	    	borrowBook.addColumn("ISBN");
	    	borrowBook.addColumn("ID");
	    	borrowBook.addColumn("Borrow_Date");

	        
	    	try {
	    		String sql = "SELECT * FROM borrow_book WHERE ID=?";
	    		Connection conn = dbCtrl.getConnection();
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, student.getID());
	            
	            ResultSet rs=ps.executeQuery();
	                        
	            while(rs.next()) 
	            {
	            	borrowBook.addRow(new Object[]
	            	{
	            		rs.getString("ISBN"),
	            		rs.getString("ID"),
	            		rs.getString("Borrow_Date"),

	            	});
	            }
	            
	            
	            rs.close();
	            ps.close();
	            conn.close();
	    		
	            
	            table.setModel(borrowBook);
	            table.setAutoResizeMode(0);
	            table.getColumnModel().getColumn(0).setPreferredWidth(140);
	            table.getColumnModel().getColumn(1).setPreferredWidth(140);
	            table.getColumnModel().getColumn(2).setPreferredWidth(140);

	    	}
	    	catch (Exception ex)
	    	{
	    		   ex.printStackTrace();
	    	}
	    }
	    
	    
	    
	    public int returnBook(BorrowBook borrow)
	    {
	        String sql = "delete from borrow_book\n" +
	                        "where ISBN = ? and ID = ?;";

	        borrow.setID(student.getID());
	        
	        int row = 0;
	        try
	        {
	            Connection conn = dbCtrl.getConnection();

	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, borrow.getISBN());
	            ps.setString(2, borrow.getID());

	            row = ps.executeUpdate();
	            ps.close();
	            conn.close();

	        }
	        catch (Exception ex)
	        {
	            ex.printStackTrace();
	        }

	        return row;

	    }
	
}