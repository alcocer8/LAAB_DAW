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
            //Recuperando la accion
            String accion = req.getParameter("accion");
            
            //Recuperando la session
            HttpSession session = req.getSession();
            session.setAttribute("session", session);
            
            //Variables
            PizzaDAO pDao = new PizzaDAO();
            EmpleadoDAO eDAO = new EmpleadoDAO();
            OrdenDao oDao = new OrdenDao();
            OrdenClientesDao ocDao = new OrdenClientesDao();
            ArrayList<Pizza> pizzas = null;
            Double total = 0.0;
 
           switch (accion) {
                case "Carrito":
                    
                    ArrayList<Pizza> carrito = null;                    
                    //Si no existe el atributo carrito
                    if(session.getAttribute("Carrito") == null){
                        carrito = new ArrayList<Pizza>(); //Se crea un nuevo ArrayList
                    }else{
                        //Recupera y Castea el objeto recuperado
                        carrito = (ArrayList<Pizza>) session.getAttribute("Carrito");
                    }
                    
                    //Suma los precios de los productos
                    for (Pizza pizza : carrito) {
                        total += pizza.getPrecio();
                    }
                    
                    //Envio de atributos
                    req.setAttribute("Carrito", carrito);
                    req.setAttribute("Total", total);
                    
                    //Redireccionamientos a pagina con atributos
                    req.getRequestDispatcher("Carrito.jsp").forward(req, resp);
                    break;
                case "AgregarCarrito":
                    int band = 0;

                    //Si no existe el atributo carrito
                    if(session.getAttribute("Carrito") == null){
                        carrito = new ArrayList<Pizza>(); //Se crea un nuevo ArrayList
                    }else{
                        //Recupera y Castea el objeto recuperado
                        carrito = (ArrayList<Pizza>) session.getAttribute("Carrito");
                    }
                    
                    //Si no existe el id dentro del carrito
                    for (Pizza pizza : carrito) {
                        if(pizza.getId() == Integer.parseInt(req.getParameter("idPizza"))){
                            band++;
                        }
                    }
                    
                    //Agrega el producto al carrito
                    if(band == 0){
                        carrito.add(pDao.pizza(Integer.parseInt(req.getParameter("idPizza"))));
                    }
                    //Asignamos el carrito actual a la session
                    session.setAttribute("Carrito", carrito);
                    
                   //Envio de atributos
                    req.setAttribute("pizzas", pDao.allPizzas());
                    
                    carrito = null; //Limpiamos la variable
                    
                    //Redireccionamientos a pagina con atributos
                    req.getRequestDispatcher("Menu.jsp").forward(req, resp);
                    break;
                case "EliminarCarrito":
                    //Recuperamos el carrito actual del session
                    carrito = (ArrayList<Pizza>) session.getAttribute("Carrito");
                    
                    //Recuperamos el id de la pizza a eliminar
                    int id = Integer.parseInt(req.getParameter("idPizza"));
                    
                    //Buscamos el id en el carrito hasta encontrarlo
                    for(int i = 0; i < carrito.size(); i++){
                        if (carrito.get(i).getId() == id) {
                            carrito.remove(i); //Borramos el producto
                        }
                    }
                    
                    //Suma los precios de los productos
                    for (Pizza pizza : carrito) {
                        total += pizza.getPrecio();
                    }
                    //Envio de atributos
                    req.setAttribute("Carrito", carrito);
                    req.setAttribute("Total", total);
                    
                    //Limpiamos el carrito
                    carrito = null;
                    
                    //Redireccionamientos a pagina con atributos
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
            //Recupernado la session
            HttpSession session = req.getSession();
            session.setAttribute("session", session);
            
            //Variables
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
                    //Recuperamos el clientede la session actual
                    Cliente cliente = (Cliente) session.getAttribute("clienteSesion");
                    
                    //Recuperamos el carrito actual de la session
                    carrito = (ArrayList<Pizza>) session.getAttribute("Carrito");
                    
                    //Recuperamos la idOrden
                    String idOrden = req.getParameter("idOrden");
                    oDao = new OrdenDao();
                    
                    //Si tenemos contenido en el carrito realiza la creaccion de las ordenes
                    for (Pizza pizza : carrito) {
                        int cantidad = Integer.parseInt(req.getParameter(""+pizza.getId())); //Captura la cantidad de cada producto
                        oDao.createOrden(idOrden, cliente.getId(), pizza.getId(), cantidad, 1); //Crea la orden
                    }
                    //Elimina el carrito de la session
                    session.removeAttribute("Carrito");
                    
                    //Redireccionamientos a pagina con atributos
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
