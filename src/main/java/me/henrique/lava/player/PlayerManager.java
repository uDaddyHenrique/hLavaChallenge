package me.henrique.lava.player;

import me.henrique.lava.Lava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

    private List<PlayerObject> objects;

    public PlayerManager(){
        objects = new ArrayList<>();
    }

    private void createAccount(PlayerObject object){
        objects.add(object);
    }

    public PlayerObject getAccount(String name){
        for(PlayerObject user : objects){
            if(user.getName().equalsIgnoreCase(name)) return user;
        }
        return null;
    }
    public void savePlayer(PlayerObject object){
        try {
            Lava.getMySQL().openConnection();
            Connection connection = Lava.getMySQL().getConnection();

            PreparedStatement ps = connection.prepareStatement("UPDATE informacoes SET coins = '" + object.getAmount() + "' WHERE nome = '" + object.getName() + "'");
            ps.execute();
            ps.close();

            Lava.getMySQL().closeConnection();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void loadAccount(String name){
        try{
            Lava.getMySQL().openConnection();
            Connection connection = Lava.getMySQL().getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM informacoes WHERE nome = '" + name + "'");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                createAccount(new PlayerObject(rs.getString("nome"), rs.getInt("coins")));
            }else {
                ps = connection.prepareStatement("INSERT INTO informacoes VALUES ('" + name + "', '" + 0 + "')");
                ps.execute();
                ps.close();
                createAccount(new PlayerObject(name, 0));
            }

            Lava.getMySQL().closeConnection();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
