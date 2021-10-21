package me.henrique.lava.listeners;

import me.henrique.lava.Lava;
import me.henrique.lava.scoreboard.ScoreboardLava;
import me.henrique.lava.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        ScoreboardLava.updateScore(p);
        ItemStack warps = new ItemBuilder(Material.COMPASS).name("§aServidores").build();
        p.getInventory().clear();
        p.getInventory().setItem(4, warps);
        p.teleport(Lava.spawn.getSpawn());
    }
}
