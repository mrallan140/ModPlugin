package fr.mrallan140.modplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable(){
        System.out.println("Plugin Moderation ON !");
    }
    
    public void onDisable(){
        System.out.println("Plugin Moderation OFF !");
    }
    
    public void onPlayerJoin(PlayerJoinEvent e) {
       e.getJoinMessage();
       e.getPlayer().sendMessage("MDR BIENVNUE");
    }
    
    public void openGui(Player p){
    	p.getPlayer().sendMessage("LOL");
    	
    	
    }
}
