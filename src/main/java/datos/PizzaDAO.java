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

    public int createPizza(String nombre, String precio, String descripcion) {
        String sql = "INSERT INTO pizzas(nombre, precio, descripcion) VALUES(?,?,?)";
        try {
            cn = Conexion.conectar();
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, precio);
            ps.setString(3, descripcion);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            return 0;
        }
        return 1;
    }

    public ArrayList<Pizza> listaPizzas() {
        ArrayList<Pizza> pizzas = new ArrayList<>();
        String sql = "SELECT * FROM pizzas";

        try {
            cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            Pizza p = new Pizza();
            p.setId(rs.getInt("idPizza"));
            p.setNombre(rs.getString("nombre"));
            p.setPrecio(rs.getDouble("precio"));
            p.setDescripcion(rs.getString("descripcion"));
            pizzas.add(p);
        }

        cn.close();
        ps.close();
        rs.close();

        } catch (SQLException e) {
            return null;
        }
        return pizzas;
    }

    public Pizza buscaPizza(int id) throws SQLException {
        String sql = "SELECT * FROM pizzas WHERE id=?";
        Pizza p = new Pizza();
        cn = Conexion.conectar();
        ps = cn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            p.setId(rs.getInt("idPizza"));
            p.setNombre(rs.getString("nombre"));
            p.setPrecio(rs.getDouble("precio"));
            p.setDescripcion(rs.getString("descripcion"));
        }

        cn.close();
        ps.close();
        rs.close();

        return p;
    }

    public int deletePizza(int id) {
        String sql = "DELETE FROM pizzas WHERE id=?";
        try {
            cn = Conexion.conectar();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            cn.close();
            ps.close();
            rs.close();
        } catch (SQLException e) {
            return 0;
        }
        return 1;
    }

    public int updatePizza(int id, String nombre, String precio, String descripcion) {
        String sql = "UPDATE pizzas SET nombre=?, precio=?, descripcion=? WHERE id=?";
        try {
            cn = Conexion.conectar();
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, precio);
            ps.setInt(4, id);
            rs = ps.executeQuery();

            cn.close();
            ps.close();
            rs.close();
        } catch (SQLException e) {
            return 0;
        }
        return 1;
    }
}
