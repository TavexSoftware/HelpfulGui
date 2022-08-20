package ml.maxht.helpfulgui.Listeners.admin;

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

public class kickplayer implements Listener {

    @EventHandler
    public void kickgui (InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "Admin Gui: Kick Player")){

            if (e.getCurrentItem().getType().equals(Material.PLAYER_HEAD)){
                Player playerkick = p.getServer().getPlayerExact(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
                Inventory sure = Bukkit.createInventory(p, 9, ChatColor.GREEN + "Admin Gui: Really Kick?");
                ItemStack yes = new ItemStack(Material.GREEN_STAINED_GLASS);
                ItemMeta yesmeta = yes.getItemMeta();
                yesmeta.setDisplayName(ChatColor.GREEN + "Yes");
                ArrayList yeslore = new ArrayList<>();
                yeslore.add("Clicking Here WILL kick the player");
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
                nothmeta.setOwningPlayer(playerkick);
                nothmeta.setDisplayName(ChatColor.YELLOW + e.getCurrentItem().getItemMeta().getDisplayName());
                ArrayList nothlore = new ArrayList<>();
                nothlore.add("Targeted Player");
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
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Back")){
                p.closeInventory();
                p.performCommand("admin");
            }

            e.setCancelled(true);

        }

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "Admin Gui: Really Kick?")){

            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Yes")){
                String target = ChatColor.stripColor(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                p.getServer().getPlayer(target).kickPlayer(ChatColor.RED + "You were kicked");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "No")){
                p.closeInventory();
                p.performCommand("admin");
            }

        }


    }

}
