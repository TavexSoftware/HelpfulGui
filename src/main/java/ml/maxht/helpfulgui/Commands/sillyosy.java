package ml.maxht.helpfulgui.Commands;

import ml.maxht.helpfulgui.Helpfulgui;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class sillyosy implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p){
            if (p.hasPermission("helpfulgui.sillyosy")) {
                World w = Helpfulgui.getPlugin(Helpfulgui.class).getServer().getWorld(p.getWorld().getName());
                w.spawnEntity(p.getLocation(), EntityType.OCELOT);
                p.sendMessage(ChatColor.GREEN + "Spawned and Ocelot");
            }
        }

        return true;
    }
}
