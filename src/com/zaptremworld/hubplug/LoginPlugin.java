package com.zaptremworld.hubplug;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;



public class LoginPlugin extends JavaPlugin {
    public void onEnable() {
    		// Save a copy of the default config.yml if one is not there
            this.saveDefaultConfig();
        new LoginListener(this, getLogger());
        
    }
}