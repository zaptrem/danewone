package com.zaptremworld.hubplug;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sendMysql {
	
	try {                                // to do: add this to a config file
	    conn =
	       DriverManager.getConnection("jdbc:mysql://localhost/test?" +
	                                   "user=monty&password=greatsqldb");

	    // Do something with the Connection

	   
	} catch (SQLException ex) {
	    // handle any errors
		conn = null;
	    System.out.println("SQLException: " + ex.getMessage());
	    System.out.println("SQLState: " + ex.getSQLState());
	    System.out.println("VendorError: " + ex.getErrorCode());
	}
	
	public void writesql(){
		 Statement stmt = null;
		 ResultSet rs = null;

		 try {
			 // name is username and data is a table in the database
		     stmt = conn.createStatement();
		     rs = stmt.executeQuery("SELECT name FROM data");

		    

		     // Now do something with the ResultSet ....
		 }
		 catch (SQLException ex){
		     // handle any errors
		     System.out.println("SQLException: " + ex.getMessage());
		     System.out.println("SQLState: " + ex.getSQLState());
		     System.out.println("VendorError: " + ex.getErrorCode());
		 }
		 finally {
		     // it is a good idea to release
		     // resources in a finally{} block
		     // in reverse-order of their creation
		     // if they are no-longer needed

		     if (rs != null) {
		         try {
		             rs.close();
		         } catch (SQLException sqlEx) { } // ignore

		         rs = null;
		     }

		     if (stmt != null) {
		         try {
		             stmt.close();
		         } catch (SQLException sqlEx) { } // ignore

		         stmt = null;
		     }
		 }
		 
		 
		 
		 
		 
	}
}
