package me.henrique.lava.database;

import me.henrique.lava.Lava;
import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {

    private Connection connection;

    private final String user;
    private final String password;
    private final String connection;
    private final String database;
    private int query;

    public MySQL(String connection, String user, String password, String database){
        this.connection = connection;
        this.user = user;
        this.password = password;
        this.database = database;
        this.query = 0;
        loadDatabase();
    }
    public void openConnection(){
        try {
            query++;
            if((connection != null) && (!connection.isClosed()))
                    return;

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + this.connection + "/" + this.database, this.user, this.password);
            System.out.println("[MySQL] Conectado ao MySQL com sucesso.");
        }catch (ClassNotFoundException | SQLException e){
            query--;
            e.getStackTrace();
            System.out.println("[MySQL] Ocorreu um erro ao tentar de conectar com a MySQL");
            Bukkit.getPluginManager().disablePlugin(Lava.getInstance());
        }
    }
    public void closeConnection(){
        query--;
        if(query <= 0){
            try{
                if(connection != null && !connection.isClosed())
                    connection.close();
            }catch (Exception e){
                System.out.println("[MySQL] Ocorreu um erro ao tentar fechar a conexão");
            }
        }
    }

    public Connection getConnection() {
        return this.connection;
    }
    private void loadDatabase(){
        openConnection();
        createTables();
        closeConnection();
    }
    private void createTable(String table, String columns){
        try {
            if((connection != null) && (!connection.isClosed())){
                Statement stm = connection.createStatement();
                stm.executeUpdate("CREATE TABLE IF NOT EXISTS " + table + " (" + columns + ");");
            }
        }catch (Exception e){
            System.out.println("[MySQL] Ocorreu um erro ao criar a tabela do MySQL");
        }
    }
    public void createTables(){
        createTable("informacoes", "nome varchar(16), coins int");
    }

}
