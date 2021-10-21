package me.henrique.lava.model;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

public class RecraftRecipe {

    public static void recraft(){

        ShapelessRecipe cactuSoup = new ShapelessRecipe(new ItemStack(Material.MUSHROOM_SOUP));
        cactuSoup.addIngredient(Material.BOWL);
        cactuSoup.addIngredient(Material.CACTUS);
        Bukkit.addRecipe(cactuSoup);

        ShapelessRecipe cocoabeansSoup = new ShapelessRecipe(new ItemStack(Material.MUSHROOM_SOUP));
        cocoabeansSoup.addIngredient(Material.BOWL);
        cocoabeansSoup.addIngredient(Material.INK_SACK, 3);
        Bukkit.addRecipe(cocoabeansSoup);
    }
}
