package me.henrique.lava.commands;

import me.henrique.lava.Lava;
import me.henrique.lava.scheduler.SpawnScheduler;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SpawnCommand implements CommandExecutor {

    private Map<Player, Long> cooldown = new HashMap<>();
    int tempo = 3;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
                if(cooldown.containsKey(p) && !(System.currentTimeMillis() >= cooldown.get(p))){
                    p.sendMessage("§cAguarde " + convert(p) + "s para executar este comando novamente.");
                    return false;
                }else cooldown.remove(p);
            cooldown.put(p, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(5));
            if(args.length == 0){
                SpawnScheduler scheduler = new SpawnScheduler();
                scheduler.startScheduler(p);
                Bukkit.getScheduler().scheduleSyncRepeatingTask(Lava.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        if(tempo > 0){
                            p.sendTitle("§aTeleportando em...", "§7" + tempo + " §fsegundos.");
                            p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
                            tempo--;
                        }
                    }
                }, 0, 20);
                return true;
            }
        }
        return false;
    }

    private Long convert(Player p){
        long time = System.currentTimeMillis() - cooldown.get(p);
        return 1 + TimeUnit.MILLISECONDS.toSeconds(time) * -1;
    }
}
