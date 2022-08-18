package ml.maxht.helpfulgui.Listeners;

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

import java.lang.reflect.Array;
import java.util.ArrayList;

public class killlistener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Kill Gui")){
            Inventory sure = Bukkit.createInventory(p, 9, ChatColor.RED + "Kill GUI: Are You Sure?");
            ItemStack yes = new ItemStack(Material.GREEN_STAINED_GLASS);
            ItemMeta yesmeta = yes.getItemMeta();
            yesmeta.setDisplayName(ChatColor.GREEN + "Yes");
            ArrayList yeslore = new ArrayList<>();
            yeslore.add("Clicking Here WILL kill you");
            yesmeta.setLore(yeslore);
            yes.setItemMeta(yesmeta);
            ItemStack no = new ItemStack(Material.RED_STAINED_GLASS);
            ItemMeta nometa = no.getItemMeta();
            nometa.setDisplayName(ChatColor.RED + "No");
            ArrayList nolore = new ArrayList<>();
            nolore.add("Clicking here will exit the menu");
            nometa.setLore(nolore);
            no.setItemMeta(nometa);
            ItemStack nothing = new ItemStack(Material.BARRIER);
            ItemMeta nothmeta = nothing.getItemMeta();
            nothmeta.setDisplayName(ChatColor.YELLOW + "Nothing Here");
            ArrayList nothlore = new ArrayList<>();
            nothlore.add("Nothing Here!");
            nothmeta.setLore(nothlore);
            no.setItemMeta(nothmeta);
            sure.setItem(0, yes);
            sure.setItem(1, yes);
            sure.setItem(2, yes);
            sure.setItem(3, yes);
            sure.setItem(4, nothing);
            sure.setItem(5, no);
            sure.setItem(6, no);
            sure.setItem(7, no);
            sure.setItem(8, no);

            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Die")){
                p.openInventory(sure);
            }

            e.setCancelled(true);
        }

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Kill GUI: Are You Sure?")){
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Yes")){
                p.closeInventory();
                p.setHealth(0.0);
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "No")){
                p.closeInventory();
                p.sendMessage("You have chosen not to die.");
            }
            e.setCancelled(true);
        }


    }

}
