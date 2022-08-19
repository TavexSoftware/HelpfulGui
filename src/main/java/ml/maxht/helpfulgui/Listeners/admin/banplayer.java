package ml.maxht.helpfulgui.Listeners.admin;

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

public class banplayer implements Listener {

    @EventHandler
    public void onbanmenu (InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Admin Gui: Ban Player")) {

            if (e.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                Player playerban = p.getServer().getPlayerExact(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
                Inventory sure = Bukkit.createInventory(p, 9, ChatColor.RED + "Admin Gui: Really Ban?");
                ItemStack yes = new ItemStack(Material.GREEN_STAINED_GLASS);
                ItemMeta yesmeta = yes.getItemMeta();
                yesmeta.setDisplayName(ChatColor.GREEN + "Yes");
                ArrayList yeslore = new ArrayList<>();
                yeslore.add("Clicking Here WILL ban the player");
                yesmeta.setLore(yeslore);
                yes.setItemMeta(yesmeta);
                ItemStack no = new ItemStack(Material.RED_STAINED_GLASS);
                ItemMeta nometa = no.getItemMeta();
                nometa.setDisplayName(ChatColor.RED + "No");
                ArrayList nolore = new ArrayList<>();
                nolore.add("Clicking here will exit the menu");
                nometa.setLore(nolore);
                no.setItemMeta(nometa);
                ItemStack nothing = new ItemStack(Material.PLAYER_HEAD);
                SkullMeta nothmeta = (SkullMeta) nothing.getItemMeta();
                nothmeta.setOwningPlayer(playerban);
                nothmeta.setDisplayName(ChatColor.YELLOW + e.getCurrentItem().getItemMeta().getDisplayName());
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
            if (e.getCurrentItem().getType() == Material.BARRIER) {
                p.closeInventory();
                p.performCommand("admin");
            }
            e.setCancelled(true);
        }


        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Admin Gui: Really Ban?")){
            System.out.println("CLicked in Sure menu");
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Yes")){
                System.out.println("Clicked yes");
                p.closeInventory();
                String name = ChatColor.stripColor(e.getClick().name());
                p.getServer().getBanList(BanList.Type.NAME).addBan(name, "You have been banned from the server", null, p.getDisplayName());
                p.getServer().getPlayer(name).kickPlayer("You have been banned from the server");
                p.sendMessage("Banned Player");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "No")){
                p.closeInventory();
                Inventory inv = Bukkit.createInventory(p, 54, ChatColor.RED + "Admin Gui: Ban Player");
                int i = 0;
                for(Player player : Bukkit.getOnlinePlayers())
                {
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
                p.openInventory(inv);
            }
            e.setCancelled(true);

        }

    }

}
