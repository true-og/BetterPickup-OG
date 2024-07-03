package plugin;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		String prefix = "&7[&BBetterPickup&f-&4OG&7]";

		if (args.length <= 0 || args[0].equals("info")) {

			String info = prefix + " &eVersion 1.0";
			if (sender instanceof Player) {

				Utils.betterPickupOGMessage((Player) sender, info);

			}
			else {

				// Fetch the bukkit logger.
				Logger logger = Bukkit.getServer().getLogger();
				// Log the output to the console.
				logger.info(Utils.legacySerializerAnyCase(info).content());

			}

			return true;

		}
		else if (args[0].equals("reload")) {

			if (! sender.hasPermission("betterpickup.reload")) {

				// Since the sender doesn't have permission, it can't be the console, so sender can be casted directly to Player.
				// Send formatted message.
				Utils.betterPickupOGMessage((Player) sender, "&cERROR: You do not have permission to run this command.");

				return true;

			}

			// Reload config.
			BetterPickupOG.getPlugin().reload();

			// Store config reload string for reference.
			String reload = prefix + "&aConfig reloaded!";

			// Runs if a player sent the command...
			if (sender instanceof Player) {

				Utils.betterPickupOGMessage((Player) sender, reload);

			}
			// Runs if the console sent the command...
			else {

				// Fetch the bukkit logger.
				Logger logger = Bukkit.getServer().getLogger();
				// Log the output to the console.
				logger.info(Utils.legacySerializerAnyCase(reload).content());

			}

			return true;

		}
		else {

			return false;

		}

	}

}