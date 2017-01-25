package fr.mrallan140.modplugin;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable(){
        	
    	PluginManager pm = getServer().getPluginManager();
    	pm.registerEvents(new GuiMod(this), this);
    	
    	System.out.println("Plugin Moderation ON !");
        
    }
    
    public void onDisable(){
        System.out.println("Plugin Moderation OFF !");
    }
    	
}
