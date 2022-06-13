package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Orden;

public class OrdenDao {

    private Connection cn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public int createOrden(String idOrden, int idCliente, int idPizza, int cantidad, int idEstado) throws SQLException {
        String sql = "INSERT INTO ordenes(idOrden, idCliente, idPizza, cantidad, idEstado) VALUES (?, ?, ?, ?, ?)";
        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        ps.setString(1, idOrden);
        ps.setInt(2, idCliente);
        ps.setInt(3, idPizza);
        ps.setInt(4, cantidad);
        ps.setInt(5, idEstado);
        ps.executeUpdate();
        
        Conexion.cerrar(ps);
        Conexion.cerrar(cn);
        return 1;
    }
    
    public ArrayList<Orden> allOrdenes() throws SQLException {
        String sql = "SELECT * FROM ordenes";
        ArrayList<Orden> ordenes = new ArrayList<>();
        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Orden o = new Orden();
            o.setIdOrden(rs.getString("idOrden"));
            o.setIdCliente(rs.getInt("idCliente"));
            o.setIdPizza(rs.getInt("idPizza"));
            o.setCantidad(rs.getInt("cantidad"));
            o.setIdEstado(rs.getInt("idEstado"));
            ordenes.add(o);
        }
        Conexion.cerrar(cn, ps, rs);
        return ordenes;
    }
    
    public ArrayList<Orden> allOrdenesEstado(int idEstado) throws SQLException {
        String sql = "SELECT * FROM ordenes WHERE idEstado = ?";
        ArrayList<Orden> ordenes = new ArrayList<>();
        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        ps.setInt(1, idEstado);
        rs = ps.executeQuery();
        while (rs.next()) {
            Orden o = new Orden();
            o.setIdOrden(rs.getString("idOrden"));
            o.setIdCliente(rs.getInt("idCliente"));
            o.setIdPizza(rs.getInt("idPizza"));
            o.setCantidad(rs.getInt("cantidad"));
            o.setIdEstado(rs.getInt("idEstado"));
            ordenes.add(o);
        }
        Conexion.cerrar(cn, ps, rs);
        return ordenes;
    }
    
    public Orden orden(String idOrden) throws SQLException {
        String sql = "SELECT * FROM ordenes WHERE idOrden=?";
        Orden o = null;
        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        ps.setString(1, idOrden);
        rs = ps.executeQuery();
        while (rs.next()) {
            o = new Orden();
            o.setIdOrden(rs.getString("idOrden"));
            o.setIdCliente(rs.getInt("idCliente"));
            o.setIdPizza(rs.getInt("idPizza"));
            o.setCantidad(rs.getInt("cantidad"));
            o.setIdEstado(rs.getInt("idEstado"));          
        }
        Conexion.cerrar(cn, ps, rs);
        return o;
    }
    
    public int updateOrden(int idOrden, int idCliente, int idPizza, int estado) throws SQLException {
        String sql = "UPDATE ordenes SET estado = ? WHERE idOrden= ? AND idCliente = ? AND idPizza = ?";

        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        ps.setInt(1, estado);
        ps.setInt(1, idOrden);
        ps.setInt(2, idCliente);
        ps.setInt(3, idPizza);
        
        rs = ps.executeQuery();

        Conexion.cerrar(cn, ps, rs);

        return 1;
    }
    
    public int deleteOrden(int idOrden) throws SQLException {
        String sql = "DELETE FROM ordenes WHERE idOrden = ?";
        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        ps.setInt(1, idOrden);
        rs = ps.executeQuery();

        Conexion.cerrar(cn, ps, rs);

        return 1;
    }

}
