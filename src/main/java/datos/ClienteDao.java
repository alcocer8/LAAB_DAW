package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente;

public class ClienteDao {

    Connection cn;
    PreparedStatement ps;
    ResultSet rs;

    public Cliente ingresarCliente(String email, String password) throws SQLException{
        Cliente c = null;
        String sql = "SELECT * FROM clientes WHERE email = ? AND pass = ?";
        cn = Conexion.conectar();
        ps = cn.prepareCall(sql);
        
        ps.setString(1, email);
        ps.setString(2, password);
        
        rs = ps.executeQuery();
        while(rs.next()){
            c = new Cliente();
            c.setId(rs.getInt("idCliente"));
            c.setNombre(rs.getString("nombre"));
            c.setApellido(rs.getString("apellido"));
            c.setEdad(rs.getInt("edad"));
            c.setTelefono(rs.getString("telefono"));
            c.setCorreo(rs.getString("email"));
            c.setPassword(rs.getString("pass"));
        }
        return c;
    }
    
    public int createCliente(String nombre, String apellido, String telefono, int edad, String email, String password) throws SQLException {
        String sql = "INSERT INTO clientes(nombre, apellido, edad, telefono, email, pass) VALUES (?, ?, ?, ?, ?, ?)";
        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setString(2, apellido);
        ps.setInt(3, edad);
        ps.setString(4, telefono);
        ps.setString(5, email);
        ps.setString(6, password);
        ps.executeUpdate();
        Conexion.cerrar(ps);
        Conexion.cerrar(cn);
        
        return 1;
    }

    public ArrayList<Cliente> allClientes() throws SQLException {
        String sql = "SELECT * FROM clientes";
        ArrayList<Cliente> clientes = new ArrayList<>();
        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Cliente c = new Cliente();
            c.setId(rs.getInt("idPizza"));
            c.setNombre(rs.getString("nombre"));
            c.setApellido(rs.getString("apellido"));
            c.setEdad(rs.getInt("edad"));
            c.setTelefono(rs.getString("telefono"));
            c.setCorreo(rs.getString("correo"));
            c.setPassword(rs.getString("pass"));
            clientes.add(c);
        }
        Conexion.cerrar(cn, ps, rs);
        return clientes;
    }

    public Cliente cliente(int id) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE idCliete=?";
        Cliente c = null;
        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            c = new Cliente();
            c.setId(rs.getInt("idPizza"));
            c.setNombre(rs.getString("nombre"));
            c.setApellido(rs.getString("apellido"));
            c.setEdad(rs.getInt("edad"));
            c.setTelefono(rs.getString("telefono"));
            c.setCorreo(rs.getString("correo"));
            c.setPassword(rs.getString("pass"));
        }
        Conexion.cerrar(cn, ps, rs);
        return c;
    }

    public int updateCliente(int id, String nombre, String apellido, int edad, String telefono, String email, String password) throws SQLException {
        String sql = "UPDATE clientes SET nombre = '?', apellido = '?', edad=? telefono = '?', correo='?', pass='?' WHERE id=?";

        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setString(2, apellido);
        ps.setInt(3, edad);
        ps.setString(4, telefono);
        ps.setString(5, email);
        ps.setString(6, email);
        ps.setInt(5, id);
        ps.executeUpdate();

        Conexion.cerrar(ps);
        Conexion.cerrar(cn);

        return 1;
    }

    public int deleteCliente(int idCliente) throws SQLException {
        String sql = "DELETE FROM clientes WHERE idCliente= ?";
        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        ps.setInt(1, idCliente);
        ps.executeUpdate();

        Conexion.cerrar(ps);
        Conexion.cerrar(cn);
        return 1;
    }
}
