package fr.mrallan140.modplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(command.getName().equalsIgnoreCase("modgui")){
				fr.mrallan140.modplugin.gui.OpenModoGUI(p);
				return true;
			} else { 
				sender.sendMessage(ChatColor.RED+"Vous devez etre un jouuer pour executer cette commande"); 
				return true;
			}
		}
		return false;
	}

}
