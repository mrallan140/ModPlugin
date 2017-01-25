package fr.mrallan140.modplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(command.getName().equalsIgnoreCase("modgui")){
				fr.mrallan140.modplugin.gui.OpenModoGUI(p);
			}
		}
		return false;
	}

}
