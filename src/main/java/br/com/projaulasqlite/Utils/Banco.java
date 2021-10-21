package br.com.projaulasqlite.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {

    public static Connection getConnection(){
        Connection conn = null;
        String stringConnection = "jdbc:sqlite:C:\\tmp\\banco\\aula1.db";
        try {
            System.out.println("Inicio...");
            conn = DriverManager.getConnection(stringConnection);
            System.out.println("Conectou!");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
