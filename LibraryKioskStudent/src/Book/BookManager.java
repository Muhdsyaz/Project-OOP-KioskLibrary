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
import GUI.BorrowBookGUI;
import JDBC.DBController;
import Student.Student;


public class BookManager extends BorrowBookGUI{

	private DBController dbCtrl;

	Student student = new Student();
	
	
    public BookManager()
    {
        dbCtrl = new  DBController();
    }
	
    
    public void displayBook()
    {
    	
        DefaultTableModel  model = new DefaultTableModel();
        model.addColumn("ISBN");
        model.addColumn("Title");
        model.addColumn("Publisher");
        model.addColumn("Author");
        model.addColumn("YearOfPublish");
        
    	try {
    		String sql = "SELECT * FROM book";
    		Connection conn = dbCtrl.getConnection();
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);

           // System.out.println(student.getID());
            
            while(rs.next()) 
            {
            	model.addRow(new Object[]
            	{
            		rs.getString("ISBN"),
            		rs.getString("Title"),
            		rs.getString("Publisher"),
            		rs.getString("Author"),
            		rs.getString("YearOfPublish")
            	});
            }
            
            
            rs.close();
            st.close();
            conn.close();
    		
            
            table.setModel(model);
            table.setAutoResizeMode(0);
            table.getColumnModel().getColumn(0).setPreferredWidth(50);
            table.getColumnModel().getColumn(1).setPreferredWidth(150);
            table.getColumnModel().getColumn(2).setPreferredWidth(80);
            table.getColumnModel().getColumn(3).setPreferredWidth(100);
            table.getColumnModel().getColumn(4).setPreferredWidth(100);

    	}
    	catch (Exception ex)
    	{
    		   ex.printStackTrace();
    	}
    	
    }
    
    
    public int borrow(BorrowBook borrow)
    {
        String sql = "insert into borrow_book (ISBN, ID, BORROW_DATE)\n" +
                        "values (?, ?, ?);";

        borrow.setID(student.getID());
        
        int row = 0;
        try
        {
            Connection conn = dbCtrl.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, borrow.getISBN());
            ps.setString(2, borrow.getID());
            ps.setString(3, borrow.getBorrowDate());

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