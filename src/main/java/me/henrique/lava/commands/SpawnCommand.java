package me.henrique.lava.commands;

import me.henrique.lava.Lava;
import me.henrique.lava.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
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
}
