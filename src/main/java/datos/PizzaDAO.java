package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Pizza;

public class PizzaDAO {

    Connection cn;
    PreparedStatement ps;
    ResultSet rs;

    public int createPizza(String nombre, String precio, String descripcion) throws SQLException {
        String sql = "INSERT INTO pizzas(nombre, precio, descripcion) VALUES(?,?,?)";
        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setDouble(2, Double.parseDouble(precio));
        ps.setString(3, descripcion);
        ps.executeUpdate();
        Conexion.cerrar(cn);
        Conexion.cerrar(ps);
        return 1;
    }

    public ArrayList<Pizza> allPizzas() throws SQLException {
        ArrayList<Pizza> pizzas = new ArrayList<>();
        String sql = "SELECT * FROM pizzas";

        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()){
            Pizza p = new Pizza();
            p.setId(rs.getInt("idPizza"));
            p.setNombre(rs.getString("nombre"));
            p.setPrecio(rs.getDouble("precio"));
            p.setDescripcion(rs.getString("descripcion"));
            pizzas.add(p);
        }
        
        Conexion.cerrar(cn, ps, rs);
        return pizzas;
    }

    public Pizza pizza(int id) throws SQLException {
        String sql = "SELECT * FROM pizzas WHERE idPizza=?";
        Pizza p = null;
        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            p = new Pizza();
            p.setId(rs.getInt("idPizza"));
            p.setNombre(rs.getString("nombre"));
            p.setPrecio(rs.getDouble("precio"));
            p.setDescripcion(rs.getString("descripcion"));
        }

        Conexion.cerrar(cn, ps, rs);

        return p;
    }

    public int updatePizza(int id, String nombre, String precio, String descripcion) throws SQLException {
        String sql = "UPDATE pizzas SET nombre=?, precio=?, descripcion=? WHERE idPizza=?";
        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setDouble(2, Double.parseDouble(precio));
        ps.setString(3, descripcion);
        ps.setInt(4, id);
        ps.executeUpdate();

        Conexion.cerrar(ps);
        Conexion.cerrar(cn);
        return 1;
    }

    public int deletePizza(int id) throws SQLException {
        String sql = "DELETE FROM pizzas WHERE id=?";

        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        Conexion.cerrar(cn, ps, rs);

        return 1;
    }
}
