package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente;

public class ClienteDao{

    Connection cn;
    PreparedStatement ps;
    ResultSet rs;

    
    public int crearCliente(String nombre, String apellido, String telefono, String email){
        String sql = "INSERT INTO clientes(nombre, apellido, telefono, email) VALUES (?, ?, ?, ?)";
        try {
            cn = Conexion.conectar();
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, telefono);
            ps.setString(4, email);
            rs = ps.executeQuery();
            
            cn.close();
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error"+ e);
            return 0;
        }
        
        return 1;
    }
    
    public ArrayList<Cliente> buscarClientes() {
        String sql = "SELECT * FROM clientes";
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            cn = Conexion.conectar();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("idPizza"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setTelefono(rs.getString("telefono"));
                c.setCorreo(rs.getString("correo"));
                clientes.add(c);
            }
            cn.close();
            ps.close();
            rs.close();
        } catch (SQLException e) {
            return null;
        }
        return clientes;
    }

    public Cliente buscaCliente(int id) {
        String sql = "SELECT * FROM clientes WHERE idCliete=?";
        Cliente c = new Cliente();
        try {
            cn = Conexion.conectar();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt("idPizza"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setTelefono(rs.getString("telefono"));
                c.setCorreo(rs.getString("correo"));
            }
            cn.close();
            ps.close();
            rs.close();
        } catch (SQLException e) {
            return null;
        }
        return c;
    }

}
