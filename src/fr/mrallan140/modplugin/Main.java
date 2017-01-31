package fr.mrallan140.modplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable(){
        getCommand("modgui").setExecutor(new Commands());	
    	Bukkit.getPluginManager().registerEvents(new gui(), this);
    	getConfig().options().copyDefaults(true);
    	saveConfig();
    	System.out.println("Plugin Moderation ON !");
        
    }
    
    public void onDisable(){
        System.out.println("Plugin Moderation OFF !");
    }
    	
}
