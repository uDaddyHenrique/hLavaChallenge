package me.henrique.lava.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerDropListener implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        Player p = e.getPlayer();
        ItemStack item = e.getItemDrop().getItemStack();
        Material material = item.getType();
        if(material.equals(Material.BOWL) ||
        material.equals(Material.MUSHROOM_SOUP) ||
        material.equals(Material.RED_MUSHROOM) ||
        material.equals(Material.BROWN_MUSHROOM)) {
            e.getItemDrop().remove();
        }
        if(material.equals(Material.COMPASS) && item.getItemMeta().getDisplayName().equals("§aServidores")){
            e.setCancelled(true);
        }
    }
}
