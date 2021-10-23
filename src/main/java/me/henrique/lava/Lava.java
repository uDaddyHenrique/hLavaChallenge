package me.henrique.lava;

import me.henrique.lava.commands.LavaCommand;
import me.henrique.lava.commands.SpawnCommand;
import me.henrique.lava.database.MySQL;
import me.henrique.lava.listeners.*;
import me.henrique.lava.manager.ArenaManager;
import me.henrique.lava.manager.SpawnManager;
import me.henrique.lava.model.RecraftRecipe;
import me.henrique.lava.player.PlayerManager;
import me.henrique.lava.scoreboard.ScoreboardLava;
import me.henrique.lava.sign.SignBreakListener;
import me.henrique.lava.sign.SignInteractListener;
import me.henrique.lava.sign.SignPlaceListener;
import me.henrique.lava.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.*;

public class Lava extends JavaPlugin {

    private static Lava instance;
    private static MySQL mySQL;
    private static PlayerManager playerManager;
    public static SpawnManager spawn;
    public static ArenaManager arena;
    public Lava (){
        instance = this;
    }

    @Override
    public void onEnable() {
        arena = new ArenaManager();
        spawn = new SpawnManager();
        loadConfig();
        playerManager = new PlayerManager();
        makeListeners();
        makeCommands();
        RecraftRecipe.recraft();
        Iterator var = Bukkit.getOnlinePlayers().iterator();
        while (var.hasNext()) {
            Player p = (Player) var.next();
            p.teleport(spawn.getSpawn());
            ItemStack warps = new ItemBuilder(Material.COMPASS).name("§aServidores").build();
            p.getInventory().clear();
            p.getInventory().setItem(4, warps);
        }
    }
    public void makeCommands(){
        getCommand("lava").setExecutor(new LavaCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
    }
    public void makeListeners(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoinListener(), this);
        pm.registerEvents(new CompassInteractListener(), this);
        pm.registerEvents(new ServerMenuInteractListener(), this);
        pm.registerEvents(new SoupListener(), this);
        pm.registerEvents(new PlayerDeathListener(), this);
        pm.registerEvents(new BlockBreakListener(), this);
        pm.registerEvents(new PlayerDamageListener(), this);
        pm.registerEvents(new PlayerDropListener(), this);
        pm.registerEvents(new PlayerRespawnListener(), this);
        pm.registerEvents(new PlayerDamageByEntityListener(), this);
        pm.registerEvents(new SignPlaceListener(), this);
        pm.registerEvents(new SignBreakListener(), this);
        pm.registerEvents(new SignInteractListener(), this);
    }

    private void loadConfig(){
        File file = new File(this.getDataFolder(), "config.yml");
        if (!file.exists()) {
            this.saveResource("config.yml", true);
        }

        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
            String host = config.getString("MySQL.host");
            String database = config.getString("MySQL.database");
            String user = config.getString("MySQL.user");
            String password = config.getString("MySQL.password");
            Integer port = config.getInt("MySQL.port");
            mySQL = new MySQL(user, password, host, port, database);
        }
    public static Lava getInstance(){
        return instance;
    }
    public static MySQL getMySQL() {
        return mySQL;
    }

    public static PlayerManager getPlayerManager() {
        return playerManager;
    }
}
