package me.henrique.lava.listeners;

import me.henrique.lava.Lava;
import me.henrique.lava.player.ItemsWarpLava;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawnListener implements Listener {

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e){
        Player p = e.getPlayer();
        e.setRespawnLocation(Lava.arena.getArena());
        ItemsWarpLava.setItems(p);
    }
}
