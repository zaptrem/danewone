package com.zaptremworld.hubplug;

import java.util.logging.Logger;

import org.bukkit.event.Listener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;
import java.sql.Statement;
import java.sql.ResultSet;
import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.UserDoesNotExistException;



public class LoginListener implements Listener {
public Logger log;
Connection conn;
	public LoginListener(LoginPlugin plugin, Logger logger) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        log= logger;
        
    
	
	
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
	}
    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
    	
    	String user = event.getPlayer().getDisplayName();
    	double money;
		try {
			money = (Economy.getMoney(user));
		} catch (UserDoesNotExistException e) {
			// TODO Auto-generated catch block (not expected!!)
			money= -1;
			e.printStackTrace();
		}
    	log.info("User "+user+" has "+money+" zapbucks. ZING!");
    
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