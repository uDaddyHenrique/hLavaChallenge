package me.henrique.lava.commands;

import me.henrique.lava.Lava;
import me.henrique.lava.utils.ItemBuilder;
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
                p.teleport(Lava.spawn.getSpawn());
                ItemStack warps = new ItemBuilder(Material.COMPASS).name("§aServidores").build();
                p.getInventory().clear();
                p.getInventory().setItem(4, warps);
                p.sendMessage("§aVocê foi teletransportado ao spawn com sucesso.");
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
