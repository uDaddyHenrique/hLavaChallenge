package me.henrique.lava.listeners;

import me.henrique.lava.menus.ServersMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class CompassInteractListener implements Listener {


    @EventHandler
    public void interactCompass(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack item = e.getItem();
        if(item == null || item.getType() == Material.AIR) return;
        if (item.getType() == Material.COMPASS &&
                item.hasItemMeta() &&
                item.getItemMeta().hasDisplayName() &&
                item.getItemMeta().getDisplayName().equals("§aServidores")) {
            if (e.getAction() == Action.RIGHT_CLICK_AIR ||
                    e.getAction() == Action.RIGHT_CLICK_BLOCK ||
                    e.getAction() == Action.LEFT_CLICK_AIR ||
                    e.getAction() == Action.LEFT_CLICK_BLOCK) {
                ServersMenu.openServersMenu(p);
            }
        }
    }
    @EventHandler
    public void onClickCompass(InventoryClickEvent e){
        ItemStack item = e.getCurrentItem();
        if(item == null || !item.hasItemMeta() || !item.getItemMeta().hasDisplayName() || item.getType() == Material.AIR) return;
        if(item.getType() != Material.COMPASS) return;

        if(item.getItemMeta().getDisplayName().equals("§aServidores")){
            e.setCancelled(true);
        }
    }
}