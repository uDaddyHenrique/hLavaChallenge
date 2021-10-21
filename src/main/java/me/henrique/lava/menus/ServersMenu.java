package me.henrique.lava.menus;

import me.henrique.lava.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ServersMenu {

    public static void openServersMenu(Player p){
        Inventory inv = Bukkit.createInventory(null, 27, "§aMenu de Servidores");
        ItemStack server = new ItemBuilder(Material.IRON_CHESTPLATE).name("§aLava").lore("§7Clique aqui para entrar!").build();
        inv.setItem(13,server);
        p.openInventory(inv);
    }
}
