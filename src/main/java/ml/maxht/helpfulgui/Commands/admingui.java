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
                    Inventory admin = Bukkit.createInventory(p, 18, ChatColor.YELLOW + "Admin Gui");
                    ItemStack title = new ItemStack(Material.PLAYER_HEAD);
                    SkullMeta titlemeta = (SkullMeta) title.getItemMeta();
                    titlemeta.setOwner("88f2cc0c-0386-44fb-ab1d-ab1b6d7f1dbb");
                    titlemeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Admin Gui");
                    ArrayList titlelore = new ArrayList<>();
                    title.setItemMeta(titlemeta);
                    admin.setItem(0, title);
                    titlelore.add("GUI By Orange_Max");
                    titlelore.add("With Tavex Software");
                    titlemeta.setLore(titlelore);
                    ItemStack ban = new ItemStack(Material.NETHERITE_AXE);
                    ItemMeta banmeta = ban.getItemMeta();
                    banmeta.setDisplayName(ChatColor.RED + "Ban");
                    ArrayList banlore = new ArrayList<>();
                    banlore.add("Choose a player to ban");
                    banmeta.setLore(banlore);
                    banmeta.addEnchant(Enchantment.DAMAGE_ALL, 100, true);
                    ItemStack playertp = new ItemStack(Material.ENDER_PEARL, 1);
                    ItemMeta tpmeta = playertp.getItemMeta();
                    tpmeta.setDisplayName(ChatColor.GREEN + "Teleport To Player");


                    admin.setItem(1, ban);
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
