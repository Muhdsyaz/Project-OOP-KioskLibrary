package JDBC;

import java.sql.Connection;

import JDBC.DBController;

public class ConnectionDemo {
    public static void main (String [] args ) {


    	DBController  db = new DBController();
        try (Connection conn = db.getConnection())
        {
            System.out.print("Database successfully connected.\n");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    System.out.println("Quantity Double Decker Burger : ");
    }
}