package me.henrique.lava.scheduler;

import me.henrique.lava.Lava;
import me.henrique.lava.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SpawnScheduler {

    public void startScheduler(Player p){
        Bukkit.getScheduler().runTaskLater(Lava.getInstance(), () -> {
            p.teleport(Lava.spawn.getSpawn());
            ItemStack warps = new ItemBuilder(Material.COMPASS).name("§aServidores").build();
            p.getInventory().clear();
            p.getInventory().setItem(4, warps);
            p.sendMessage("§aVocê foi teletransportado ao spawn com sucesso.");
        }, 20*3);
   }
}
