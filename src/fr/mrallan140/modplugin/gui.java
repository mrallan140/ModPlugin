package fr.mrallan140.modplugin;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
import org.bukkit.potion.PotionType;


public class gui implements Listener {	
	
	static ItemStack border = getItem(Material.STAINED_GLASS_PANE, 1,(byte)15, ChatColor.BLACK+"-", null, null,null,null,0);
	static ItemStack vanish = getItem(Material.SEA_LANTERN, 1,(byte)0, ChatColor.RED+"Vanish Off", ChatColor.WHITE+"Vous rend invisible et",ChatColor.WHITE+"vous empeche de rammaser des objet", null,null,0);
	static ItemStack spectator = getItem(Material.CHEST, 1,(byte)0, "Spectateur", "Vous Passe en Gamemode Spectateur", null,null,null,0);
	static ItemStack adventure = getItem(Material.CHEST, 1,(byte)0, "Aventure", "Vous Passe en Gamemode Aventure", null,null,null,0);
	static ItemStack quit = getItem(Material.BARRIER, 1,(byte)0, "Quitter le Menu", null,null,null,Enchantment.DIG_SPEED,10);
	
	static ItemStack temps = getItem(Material.WATCH, 1, (byte)0, ChatColor.LIGHT_PURPLE+"Temps Continue", null, null, null, null, 0);
	static ItemStack nuit = getItem(Material.BED, 1, (byte)0, ChatColor.LIGHT_PURPLE+"Nuit", null, null, null, null, 0);
	static ItemStack matin = getItem(Material.YELLOW_FLOWER, 1, (byte)0, ChatColor.LIGHT_PURPLE+"Matin", null, null, null, null, 0);
	static ItemStack midi = getItem(Material.DOUBLE_PLANT, 1, (byte)0, ChatColor.LIGHT_PURPLE+"Midi", null, null, null, null, 0);
	static ItemStack soir = getItem(Material.JACK_O_LANTERN, 1, (byte)0, ChatColor.LIGHT_PURPLE+"Soir", null, null, null, null, 0);
	
	@EventHandler
	public void onCLickInv(InventoryClickEvent e) {
		if (e.getInventory().getTitle().equals(ChatColor.RED+"Menu de Moderation") && e.getInventory().getSize() == 45) {
			
			if (e.getCurrentItem().equals(spectator)) {
				Player p = (Player) e.getWhoClicked();
				p.setGameMode(GameMode.SPECTATOR);
				Replaceitem(e.getCurrentItem(), e.getInventory(), 13, adventure);
			}
			if (e.getCurrentItem().equals(adventure)) {
				Player p = (Player) e.getWhoClicked();
				p.setGameMode(GameMode.ADVENTURE);
				Replaceitem(e.getCurrentItem(), e.getInventory(), 13, spectator);
			}
			
			
			// GESTION DU TEMPS //
			if (e.getCurrentItem().equals(temps)) {
				Player p = (Player) e.getWhoClicked();
				if (p.getWorld().getGameRuleValue("doDaylightCycle") == "true") {
					p.getWorld().setGameRuleValue("doDaylightCycle", "false");
					ItemMeta tempsM = temps.getItemMeta();
					tempsM.setLore(Arrays.asList("Inactif"));
					temps.setItemMeta(tempsM);
					e.getInventory().setItem(10, temps);
				} else {
					p.getWorld().setGameRuleValue("doDaylightCycle", "true");
					ItemMeta tempsM = temps.getItemMeta();
					tempsM.setLore(Arrays.asList("Actif"));
					temps.setItemMeta(tempsM);
					e.getInventory().setItem(10, temps);
				}
			}
			if (e.getCurrentItem().equals(matin)) {
				Player p = (Player) e.getWhoClicked();
				p.getWorld().setTime(0);
			}
			if (e.getCurrentItem().equals(midi)) {
				Player p = (Player) e.getWhoClicked();
				p.getWorld().setTime(6000);
			}
			if (e.getCurrentItem().equals(soir)) {
				Player p = (Player) e.getWhoClicked();
				p.getWorld().setTime(12000);
			}
			if (e.getCurrentItem().equals(nuit)) {
				Player p = (Player) e.getWhoClicked();
				p.getWorld().setTime(18000);
			}
			// GESTION DU TEMPS /FIN //
			
			if(e.getCurrentItem().equals(vanish)) {
				Player p = (Player) e.getWhoClicked();
				if (p.getActivePotionEffects().contains(PotionType.INVISIBILITY)) {
					p.sendMessage("deja invisible");
				} else {
					p.sendMessage("tu est maintentant INVISIBLE");
					//p.addPotionEffect(PotionEffect);
				}
			}
			
			
			// QUIT //
			if(e.getCurrentItem().equals(quit)) {
				Player p = (Player) e.getWhoClicked();
				p.closeInventory();
			}
			e.setCancelled(true);
		}
	}
	
	private void Replaceitem(ItemStack i, Inventory inv, int index,ItemStack i2) {
		i.setAmount(i2.getAmount());
		i.setDurability(i2.getDurability());
		i.setData(i2.getData());
		i.setItemMeta(i2.getItemMeta());
		i.setType(i2.getType());
		i.addEnchantments(i2.getEnchantments());
		inv.setItem(index, i);
	}

	public static void OpenModoGUI(Player p){
		Inventory inv = Bukkit.createInventory(null, 45, ChatColor.RED+"Menu de Moderation");
		
		
		for (int i = 0; i <= 9; i++) {
			inv.setItem(i, border);
		}
		inv.setItem(17, border);
		inv.setItem(18, border);
		inv.setItem(26, border);
		inv.setItem(27, border);
		inv.setItem(35, border);
		inv.setItem(36, border);
		for (int i = 35; i <= 43; i++) {
			inv.setItem(i, border);
		}
		inv.setItem(44, quit);
		
		if (!p.getGameMode().equals(GameMode.SPECTATOR)){
			inv.setItem(13, spectator);
		} else {
			inv.setItem(13, adventure);
		}
		inv.setItem(22, vanish);
		ItemMeta tempsM = temps.getItemMeta();
		if (p.getWorld().getGameRuleValue("doDaylightCycle") == "true") {
			tempsM.setLore(Arrays.asList("Actif"));
		} else {
			tempsM.setLore(Arrays.asList("Inactif"));
		}
		temps.setItemMeta(tempsM);
		inv.setItem(10, temps);
		inv.setItem(19, nuit);
		inv.setItem(20, matin);
		inv.setItem(28, midi);
		inv.setItem(29, soir);
		p.openInventory(inv);
	}

	
	
	
	private static ItemStack getItem(Material material, int montant,byte data, String DisplayName, String lore1, String lore2, String lore3,Enchantment ench,int lvl) {
		ItemStack i = new ItemStack(material, montant, data);
		ItemMeta iM = i.getItemMeta();
		if (lvl != 0 && ench != null) {
			iM.addEnchant(ench, lvl, true);
		}
		iM.setDisplayName(DisplayName);
		if (!(lore1 == null && lore2 == null && lore3 == null)){
			iM.setLore(Arrays.asList(lore1, lore2, lore3));
		}
		i.setItemMeta(iM);
		return i;
	}	
}
