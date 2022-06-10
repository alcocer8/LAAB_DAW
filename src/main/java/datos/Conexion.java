package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

    public static Connection conectar() {
        String url = "jdbc:postgresql://localhost:5432/lencho_pizza";
        String user = "lorenzo";
        String pass = "lorenzo_2696";
        Connection conn = null;
        
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return conn;
    }
    
    public static void cerrar(Connection cn, PreparedStatement ps, ResultSet rs) throws SQLException{
        cn.close();
        ps.close();
        rs.close();
    }
    
    public static void cerrar(Connection cn) throws SQLException{
        cn.close();
    }
    
    public static void cerrar(PreparedStatement ps) throws SQLException{
        ps.close();
    }
    
    public static void cerrar(ResultSet rs) throws SQLException{
        rs.close();
    }
            
}
