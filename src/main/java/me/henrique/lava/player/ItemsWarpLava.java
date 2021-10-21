package me.henrique.lava.player;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ItemsWarpLava {

    public static void setItems(Player p) {
        Inventory inv = p.getInventory();
        for (int i = 0; i <=inv.getSize()-1; i++) {
            p.getInventory().setItem(i, new ItemStack(Material.MUSHROOM_SOUP));
            p.getInventory().setItem(13, new ItemStack(Material.BOWL, 64));
            p.getInventory().setItem(14, new ItemStack(Material.RED_MUSHROOM, 64));
            p.getInventory().setItem(15, new ItemStack(Material.BROWN_MUSHROOM, 64));
        }
    }
}
