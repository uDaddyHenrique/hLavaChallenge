package me.henrique.lava.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class ScoreAPI {

    private static Objective objective;
    private static Scoreboard scoreBoard;

    private String teamName(Scoreboard scoreBoard){
        String teamName = "team";
        teamName = teamName + scoreBoard.getTeams().size() + 1;
        return teamName;
    }
    public ScoreAPI (String title){
        scoreBoard = Bukkit.getScoreboardManager().getNewScoreboard();
        objective = scoreBoard.registerNewObjective("scoreapi", "dummy");
        objective.setDisplayName(title);
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
    }
    public static void addLine(String text, int line){
        Score score;

        text = (text.isEmpty() ? ChatColor.values()[line].toString() : text);

        int lenght = text.length();

        if(lenght <= 16){
            score = objective.getScore(text);
        }else{
            Team team = scoreBoard.getTeam(String.valueOf(line));
            if(team == null){
                team = scoreBoard.registerNewTeam(String.valueOf(line));
            }
            team.setPrefix(text.substring(0, 16));
            String entry;
            if(lenght < 32){
                entry = text.substring(16);
            }else{
                entry = text.substring(16, 32);
                team.setSuffix(text.substring(32));
            }
            team.addEntry(entry);
            score = objective.getScore(entry);
        }
        score.setScore(line);
    }

    public Scoreboard getScoreBoard(){
        return scoreBoard;
    }

    public void setScoreBoard(Player p){
        p.setScoreboard(scoreBoard);
    }

    public void setScoreBoard(Player... p){
        for(Player players : p){
            players.setScoreboard(scoreBoard);
        }
    }
}
