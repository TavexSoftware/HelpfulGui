package ml.maxht.helpfulgui.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class admingui implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player p) {
            Inventory admin = Bukkit.createInventory(p, 18, ChatColor.YELLOW + "Admin Gui");

        }
        return true;
    }
}
