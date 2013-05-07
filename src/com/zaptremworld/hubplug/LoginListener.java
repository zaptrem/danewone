package com.zaptremworld.hubplug;

import java.util.logging.Logger;
import org.bukkit.configuration.file.FileConfiguration;
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
	public LoginListener(LoginPlugin plugin, Logger logger) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        log= logger;
        
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
    	new sendMysql(this, );
    }
 
	 
	 
 }
 
}