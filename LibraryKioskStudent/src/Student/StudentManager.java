package Student;

import Student.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JDBC.DBController;


public class StudentManager {

	private DBController dbCtrl;

    public StudentManager()
    {
        dbCtrl = new  DBController();
    }
	
	public int registerfx(Student student )
    {
        String sql = "insert into student (ID, NAME, PHONE, PASSWORD)\n" +
                        "values (?, ?, ?, ?);";

        int row = 0;
        try
        {
            Connection conn = dbCtrl.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getID());
            ps.setString(2, student.getName());
            ps.setString(3, student.getPhone());
            ps.setString(4, student.getPassword());

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
	
	public boolean loginfx(String id, String password) 
    {
        String sql = "SELECT * FROM student WHERE ID  = ? AND password = ?";

        try
        {
            Connection conn = dbCtrl.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                rs.close();
                ps.close();
                conn.close();
                return true;
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;

    }
	
}