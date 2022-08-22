package ml.maxht.helpfulgui.Listeners.admin;

import ml.maxht.helpfulgui.Helpfulgui;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class stopserver implements Listener {

    @EventHandler
    public void stopServer (InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Stop Server: Delay?")){
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Delay")) {
                Inventory sure = Bukkit.createInventory(p, 9, ChatColor.RED + "Stop Server Delay: Sure?");
                ItemStack yes = new ItemStack(Material.GREEN_STAINED_GLASS);
                ItemMeta yesmeta = yes.getItemMeta();
                yesmeta.setDisplayName(ChatColor.GREEN + "Yes");
                ArrayList yeslore = new ArrayList<>();
                yeslore.add("Clicking here WILL stop the server");
                yesmeta.setLore(yeslore);
                yes.setItemMeta(yesmeta);
                ItemStack no = new ItemStack(Material.RED_STAINED_GLASS);
                ItemMeta nometa = no.getItemMeta();
                nometa.setDisplayName(ChatColor.RED + "No");
                ArrayList nolore = new ArrayList<>();
                nolore.add("Exits the menu");
                nometa.setLore(nolore);
                no.setItemMeta(nometa);
                ItemStack nothing = new ItemStack(Material.BARRIER);
                ItemMeta nothmeta = nothing.getItemMeta();
                nothmeta.setDisplayName(ChatColor.YELLOW + "Nothing Here");
                ArrayList nothlore = new ArrayList<>();
                nothlore.add("Nothing Here!");
                nothmeta.setLore(nothlore);
                nothing.setItemMeta(nothmeta);
                sure.setItem(0, yes);
                sure.setItem(1, yes);
                sure.setItem(2, yes);
                sure.setItem(3, yes);
                sure.setItem(4, nothing);
                sure.setItem(5, no);
                sure.setItem(6, no);
                sure.setItem(7, no);
                sure.setItem(8, no);
                p.closeInventory();
                p.openInventory(sure);
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Stop Now")){
                Inventory sure = Bukkit.createInventory(p, 9, ChatColor.RED + "Stop Server No Delay: Sure?");
                ItemStack yes = new ItemStack(Material.GREEN_STAINED_GLASS);
                ItemMeta yesmeta = yes.getItemMeta();
                yesmeta.setDisplayName(ChatColor.GREEN + "Yes");
                ArrayList yeslore = new ArrayList<>();
                yeslore.add("Clicking here WILL stop the server");
                yesmeta.setLore(yeslore);
                yes.setItemMeta(yesmeta);
                ItemStack no = new ItemStack(Material.RED_STAINED_GLASS);
                ItemMeta nometa = no.getItemMeta();
                nometa.setDisplayName(ChatColor.RED + "No");
                ArrayList nolore = new ArrayList<>();
                nolore.add("Exits the menu");
                nometa.setLore(nolore);
                no.setItemMeta(nometa);
                ItemStack nothing = new ItemStack(Material.BARRIER);
                ItemMeta nothmeta = nothing.getItemMeta();
                nothmeta.setDisplayName(ChatColor.YELLOW + "Nothing Here");
                ArrayList nothlore = new ArrayList<>();
                nothlore.add("Nothing Here!");
                nothmeta.setLore(nothlore);
                nothing.setItemMeta(nothmeta);
                sure.setItem(0, yes);
                sure.setItem(1, yes);
                sure.setItem(2, yes);
                sure.setItem(3, yes);
                sure.setItem(4, nothing);
                sure.setItem(5, no);
                sure.setItem(6, no);
                sure.setItem(7, no);
                sure.setItem(8, no);
                p.closeInventory();
                p.openInventory(sure);
            }

            e.setCancelled(true);
        }if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Stop Server Delay: Sure?")){
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Yes")){
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendTitle(ChatColor.RED + "Server is stopping", ChatColor.YELLOW + "The Server Will Turn Off In 1 Minute", 10, 60, 10);
                }
                Bukkit.getScheduler().runTaskLater(Helpfulgui.getPlugin(Helpfulgui.class), () -> {
                    Bukkit.getServer().shutdown();
                }, 1200);
            }if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "No")){
                p.closeInventory();
                p.performCommand("admin");
            }
            e.setCancelled(true);
        }
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Stop Server No Delay: Sure?")){
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Yes")){
                Bukkit.getServer().shutdown();
            }if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "No")){
                p.closeInventory();
                p.performCommand("admin");
            }
            e.setCancelled(true);
        }
    }

}

