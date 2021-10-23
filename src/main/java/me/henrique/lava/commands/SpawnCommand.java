package me.henrique.lava.commands;

import me.henrique.lava.Lava;
import me.henrique.lava.scheduler.SpawnScheduler;
import me.henrique.lava.utils.ItemBuilder;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SpawnCommand implements CommandExecutor {

    private Map<Player, Long> cooldown = new HashMap<>();

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
                p.sendMessage("§aVocê será teletransportado ao spawn em 3s");
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
