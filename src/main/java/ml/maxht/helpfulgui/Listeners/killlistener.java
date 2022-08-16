package ml.maxht.helpfulgui.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class killlistener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){

        Player p = e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Kill Gui")){

            switch (e.getCurrentItem().getType()){
                case NETHERITE_SWORD:
                    p.closeInventory();
            }

            e.setCancelled(true);
        }


    }

}
