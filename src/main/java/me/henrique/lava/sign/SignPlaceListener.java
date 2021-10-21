package me.henrique.lava.sign;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignPlaceListener implements Listener {

    @EventHandler
    public void signChange(SignChangeEvent e){
        Player p = e.getPlayer();
        if(e.getLine(0).equalsIgnoreCase("[sopa]")){
            e.setLine(0, "§6Lava Challenge");
            e.setLine(1, "§e§lSOUPAS");
            e.setLine(2, "§6Lava Challenge");
            p.sendMessage("§aPlaca de soupas setada.");
        }
        if(e.getLine(0).equalsIgnoreCase("[recraft]")){
            e.setLine(0, "§6Lava Challenge");
            e.setLine(1, "§e§lRECRAFT");
            e.setLine(2, "§6Lava Challenge");
            p.sendMessage("§aPlaca de recraft setada.");
        }
        if(e.getLine(0).equalsIgnoreCase("[fim]")) {
            e.setLine(0, "§6Lava Challenge");
            e.setLine(1, "§a§lFIM");
            e.setLine(2, "§6Lava Challenge");
            p.sendMessage("§aPlaca de fim setada.");
        }
    }
}
