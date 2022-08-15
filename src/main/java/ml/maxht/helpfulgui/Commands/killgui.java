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

                if (Helpfulgui.getPlugin(Helpfulgui.class).getConfig().getBoolean("killguiperms") == true) {
                    if (p.hasPermission("helpfulgui.kill")) {
                        Inventory killGui = Bukkit.createInventory(p, 9, ChatColor.GREEN + "Kill Gui");
                        ItemStack die = new ItemStack(Material.NETHERITE_SWORD, 1);
                        ItemMeta diemeta = die.getItemMeta();
                        ArrayList dielore = new ArrayList<>();
                        dielore.add("Kill yourself instantly");
                        diemeta.setLore(dielore);
                        diemeta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
                        diemeta.setDisplayName(ChatColor.RED + "Die");
                        die.setItemMeta(diemeta);
                        ItemStack fill = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
                        ItemMeta fillmeta = fill.getItemMeta();
                        ArrayList filllore = new ArrayList<>();
                        filllore.add("There is nothing here!");
                        fillmeta.setLore(filllore);
                        fillmeta.setDisplayName(ChatColor.YELLOW + "There is nothing here!");
                        fill.setItemMeta(fillmeta);
                        ItemStack[] menuitems = {die, fill};
                        killGui.setContents(menuitems);
                        p.openInventory(killGui);
                    } else {
                        p.sendMessage(ChatColor.GREEN + "You do not have the correct perms!");
                    }
                } else if (Helpfulgui.getPlugin(Helpfulgui.class).getConfig().getBoolean("killguiperms") == false) {
                    Inventory killGui = Bukkit.createInventory(p, 9, ChatColor.GREEN + "Kill Gui");
                    ItemStack die = new ItemStack(Material.NETHERITE_SWORD, 1);
                    ItemMeta diemeta = die.getItemMeta();
                    ArrayList dielore = new ArrayList<>();
                    dielore.add("Kill yourself instantly");
                    diemeta.setLore(dielore);
                    diemeta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
                    diemeta.setDisplayName(ChatColor.RED + "Die");
                    die.setItemMeta(diemeta);
                    ItemStack fill = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
                    ItemMeta fillmeta = fill.getItemMeta();
                    ArrayList filllore = new ArrayList<>();
                    filllore.add("There is nothing here!");
                    fillmeta.setLore(filllore);
                    fillmeta.setDisplayName(ChatColor.YELLOW + "There is nothing here!");
                    fill.setItemMeta(fillmeta);
                    ItemStack[] menuitems = {die, fill};
                    killGui.setContents(menuitems);
                    p.openInventory(killGui);

                }
            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Helpfulgui.getPlugin(Helpfulgui.class).getConfig().getString("killguidisabledmessage")));
            }

            return true;
        } else {
            System.out.println("Only players can use this command!");
        }
        return true;
    }
}