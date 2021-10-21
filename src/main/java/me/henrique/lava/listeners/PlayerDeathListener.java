package me.henrique.lava.listeners;

import me.henrique.lava.Lava;
import me.henrique.lava.player.ItemsWarpLava;
import me.henrique.lava.utils.ItemBuilder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        e.setDeathMessage(null);
        e.getDrops().clear();
        e.setDroppedExp(0);
    }
}

