package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection conectar() {
        String url = "jdbc:postgresql://localhost:5432/universidad";
        String user = "lorenzo";
        String pass = "lorenzo_2696";
        Connection conn = null;
        
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return conn;
    }
}