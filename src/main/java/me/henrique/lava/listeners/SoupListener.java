package me.henrique.lava.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class SoupListener implements Listener {

    public int vida = 8;

    @EventHandler
    public void interactSoup(PlayerInteractEvent e){
        if (e.getItem() == null)
            return;
        Player p = e.getPlayer();
        if (p.getHealth() < 20.0D && p.getItemInHand().getType() == Material.MUSHROOM_SOUP) {
            e.setCancelled(true);
            p.setHealth((p.getHealth() + this.vida >= 20.0D) ? 20.0D : (p.getHealth() + this.vida));
            p.setFoodLevel(20);
            e.getItem().setType(Material.BOWL);
        }
    }
}
