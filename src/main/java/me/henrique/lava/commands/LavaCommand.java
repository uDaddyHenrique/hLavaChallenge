package me.henrique.lava.commands;

import me.henrique.lava.Lava;
import me.henrique.lava.manager.ArenaManager;
import me.henrique.lava.manager.SpawnManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class LavaCommand implements CommandExecutor {

    private SpawnManager spawn;
    private ArenaManager arena;

    public LavaCommand(){
        this.spawn = Lava.spawn;
        this.arena = Lava.arena;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(!p.hasPermission("lava.admin")){
                p.sendMessage("§cVocê não tem permissão para executar esse comando.");
                return false;
            }
            if(args.length == 0){
                p.sendMessage("         §6§lLAVA CHALLANGE §f§l- HELP");
                p.sendMessage("");
                p.sendMessage("§e/lava setspawn §f- Setar o spawn do servidor.");
                p.sendMessage("§e/lava setlocal §f- Setar o local onde o player nasce após entrar na warp.");
                return false;
            }
            if(args.length == 1){
                if(args[0].equalsIgnoreCase("setspawn")) {
                    YamlConfiguration config;
                    File file;
                     this.spawn.setSpawn(p.getLocation());
                     file = new File(Lava.getInstance().getDataFolder(), "lobby.yml");
                     config = YamlConfiguration.loadConfiguration(file);
                     config.set("Spawn", this.spawn.getLocation(p.getLocation()));

                     try{
                         config.save(file);
                         p.sendMessage("§aVocê setou o spawn com sucesso.");
                     } catch (IOException e){
                         p.sendMessage("§cOcorreu algum erro ao tentar setar o spawn.");
                     }
                }
                if(args[0].equalsIgnoreCase("setlocal")){
                    YamlConfiguration config;
                    File file;
                    this.arena.setArena(p.getLocation());
                    file = new File(Lava.getInstance().getDataFolder(), "arena.yml");
                    config = YamlConfiguration.loadConfiguration(file);
                    config.set("Arena", this.spawn.getLocation(p.getLocation()));

                    try{
                        config.save(file);
                        p.sendMessage("§aVocê setou o local da warp lava.");
                    }catch (IOException e){
                        p.sendMessage("§cOcorreu um erro ao tentar criar o arquivo arena.yml");
                    }
                }
            }
        }
        return false;
    }
}
