package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDAO {
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public Empleado validar(String user, String pass){
        Empleado e = new Empleado();
        String sql = "SELECT * FROM emplados WHERE usuario=? AND password=?";
        
        try {
            cn = Conexion.conectar();
            ps = cn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()){
                e.setId(rs.getInt("id"));
                e.setUsuario(rs.getString("usuario"));
                e.setPassword(rs.getString("password"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellido"));
                e.setPuesto(rs.getInt("puesto"));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL: "+ ex);
        }
        
        return e;
    }
}
