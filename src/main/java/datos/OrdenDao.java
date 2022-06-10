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
    
    public int createOrden(int idOrden, String idUsuario, int pizza, int cantidad, String descripcion) throws SQLException {
        String sql = "INSERT INTO ordenes(idOrden, idUsuario, pizza, cantidad, descripcion) VALUES (?, ?, ?, ?, ?)";
        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        ps.setInt(1, idOrden);
        ps.setString(2, idUsuario);
        ps.setInt(3, pizza);
        ps.setInt(4, cantidad);
        ps.setString(5, descripcion);
        rs = ps.executeQuery();
        Conexion.cerrar(cn, ps, rs);
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
            o.setIdOrden(rs.getInt("idOrden"));
            o.setIdUsuario(rs.getInt("idUsuario"));
            o.setIdPizza(rs.getInt("idPizza"));
            o.setCantidad(rs.getInt("cantidad"));
            o.setDescripcion(rs.getString("descripcion"));
            ordenes.add(o);
        }
        Conexion.cerrar(cn, ps, rs);
        return ordenes;
    }
    
    public Orden orden(int id) throws SQLException {
        String sql = "SELECT * FROM ordenes WHERE idOrden=?";
        Orden o = null;
        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            o = new Orden();
            o.setIdOrden(rs.getInt("idOrden"));
            o.setIdUsuario(rs.getInt("idUsuario"));
            o.setIdPizza(rs.getInt("idPizza"));
            o.setCantidad(rs.getInt("cantidad"));
            o.setDescripcion(rs.getString("descripcion"));            
        }
        Conexion.cerrar(cn, ps, rs);
        return o;
    }
    
    public int updateOrden(int idOrden, int idUsuario, int pizza , int cantidad, String descripcion) throws SQLException {
        String sql = "UPDATE ordenes SET idUsuario= ?, idPizza = ?, cantidad = ?, descripcion = ? WHERE idOrden=?";

        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        ps.setInt(1, idOrden);
        ps.setInt(2, idUsuario);
        ps.setInt(3, pizza);
        ps.setInt(4, cantidad);
        ps.setString(5, descripcion);
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
