package me.henrique.lava.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemBuilder {

    private ItemStack item;

    public ItemBuilder(Material material){
        item = new ItemStack(material);
    }
    public ItemBuilder(ItemStack item){
        item = new ItemStack(item);
    }
    public ItemBuilder(Material material, int amount, short date){
        item = new ItemStack(material, amount, date);
    }
    public ItemBuilder name(String name){
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return this;
    }
    public ItemBuilder lore(String... lore){
        ItemMeta meta = item.getItemMeta();
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return this;
    }
    public ItemStack build(){
        ItemMeta meta = item.getItemMeta();
        item.setItemMeta(meta);
        return item;
    }
}
