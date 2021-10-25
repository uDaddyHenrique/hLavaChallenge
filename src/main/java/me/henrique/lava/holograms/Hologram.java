package me.henrique.lava.holograms;


import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Hologram {


    public static void spawnEasyHologram(Player p){
        ArmorStand easyHologram = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
        easyHologram.setVisible(false);
        easyHologram.setCustomName("§a§lFÁCIL");
        easyHologram.setGravity(false);
        easyHologram.setCustomNameVisible(true);
    }
    public static void spawnMediumHologram(Player p){
        ArmorStand easyHologram = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
        easyHologram.setVisible(false);
        easyHologram.setCustomName("§e§lMÉDIO");
        easyHologram.setGravity(false);
        easyHologram.setCustomNameVisible(true);
    }
    public static void spawnHardHologram(Player p){
        ArmorStand easyHologram = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
        easyHologram.setVisible(false);
        easyHologram.setCustomName("§c§lDIFÍCIL");
        easyHologram.setGravity(false);
        easyHologram.setCustomNameVisible(true);
    }
    public static void spawnExtremeHologram(Player p){
        ArmorStand easyHologram = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
        easyHologram.setVisible(false);
        easyHologram.setCustomName("§0§lEXTREMO");
        easyHologram.setGravity(false);
        easyHologram.setCustomNameVisible(true);
    }
    public static void removeEasyHologram(){
        for(World worlds : Bukkit.getWorlds()){
            for(Entity hologram : worlds.getEntities()){
                if(hologram.getCustomName() != null && hologram.getCustomName().equalsIgnoreCase("§a§lFÁCIL")){
                    hologram.remove();
                }
            }
        }
    }
    public static void removeMediumHologram(){
        for(World worlds : Bukkit.getWorlds()){
            for(Entity hologram : worlds.getEntities()){
                if(hologram.getCustomName() != null && hologram.getCustomName().equalsIgnoreCase("§e§lMÉDIO")){
                    hologram.remove();
                }
            }
        }
    }
    public static void removeHardHologram(){
        for(World worlds : Bukkit.getWorlds()){
            for(Entity hologram : worlds.getEntities()){
                if(hologram.getCustomName() != null && hologram.getCustomName().equalsIgnoreCase("§c§lDIFÍCIL")){
                    hologram.remove();
                }
            }
        }
    }
    public static void removeExtremeHologram(){
        for(World worlds : Bukkit.getWorlds()){
            for(Entity hologram : worlds.getEntities()){
                if(hologram.getCustomName() != null && hologram.getCustomName().equalsIgnoreCase("§0§lEXTREMO")){
                    hologram.remove();
                }
            }
        }
    }
    public static void removeAllHolograms(){
        for(World worlds : Bukkit.getWorlds()){
            for(Entity hologram : worlds.getEntities()){
                if(hologram != null && hologram.getType() == EntityType.ARMOR_STAND) {
                    hologram.remove();
                }
            }
        }
    }
}
