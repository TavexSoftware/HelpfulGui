package ml.maxht.helpfulgui.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class adminlistener implements Listener {

    @EventHandler
    public void onMenuClick (InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.YELLOW + "Admin Menu")){


            switch (e.getCurrentItem().getType()) {

                case NETHERITE_AXE:
                    Inventory baninv = Bukkit.createInventory(p, 36, ChatColor.RED + "Ban Player");

            }
            e.setCancelled(true);
        }

    }

}
