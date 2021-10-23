package me.henrique.lava.scoreboard;

import me.henrique.lava.Lava;
import me.henrique.lava.utils.ScoreAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ScoreboardLava {

    public static void updateScore(Player p ){

        ScoreAPI score = new ScoreAPI(" §b§lLAVA CHALLENGE");

        score.addLine("", 12);
        score.addLine("§aJogadores Online: §f" + Bukkit.getOnlinePlayers().size(), 11);
        score.addLine("§6Coins: §f" + Lava.getPlayerManager().getAccount(p.getName()).getAmount(), 10);
        score.addLine("", 9);
        score.addLine("§7myserver.com.br", 8);

        score.setScoreBoard(p);
    }
}
