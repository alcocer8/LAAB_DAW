package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Orden;
import modelo.OrdenCliente;

public class OrdenClientesDao {

    public static void main(String[] args) throws SQLException {
        OrdenClientesDao ocDao = new OrdenClientesDao();

        ArrayList<OrdenCliente> ordenes = ocDao.EstadoOrdenCliente(1);
        for (OrdenCliente orden : ordenes) {
            System.out.println("nombre Piza: "+ orden.getNombrePizza());
        }

    }

    private Connection cn;
    private PreparedStatement ps;
    private ResultSet rs;

    public ArrayList<OrdenCliente> allOrdenCliente() throws SQLException {
        String sql = "SELECT * FROM ordenes \n"
                + "INNER JOIN clientes ON (ordenes.idCliente = clientes.idCliente)\n"
                + "INNER JOIN pizzas ON (ordenes.idPizza = pizzas.idPizza)\n"
                + "INNER JOIN estados ON (ordenes.idEstado= estados.idEstado);";
        ArrayList<OrdenCliente> ordenes = new ArrayList<OrdenCliente>();

        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            OrdenCliente oc = new OrdenCliente();
            oc.setIdOrden(rs.getString("idOrden"));
            oc.setIdCliente(rs.getInt("idCliente"));
            oc.setIdPizza(rs.getInt("idPizza"));
            oc.setCantidad(rs.getInt("cantidad"));
            oc.setNombrePizza(rs.getString(14));
            oc.setEstado(rs.getString(18));
            oc.setNombreCliente(rs.getString(7));
            oc.setApellidoCliente(rs.getString(8));
            oc.setTelefono(rs.getString("telefono"));
            oc.setEmail(rs.getString("email"));

            ordenes.add(oc);
        }
        Conexion.cerrar(cn, ps, rs);
        return ordenes;
    }

    public ArrayList<OrdenCliente> EstadoOrdenCliente(int idEstado) throws SQLException {
        String sql = "SELECT * FROM ordenes \n"
                + "INNER JOIN clientes ON (ordenes.idCliente = clientes.idCliente)\n"
                + "INNER JOIN pizzas ON (ordenes.idPizza = pizzas.idPizza)\n"
                + "INNER JOIN estados ON (ordenes.idEstado= estados.idEstado) \n"
                + "WHERE estados.idEstado = ?";
        ArrayList<OrdenCliente> ordenes = new ArrayList<OrdenCliente>();

        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        ps.setInt(1, idEstado);
        rs = ps.executeQuery();

        while (rs.next()) {
            OrdenCliente oc = new OrdenCliente();
            oc.setIdOrden(rs.getString("idOrden"));
            oc.setIdCliente(rs.getInt("idCliente"));
            oc.setIdPizza(rs.getInt("idPizza"));
            oc.setCantidad(rs.getInt("cantidad"));
            oc.setIdEstado(rs.getInt("idEstado"));
            oc.setNombrePizza(rs.getString(14));
            oc.setEstado(rs.getString(18));
            oc.setNombreCliente(rs.getString(7));
            oc.setApellidoCliente(rs.getString(8));
            oc.setTelefono(rs.getString("telefono"));
            oc.setEmail(rs.getString("email"));

            ordenes.add(oc);
        }
        Conexion.cerrar(cn, ps, rs);
        return ordenes;
    }

    public int deleteOrdenCliente(String idOrden) throws SQLException {
        String sql = "DELETE FROM ordenes WHERE idOrden = ?";

        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        ps.setString(1, idOrden);

        ps.executeUpdate();

        Conexion.cerrar(cn, ps, rs);
        return 1;
    }

}
