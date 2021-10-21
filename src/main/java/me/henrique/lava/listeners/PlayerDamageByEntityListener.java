package me.henrique.lava.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerDamageByEntityListener implements Listener {

    @EventHandler
    public void onDamageByEntity(EntityDamageByEntityEvent e){
        Player player = (Player) e.getEntity();
        Player attacker = (Player) e.getDamager();
        if(e.getDamager() == attacker){
            e.setCancelled(true);
        }
    }
}
