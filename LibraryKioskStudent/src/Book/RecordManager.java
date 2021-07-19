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
import Student.Student;

import Book.BorrowBook;
import GUI.BookRecordGUI;
import JDBC.DBController;

public class RecordManager extends BookRecordGUI {

	
	private DBController dbCtrl;

	BorrowBook borrow = new BorrowBook();
	Student student = new Student();
	
    public RecordManager()
    {
        dbCtrl = new  DBController();
    }
    
    public void displayRecordBook()
    {
    	DefaultTableModel  recordBook = new DefaultTableModel();
    	recordBook.addColumn("ID");
    	recordBook.addColumn("ISBN");
    	recordBook.addColumn("Borrow_Date");
    	recordBook.addColumn("Return_Date");

        
    	try {
    		String sql = "SELECT * FROM history_book";
    		Connection conn = dbCtrl.getConnection();
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);

            
            while(rs.next()) 
            {
            	recordBook.addRow(new Object[]
            	{
            		rs.getString("ID"),
            		rs.getString("ISBN"),
            		rs.getString("Borrow_Date"),
            		rs.getString("Return_Date"),

            	});
            }
            
            
            rs.close();
            st.close();
            conn.close();
    		
            
            table.setModel(recordBook);
            table.setAutoResizeMode(0);
            table.getColumnModel().getColumn(0).setPreferredWidth(140);
            table.getColumnModel().getColumn(1).setPreferredWidth(140);
            table.getColumnModel().getColumn(2).setPreferredWidth(140);
            table.getColumnModel().getColumn(3).setPreferredWidth(140);

    	}
    	catch (Exception ex)
    	{
    		   ex.printStackTrace();
    	}
    }
    
    public int record(BookRecord bRecord )
    {
        String sql = "insert into history_book (ISBN, ID, Borrow_Date, Return_Date)\n" +
                        "values (?, ?, ?, ?);";

        bRecord.setBorrowDate(borrow.getBorrowDate());
        bRecord.setID(student.getID());
        
        int row = 0;
        try
        {
            Connection conn = dbCtrl.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, bRecord.getISBN());
            ps.setString(2, bRecord.getID());
            ps.setString(3, bRecord.getBorrowDate());
            ps.setString(4, bRecord.getReturnDate());

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