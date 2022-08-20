package ml.maxht.helpfulgui.Commands;

import ml.maxht.helpfulgui.Helpfulgui;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class admingui implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (Helpfulgui.getPlugin(Helpfulgui.class).getConfig().getBoolean("enableadmin")) {
            if (sender instanceof Player p) {
                if (p.hasPermission("helpfulgui.admin")) {
                    Inventory admin = Bukkit.createInventory(p, 9, ChatColor.YELLOW + "Admin Gui");
                    ItemStack ban = new ItemStack(Material.NETHERITE_AXE);
                    ItemMeta banmeta = ban.getItemMeta();
                    banmeta.setDisplayName(ChatColor.RED + "Ban");
                    ArrayList banlore = new ArrayList<>();
                    banlore.add("Choose a player to ban");
                    banmeta.setLore(banlore);
                    banmeta.addEnchant(Enchantment.DAMAGE_ALL, 100, true);
                    ban.setItemMeta(banmeta);
                    ItemStack playertp = new ItemStack(Material.ENDER_PEARL, 1);
                    ItemMeta tpmeta = playertp.getItemMeta();
                    tpmeta.setDisplayName(ChatColor.GREEN + "Teleport A Player");
                    ArrayList tplore = new ArrayList<>();
                    tplore.add("Choose a player to teleport");
                    tpmeta.addEnchant(Enchantment.SOUL_SPEED, 100, true);
                    tpmeta.setLore(tplore);
                    playertp.setItemMeta(tpmeta);
                    ItemStack kick = new ItemStack(Material.DIAMOND_BOOTS);
                    ItemMeta kickmeta = kick.getItemMeta();
                    kickmeta.setDisplayName(ChatColor.RED + "Kick");
                    ArrayList kicklore = new ArrayList<>();
                    kicklore.add("Choose a player to kick");
                    kickmeta.setLore(kicklore);
                    kickmeta.addEnchant(Enchantment.DAMAGE_ALL, 100, true);
                    kick.setItemMeta(kickmeta);
                    admin.setItem(0, ban);
                    admin.setItem(1, playertp);
                    admin.setItem(2, kick);

                    p.openInventory(admin);
                } else {
                    p.sendMessage(ChatColor.RED + "You do not have the correct permissions!");
                }
            } else {
                System.out.println("Only players can use this command!");
            }
        }
        return true;
    }
}
