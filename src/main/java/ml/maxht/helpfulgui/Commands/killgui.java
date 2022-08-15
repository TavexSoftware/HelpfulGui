package ml.maxht.helpfulgui.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import ml.maxht.helpfulgui.Helpfulgui;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class killgui implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p) {

            if (Helpfulgui.getPlugin(Helpfulgui.class).getConfig().getBoolean("enablekillgui") == true) {

                Inventory killGui = Bukkit.createInventory(p, 9, ChatColor.GREEN + "Kill Gui");
                ItemStack die = new ItemStack(Material.NETHERITE_SWORD, 1);
                ItemMeta diemeta = die.getItemMeta();
                ArrayList dielore = new ArrayList<>();
                dielore.add("Kill yourself instantly");
                diemeta.setLore(dielore);
                diemeta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
                die.setItemMeta(diemeta);
                p.openInventory(killGui);
                // TODO Add Rest of command from tutorial
            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Helpfulgui.getPlugin(Helpfulgui.class).getConfig().getString("killguidisabledmessage")));
            }
        }else {
            System.out.println("Only Players Can Use This Command!");
        }

        return true;
    }
}
