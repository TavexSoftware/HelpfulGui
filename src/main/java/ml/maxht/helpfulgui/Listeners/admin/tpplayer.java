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

public class tpplayer implements Listener {

    @EventHandler
    public void playertp (InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "Admin Gui: Teleport Player")){
            if (e.getCurrentItem().getType().equals(Material.PLAYER_HEAD)){
                Player name = p.getServer().getPlayerExact(e.getCurrentItem().getItemMeta().getDisplayName());
                Inventory sure = Bukkit.createInventory(p, 9, ChatColor.GREEN + "Admin Gui: Teleport");
                ItemStack to = new ItemStack(Material.ENDER_PEARL);
                ItemMeta tometa = to.getItemMeta();
                tometa.setDisplayName(ChatColor.GREEN + "Tp To Player");
                ArrayList tolore = new ArrayList<>();
                tolore.add("Tp you to player");
                tometa.setLore(tolore);
                to.setItemMeta(tometa);
                ItemStack here = new ItemStack(Material.LEAD);
                ItemMeta heremeta = here.getItemMeta();
                heremeta.setDisplayName(ChatColor.RED + "Bring");
                ArrayList herelore = new ArrayList<>();
                herelore.add("Bring Player Here");
                heremeta.setLore(herelore);
                here.setItemMeta(heremeta);
                ItemStack nothing = new ItemStack(Material.PLAYER_HEAD);
                SkullMeta nothmeta = (SkullMeta) nothing.getItemMeta();
                nothmeta.setOwningPlayer(name);
                nothmeta.setDisplayName(ChatColor.YELLOW + e.getCurrentItem().getItemMeta().getDisplayName());
                ArrayList nothlore = new ArrayList<>();
                nothlore.add("Targeted Player");
                nothmeta.setLore(nothlore);
                nothing.setItemMeta(nothmeta);
                sure.setItem(0, to);
                sure.setItem(1, to);
                sure.setItem(2, to);
                sure.setItem(3, to);
                sure.setItem(4, nothing);
                sure.setItem(5, here);
                sure.setItem(6, here);
                sure.setItem(7, here);
                sure.setItem(8, here);
                p.closeInventory();
                p.openInventory(sure);
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Back")){
                p.closeInventory();
                p.performCommand("admin");
            }


            e.setCancelled(true);
        }

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "Admin Gui: Teleport")){
            Player p = (Player) e.getWhoClicked();
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Tp To Player")){
                Player target = p.getServer().getPlayerExact(e.getInventory().getItem(4).getItemMeta().getDisplayName());

            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Bring")){
                Player target = p.getServer().getPlayerExact(e.getInventory().getItem(4).getItemMeta().getDisplayName());
                p.closeInventory();
            }

            e.setCancelled(true);
        }

    }


}

