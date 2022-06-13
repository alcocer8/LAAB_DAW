package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Empleado;

public class EmpleadoDAO {
    private Connection cn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    
    public Empleado validaEmpleado(String usuario, String pass) throws SQLException{
        Empleado e = null;

        String sql = "SELECT * FROM empleados WHERE usuario = ? AND password = ?";

        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        ps.setString(1, usuario);
        ps.setString(2, pass);
        
        rs = ps.executeQuery();

        while (rs.next()) {
            e = new Empleado();
            e.setId(rs.getInt("idEmpleado"));
            e.setUsuario(rs.getString("usuario"));
            e.setNombre(rs.getString("nombre"));
            e.setApellido(rs.getString("apellido"));
            e.setPuesto(rs.getInt("puesto"));
        }
        
        Conexion.cerrar(cn);
        Conexion.cerrar(ps);
        Conexion.cerrar(rs);
        
        return e;
    }
    
    public int createEmpleado(String nombre, String apellido,String usuario, String password, int puesto) throws SQLException{
        String sql = "INSERT INTO empleados(nombre, apellido, usuario, password, puesto) VALUES (?,?,?,?,?)";
        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setString(2, apellido);
        ps.setString(3, usuario);
        ps.setString(4, password);
        ps.setInt(5, puesto);
        
        ps.executeUpdate();

        Conexion.cerrar(cn);
        Conexion.cerrar(ps);
        
        return 1;
    } 
    
    public ArrayList<Empleado> allEmpleados() throws SQLException{
        ArrayList<Empleado> em = new ArrayList<Empleado>();
        String sql = "SELECT * FROM empleados";
        
        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
            Empleado e = new Empleado();
            e.setId(rs.getInt("idEmpleado"));
            e.setNombre(rs.getString("nombre"));
            e.setApellido(rs.getString("apellido"));
            e.setUsuario(rs.getString("usuario"));
            e.setPassword(rs.getString("password"));
            e.setPuesto(rs.getInt("puesto"));
            em.add(e);
        }
        
        Conexion.cerrar(cn);
        Conexion.cerrar(ps);
        Conexion.cerrar(rs);
        
        return em;
    }
    
    public Empleado empleado(int idEmpleado) throws SQLException{
        Empleado e = e = new Empleado();
        String sql = "SELECT * FROM empleados WHERE idEmpleado = ?";
        
        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        ps.setInt(1, idEmpleado);
        rs = ps.executeQuery();
        while(rs.next()){
            e.setId(rs.getInt("idEmpleado"));
            e.setNombre(rs.getString("nombre"));
            e.setApellido(rs.getString("apellido"));
            e.setUsuario(rs.getString("usuario"));
            e.setPassword(rs.getString("password"));
            e.setPuesto(rs.getInt("puesto"));
        }
        
        Conexion.cerrar(cn);
        Conexion.cerrar(ps);
        Conexion.cerrar(rs);
        
        return e;
    }
    
    public int updateEmpleado(int id, String nombre, String apellido, String usuario, String password, int puesto) throws SQLException{
        String sql = "UPDATE empleados SET nombre = ?, apellido = ?, usuario = ?, password=?, puesto = ? WHERE idEmpleado=?";
        
        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setString(2, apellido);
        ps.setString(3, usuario);
        ps.setString(4, password);
        ps.setInt(5, puesto);
        ps.setInt(6, id);
        ps.executeUpdate();
        
        Conexion.cerrar(ps);
        Conexion.cerrar(cn);
        return 1;
    }
    
    
    
    public int deleteEmpleado(int idEmpleado) throws SQLException{
        String sql = "DELETE FROM empleados WHERE idEmpleado = ?";
        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        ps.setInt(1, idEmpleado);
        ps.executeUpdate();
        
        Conexion.cerrar(ps);
        Conexion.cerrar(cn);
        return 1;
    }
    
    public int lastEmpleado()throws SQLException{
        String sql = "SELECT idEmpleado FROM empleados ORDER  BY idEmpleado DESC LIMIT 1";
        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        rs = ps.executeQuery();
        rs.next();
        
        int dato = rs.getInt(1);
        
        Conexion.cerrar(cn);
        Conexion.cerrar(ps);
        Conexion.cerrar(rs);
        
        return dato;
    }

}