package ml.maxht.helpfulgui.Listeners;

import ml.maxht.helpfulgui.Helpfulgui;
import org.bukkit.BanList;
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
import java.util.Collections;

public class adminlistener implements Listener {

    @EventHandler
    public void onMenuClick (InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.YELLOW + "Admin Gui")) {



            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Ban")) {
                Inventory inv = Bukkit.createInventory(p, 54, ChatColor.RED + "Admin Gui: Ban Player");
                int i = 0;
                for (Player player : Bukkit.getOnlinePlayers()) {
                    ItemStack head = new ItemStack(Material.PLAYER_HEAD);
                    SkullMeta headmeta = (SkullMeta) head.getItemMeta();
                    headmeta.setOwnerProfile(player.getPlayerProfile());
                    headmeta.setDisplayName(player.getDisplayName());
                    headmeta.setLore(Collections.singletonList("Ban this player"));
                    head.setItemMeta(headmeta);
                    inv.setItem(inv.firstEmpty(), head);
                    i++;
                }
                ItemStack back = new ItemStack(Material.BARRIER, 1);
                ItemMeta backmeta = back.getItemMeta();
                backmeta.setDisplayName(ChatColor.RED + "Back");
                ArrayList backlore = new ArrayList<>();
                backlore.add("Go back to");
                backlore.add("Main admin screen");
                backmeta.setLore(backlore);
                back.setItemMeta(backmeta);
                inv.setItem(53, back);
                p.closeInventory();
                p.openInventory(inv);
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Teleport A Player")){
                Inventory inv = Bukkit.createInventory(p, 54, ChatColor.GREEN + "Admin Gui: Teleport Player");
                int i = 0;
                for (Player player : Bukkit.getOnlinePlayers()) {
                    ItemStack head = new ItemStack(Material.PLAYER_HEAD);
                    SkullMeta headmeta = (SkullMeta) head.getItemMeta();
                    headmeta.setOwnerProfile(player.getPlayerProfile());
                    headmeta.setDisplayName(player.getDisplayName());
                    headmeta.setLore(Collections.singletonList("Teleport this player"));
                    head.setItemMeta(headmeta);
                    inv.setItem(inv.firstEmpty(), head);
                    i++;
                }
                ItemStack back = new ItemStack(Material.BARRIER, 1);
                ItemMeta backmeta = back.getItemMeta();
                backmeta.setDisplayName(ChatColor.RED + "Back");
                ArrayList backlore = new ArrayList<>();
                backlore.add("Go back to");
                backlore.add("Main admin screen");
                backmeta.setLore(backlore);
                back.setItemMeta(backmeta);
                inv.setItem(53, back);
                p.closeInventory();
                p.openInventory(inv);
            }

            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Kick")){
                Inventory inv = Bukkit.createInventory(p, 54, ChatColor.GREEN + "Admin Gui: Kick Player");
                int i = 0;
                for (Player player : Bukkit.getOnlinePlayers()) {
                    ItemStack head = new ItemStack(Material.PLAYER_HEAD);
                    SkullMeta headmeta = (SkullMeta) head.getItemMeta();
                    headmeta.setOwnerProfile(player.getPlayerProfile());
                    headmeta.setDisplayName(player.getDisplayName());
                    headmeta.setLore(Collections.singletonList("Kick this player"));
                    head.setItemMeta(headmeta);
                    inv.setItem(inv.firstEmpty(), head);
                    i++;
                }
                ItemStack back = new ItemStack(Material.BARRIER, 1);
                ItemMeta backmeta = back.getItemMeta();
                backmeta.setDisplayName(ChatColor.RED + "Back");
                ArrayList backlore = new ArrayList<>();
                backlore.add("Go back to");
                backlore.add("Main admin screen");
                backmeta.setLore(backlore);
                back.setItemMeta(backmeta);
                inv.setItem(53, back);
                p.closeInventory();
                p.openInventory(inv);
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Stop Server")){
                Inventory sure = Bukkit.createInventory(p, 9, ChatColor.RED + "Stop Server: Delay?");
                ItemStack yes = new ItemStack(Material.CLOCK);
                ItemMeta yesmeta = yes.getItemMeta();
                yesmeta.setDisplayName(ChatColor.GREEN + "Delay");
                ArrayList yeslore = new ArrayList<>();
                yeslore.add("Waits 1 minute before stopping");
                yesmeta.setLore(yeslore);
                yes.setItemMeta(yesmeta);
                ItemStack no = new ItemStack(Material.TNT);
                ItemMeta nometa = no.getItemMeta();
                nometa.setDisplayName(ChatColor.RED + "Stop Now");
                ArrayList nolore = new ArrayList<>();
                nolore.add("Stops server immediately");
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

                }

            }

}


