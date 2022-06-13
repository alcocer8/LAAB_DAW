package controlador;

import datos.ClienteDao;
import datos.EmpleadoDAO;
import datos.OrdenClientesDao;
import datos.OrdenDao;
import datos.PizzaDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Orden;
import modelo.OrdenCliente;
import modelo.Pizza;

@WebServlet("/ControladorCliente")
public class ControladorCliente extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String accion = req.getParameter("accion");
            PizzaDAO pDao = new PizzaDAO();
            EmpleadoDAO eDAO = new EmpleadoDAO();
            OrdenDao oDao = new OrdenDao();
            OrdenClientesDao ocDao = new OrdenClientesDao();
            HttpSession session = req.getSession();
            session.setAttribute("session", session);
            ArrayList<Pizza> pizzas = null;
            Double total = 0.0;
 
           switch (accion) {
                case "Carrito":
                    ArrayList<Pizza> carrito = null;                    
                    if(session.getAttribute("Carrito") == null){
                        carrito = new ArrayList<Pizza>();
                    }else{
                        carrito = (ArrayList<Pizza>) session.getAttribute("Carrito");
                    }
                    
                    for (Pizza pizza : carrito) {
                        total += pizza.getPrecio();
                    }
                    
                    req.setAttribute("Carrito", carrito);
                    req.setAttribute("Total", total);
                    
                    req.getRequestDispatcher("Carrito.jsp").forward(req, resp);
                    break;
                case "AgregarCarrito":
                    int band = 0;

                    if(session.getAttribute("Carrito") == null){
                        carrito = new ArrayList<Pizza>();
                    }else{
                        carrito = (ArrayList<Pizza>) session.getAttribute("Carrito");
                    }
                    
                    for (Pizza pizza : carrito) {
                        if(pizza.getId() == Integer.parseInt(req.getParameter("idPizza"))){
                            band++;
                        }
                    }
                    
                    if(band == 0){
                        carrito.add(pDao.pizza(Integer.parseInt(req.getParameter("idPizza"))));
                    }
                    
                    session.setAttribute("Carrito", carrito);
                    
                    req.setAttribute("pizzas", pDao.allPizzas());
                    carrito = null;
                    req.getRequestDispatcher("Menu.jsp").forward(req, resp);
                    break;
                case "EliminarCarrito":
                    
                    carrito = (ArrayList<Pizza>) session.getAttribute("Carrito");
                    int id = Integer.parseInt(req.getParameter("idPizza"));
                    for(int i = 0; i < carrito.size(); i++){
                        if (carrito.get(i).getId() == id) {
                            carrito.remove(i);
                        }
                    }
                    
                    for (Pizza pizza : carrito) {
                        total += pizza.getPrecio();
                    }
                    
                    req.setAttribute("Carrito", carrito);
                    req.setAttribute("Total", total);
                    carrito = null;
                    req.getRequestDispatcher("Carrito.jsp").forward(req, resp);
                    break;
                
                default:
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            session.setAttribute("session", session);
            String accion = req.getParameter("accion");
            ClienteDao cDao = new ClienteDao();
            EmpleadoDAO edao = new EmpleadoDAO();
            PizzaDAO pDao = new PizzaDAO();
            OrdenClientesDao ocDao = new OrdenClientesDao();
            ArrayList<Pizza> carrito = null;
            OrdenDao oDao = null;
            Double total = 0.0;
            
            switch (accion) {
                case "Realizar Compra":
                    Cliente cliente = (Cliente) session.getAttribute("clienteSesion");
                    carrito = (ArrayList<Pizza>) session.getAttribute("Carrito");
                    String idOrden = req.getParameter("idOrden");
                    oDao = new OrdenDao();
                    for (Pizza pizza : carrito) {
                        int cantidad = Integer.parseInt(req.getParameter(""+pizza.getId()));
                        oDao.createOrden(idOrden, cliente.getId(), pizza.getId(), cantidad, 1);
                    }
                    
                    session.removeAttribute("Carrito");
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
