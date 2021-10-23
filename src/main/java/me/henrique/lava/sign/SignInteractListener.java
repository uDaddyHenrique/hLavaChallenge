package me.henrique.lava.sign;

import me.henrique.lava.Lava;
import me.henrique.lava.player.ItemsWarpLava;
import me.henrique.lava.player.PlayerObject;
import me.henrique.lava.scoreboard.ScoreboardLava;
import me.henrique.lava.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class SignInteractListener implements Listener {


    @EventHandler
    public void signInteract(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(e.getClickedBlock() == null || e.getClickedBlock().getType() == Material.AIR) return;
        if(!e.getClickedBlock().getType().equals(Material.WALL_SIGN)) return;
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
            Sign sign = (Sign) e.getClickedBlock().getState();
            if(sign.getLine(1).equalsIgnoreCase("§e§lSOUPAS")){
                Inventory inventory = Bukkit.createInventory(null, 54, "§7Sopas");
                for(int sopas =0; sopas <= inventory.getSize()-1; sopas++){
                    inventory.setItem(sopas, new ItemStack(Material.MUSHROOM_SOUP));
                }
                p.openInventory(inventory);
            }
            if(sign.getLine(1).equalsIgnoreCase("§e§lRECRAFT")){
                Inventory inventory = Bukkit.createInventory(null, 54, "§7Recraft");
                int item = 1;
                for(int recraft = 0; recraft <= inventory.getSize()-1; recraft++){
                    if(item == 1) inventory.setItem(recraft, new ItemStack(Material.BOWL, 64));
                    if(item == 2) inventory.setItem(recraft, new ItemStack(Material.RED_MUSHROOM, 64));
                    if(item == 3) inventory.setItem(recraft, new ItemStack(Material.BROWN_MUSHROOM, 64));
                    if(item == 4) inventory.setItem(recraft, new ItemStack(Material.INK_SACK, 64, (short) 3));
                    if(item>=4) item = 1;
                    item++;
                }
                p.openInventory(inventory);
            }
            if(sign.getLine(1).equalsIgnoreCase("§a§lFIM")){
                p.teleport(Lava.arena.getArena());
                PlayerObject object = Lava.getPlayerManager().getAccount(p.getName());
                object.setAmount(object.getAmount() + 5);
                p.getInventory().clear();
                ItemsWarpLava.setItems(p);
                p.sendMessage("§aVocê passou o lava challenge. §6+ 5 coins.");
            }
        }
    }
}
