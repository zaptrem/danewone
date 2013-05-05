package com.zaptremworld.hubplug;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.UserDoesNotExistException;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable(){
    	getLogger().info("Dashplug has been enabled! Cheers!");
    }
    
    @EventHandler
    public void getInfo(AsyncPlayerPreLoginEvent event) {
    	String user = "zaptrem";
    	double money;
		try {
			money = (Economy.getMoney(user));
		} catch (UserDoesNotExistException e) {
			// TODO Auto-generated catch block (not expected!!)
			money= -1;
			e.printStackTrace();
		}
    	getLogger().info("User"+user+"has"+money+"zapbucks. ZING!");
    
    }
    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event){
    	
    	getLogger().info("HE JOINED! RUNNN!");
    	
    }
    @Override
    public void onDisable() {
        getLogger().info("Dashplug has been disabled!?");
    }

}
