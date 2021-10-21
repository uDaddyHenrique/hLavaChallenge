package me.henrique.lava.listeners;

import me.henrique.lava.Lava;
import me.henrique.lava.player.ItemsWarpLava;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ServerMenuInteractListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Inventory inv = e.getInventory();
        Player p = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();
        if(inv.getTitle().equals("§aMenu de Servidores")){
            e.setCancelled(true);

            if(item == null || !item.hasItemMeta() || !item.getItemMeta().hasDisplayName() || item.getType() ==
                    Material.AIR) return;

            if(item.getType() != Material.IRON_CHESTPLATE) return;
            if(item.getItemMeta().getDisplayName().equals("§aLava")){
                p.teleport(Lava.arena.getArena());
                ItemsWarpLava.setItems(p);
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage("§aVocê foi teleportado a warp lava challenge.");
            }
        }
    }
}
