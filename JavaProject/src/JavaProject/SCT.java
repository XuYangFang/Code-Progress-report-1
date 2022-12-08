package JavaProject;
import java.sql.*;

import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javafx.application.Application;


public class SCT {
	private static SCT sct=new SCT();
	public SCT() {
		try {
			
			String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			System.out.println("driver loaded");
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Database load failed"+e.getMessage());
		}
	}
	public static Connection getConn() {
		try{
			final String URL="jdbc:sqlserver://10.0.0.19:1433;databaseName=Inventory;";
			final String USER="sa";
			final String PASSWORD="123456";
			Connection conn=null;
			
			conn=DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println("successfully connected to the database");
			return conn;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Database connection failed"+e.getMessage());
			return null;
		}
	}

}

