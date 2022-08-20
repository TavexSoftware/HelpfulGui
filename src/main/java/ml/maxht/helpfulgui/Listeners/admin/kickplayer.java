package ml.maxht.helpfulgui.Listeners.admin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class kickplayer implements Listener {

    @EventHandler
    public void kickgui (InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "Admin Gui: Kick Player")){

            if (e.getCurrentItem().getType().equals(Material.PLAYER_HEAD)){

            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Back")){

            }

        }


    }

}
