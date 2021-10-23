package me.henrique.lava.scoreboard;

import me.henrique.lava.Lava;
import me.henrique.lava.utils.ScoreAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ScoreboardLava {

    public static void updateScore(Player p ){

        ScoreAPI score = new ScoreAPI(" §b§lLAVA CHALLENGE");

        score.addLine("", 12);
        score.addLine("§fCoins: §6" + Lava.getPlayerManager().getAccount(p.getName()).getAmount(), 11);
        score.addLine("", 10);
        score.addLine("§eorg.spigotmc.com.br", 9);

        score.setScoreBoard(p);
    }
}
