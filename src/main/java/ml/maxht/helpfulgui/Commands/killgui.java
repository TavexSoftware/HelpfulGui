package ml.maxht.helpfulgui.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import ml.maxht.helpfulgui.Helpfulgui;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class killgui implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p) {

            if (Helpfulgui.getPlugin(Helpfulgui.class).getConfig().getBoolean("enablekillgui") == true) {
                // Stuff in here
                p.sendMessage("PlaceHolder");
            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Helpfulgui.getPlugin(Helpfulgui.class).getConfig().getString("killguidisabledmessage")));
            }
        }else {
            System.out.println("Only Players Can Use This Command!");
        }

        return true;
    }
}
