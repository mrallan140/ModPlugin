package fr.mrallan140.modplugin;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class gui implements Listener {	
	static ItemStack plainte =  new ItemStack(Material.CHEST, 1);
	static ItemMeta plainteM = plainte.getItemMeta();
	static ItemStack visibilite = new ItemStack(Material.SEA_LANTERN, 1);
	static ItemMeta visibiliteM = visibilite.getItemMeta();	
	
	@EventHandler
	public void onCLickInv(InventoryClickEvent e) {
		if (e.getInventory().getTitle().equals("Menu de Moderation") && e.getInventory().getSize() == 36) {
			if (e.getCurrentItem().equals(plainte)) {
				e.setCancelled(true);
				Player p = (Player) e.getWhoClicked();
				p.setGameMode(GameMode.SPECTATOR);				
			}
		}
	}
	
	public static void OpenModoGUI(Player p){
		Inventory inv = Bukkit.createInventory(null, 36, "Menu de Moderation");
		//modif des ITEM META//
		plainteM.addEnchant(Enchantment.DURABILITY, 2555, true);
		visibiliteM.addEnchant(Enchantment.DURABILITY, 255, true);
		inv.setItem(13, getItem(Material.CHEST, 1, (byte)1, "JE SUIS UN COFFRE", Enchantment.DURABILITY, 255, Arrays.asList("Java", "Scala", "Groovy")));
		inv.setItem(22, visibilite);	
		p.openInventory(inv);
	}

	private static ItemStack getItem(Material material, int montant,byte data, String DisplayName, Enchantment enchant, int level, List<String> lore) {
		ItemStack i = new ItemStack(material, montant, data);
		ItemMeta iM = i.getItemMeta();
		iM.setDisplayName(DisplayName);
		iM.addEnchant(enchant, level, true);
		iM.setLore(lore);
		i.setItemMeta(iM);
		return i;
	}	
}
