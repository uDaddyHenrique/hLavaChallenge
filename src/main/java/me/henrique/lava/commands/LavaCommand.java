package me.henrique.lava.commands;

import me.henrique.lava.Lava;
import me.henrique.lava.holograms.Hologram;
import me.henrique.lava.manager.ArenaManager;
import me.henrique.lava.manager.SpawnManager;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LavaCommand implements CommandExecutor {

    private SpawnManager spawn;
    private ArenaManager arena;
    public static List<String> build = new ArrayList<>();


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
                p.sendMessage("§e/lava build §f- Ative/Desative o modo de build do servidor.");
                p.sendMessage("§e/lava sethologram <facil/medio/dificil/extremo> §f- Spawnar os hologramas de dificuldades.");
                p.sendMessage("§e/lava removehologram <easy/medium/hard/extreme/all> §f- Remover os hologramas de dificuldades.");
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
                if(args[0].equalsIgnoreCase("build")){
                    if(build.contains(p.getName())){
                        build.remove(p.getName());
                        p.sendMessage("§6§l[LAVA] §cVocê desativou o build.");
                        p.setGameMode(GameMode.ADVENTURE);
                    }else{
                        build.add(p.getName());
                        p.sendMessage("§6§l[LAVA] §aVocê ativou o build.");
                        p.setGameMode(GameMode.CREATIVE);
                    }
                    }
                }
                if(args.length == 1) {
                    if (args[0].equalsIgnoreCase("sethologram")) {
                        p.sendMessage("§cUtilize: /lava sethologram <type>");
                        return false;
                    }
                }
            if(args.length == 2){
                String type = args[1];
                if(type.equalsIgnoreCase("facil")){
                    Hologram.spawnEasyHologram(p);
                    p.sendMessage("§aHolograma fácil spawnado com sucesso.");
                    }
                if(type.equalsIgnoreCase("medio")){
                    Hologram.spawnMediumHologram(p);
                    p.sendMessage("§aHolograma médio spawnado com sucesso.");
                    }
                if(type.equalsIgnoreCase("dificil")){
                    Hologram.spawnHardHologram(p);
                    p.sendMessage("§aHolograma difícil spawnado com sucesso.");
                    }
                if(type.equalsIgnoreCase("extremo")){
                    Hologram.spawnExtremeHologram(p);
                    p.sendMessage("§aHolograma extremo spawnado com sucesso.");
                    }
                }
            if(args.length == 1) {
                if (args[0].equalsIgnoreCase("removehologram")) {
                    p.sendMessage("§cUtilize: /lava removehologram <type>.");
                    return false;
                        }
                    }
            if(args.length == 2){
                String type = args[1];
                if(type.equalsIgnoreCase("easy")){
                    Hologram.removeEasyHologram();
                    p.sendMessage("§aVocê removou todos hologramas fáceis.");
                    }
                if(type.equalsIgnoreCase("medium")){
                    Hologram.removeMediumHologram();
                    p.sendMessage("§aVocê removou todos hologramas médios.");
                    }
                if(type.equalsIgnoreCase("hard")){
                    Hologram.removeHardHologram();
                    p.sendMessage("§aVocê removou todos hologramas difíceis.");
                    }
                if(type.equalsIgnoreCase("extreme")){
                    Hologram.removeExtremeHologram();
                    p.sendMessage("§aVocê removou todos hologramas extremos.");
                    }
                if(type.equalsIgnoreCase("all")){
                    Hologram.removeAllHolograms();
                    p.sendMessage("§aVocê removeu todos hologramas existentes.");
                    }
                }
            }
        return false;
    }

    public static boolean isBuilder(Player p){
        return build.contains(p.getName());
    }
}
