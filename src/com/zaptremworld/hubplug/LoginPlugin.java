package com.zaptremworld.hubplug;

import org.bukkit.plugin.java.JavaPlugin;

public class LoginPlugin extends JavaPlugin {
    public void onEnable() {
        new LoginListener(this, getLogger());
    }
}