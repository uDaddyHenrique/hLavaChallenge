package me.henrique.lava.sign;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class SignBreakListener implements Listener {


    @EventHandler
    public void onBreakSign(BlockBreakEvent e){
        if(!e.getBlock().getType().equals(Material.WALL_SIGN)) return;
        Sign sign = (Sign) e.getBlock().getState();
        if(sign.getLine(1).equalsIgnoreCase("§e§lSOUPAS") ||
                sign.getLine(1).equalsIgnoreCase("§e§lRECRAFT") ||
                sign.getLine(1).equalsIgnoreCase("§a§lFIM")){
            e.setCancelled(true);
        }
    }
}
