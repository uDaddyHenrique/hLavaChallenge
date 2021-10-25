package me.henrique.lava.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AsyncPlayerChatListener implements Listener {

    private static Map<Player, Long> cooldown = new HashMap<>();

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if(cooldown.containsKey(p) && !(System.currentTimeMillis() >= cooldown.get(p))){
            p.sendMessage("§cAguarde " + convert(p) + "s para utilizar o chat novamente.");
            e.setCancelled(true);
            return;
        }else cooldown.remove(p);

        //IREI ADICIONAR UM COOLDOWN DE 3 SEGUNDOS.
        cooldown.put(p, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(3));
    }

    private Long convert(Player p) {
        long time = System.currentTimeMillis() - cooldown.get(p);
        return 1 + TimeUnit.MILLISECONDS.toSeconds(time) * -1;
    }
}
