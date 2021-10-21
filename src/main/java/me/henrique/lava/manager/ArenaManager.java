package me.henrique.lava.manager;

import me.henrique.lava.Lava;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ArenaManager {

    private Location arena;

    public ArenaManager(){
        File file = new File(Lava.getInstance().getDataFolder(), "arena.yml");
        YamlConfiguration config;
        if(file.exists()){
            config = YamlConfiguration.loadConfiguration(file);
            if(!config.getString("Arena").isEmpty()){
                this.setArena(this.getLocation(config.getString("Arena")));
            }
        }
    }

    public Location getLocation(String linha) {
        World w = Bukkit.getWorld(linha.split(",")[0]);
        Double x = Double.parseDouble(linha.split(",")[1]);
        Double y = Double.parseDouble(linha.split(",")[2]);
        Double z = Double.parseDouble(linha.split(",")[3]);
        Float yaw = Float.parseFloat(linha.split(",")[4]);
        Float pit = Float.parseFloat(linha.split(",")[5]);
        return new Location(w, x, y, z, yaw, pit);
    }

    public String getLocation(Location loc) {
        World w = loc.getWorld();
        Double x = loc.getX();
        Double y = loc.getY();
        Double z = loc.getZ();
        Float yaw = loc.getYaw();
        Float pit = loc.getPitch();
        return w.getName() + "," + x + "," + y + "," + z + "," + yaw + "," + pit;
    }

    public Location getArena() {
        return arena;
    }

    public void setArena(Location arena) {
        this.arena = arena;
    }
}
