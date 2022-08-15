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
                diemeta.setDisplayName(ChatColor.RED + "Die");
                die.setItemMeta(diemeta);
                killGui.setItem(1, die);
                ItemStack fill = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
                ItemMeta fillmeta = fill.getItemMeta();
                ArrayList filllore = new ArrayList<>();
                filllore.add("There is nothing here!");
                fillmeta.setLore(filllore);
                fillmeta.setDisplayName(ChatColor.YELLOW + "There is nothing here!");
                fill.setItemMeta(fillmeta);
                killGui.setItem(2, fill);
                killGui.setItem(3, fill);
                killGui.setItem(4, fill);
                killGui.setItem(5, fill);
                killGui.setItem(6, fill);
                killGui.setItem(7, fill);
                killGui.setItem(8, fill);
                killGui.setItem(9, fill);



                p.openInventory(killGui);
            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Helpfulgui.getPlugin(Helpfulgui.class).getConfig().getString("killguidisabledmessage")));
            }
        }else {
            System.out.println("Only Players Can Use This Command!");
        }

        return true;
    }
}
