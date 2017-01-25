package fr.mrallan140.modplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class gui {
	public static void OpenModoGUI(Player p){
		Inventory inv = Bukkit.createInventory(null, 36, "Menu de Moderation");
		
		p.openInventory(inv);
	}	
}
