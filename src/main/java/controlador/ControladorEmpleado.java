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
import modelo.Pizza;

@WebServlet("/ControladorEmpleado")
public class ControladorEmpleado extends HttpServlet {

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
                case "dashboard":
                    req.setAttribute("Nuevo", ocDao.EstadoOrdenCliente(1));
                    req.setAttribute("Preparado", ocDao.EstadoOrdenCliente(2));
                    
                    req.setAttribute("Empleado", session.getAttribute("empleadoSesion"));
                    req.getRequestDispatcher("admin/dashboard.jsp").forward(req, resp);
                    break;
                case "AgregarPizza":
                    req.setAttribute("Empleado", session.getAttribute("empleadoSesion"));
                    req.getRequestDispatcher("admin/createPizza.jsp").forward(req, resp);
                    break;
                case "CrearEmpleado":
                    
                    req.setAttribute("Empleado", session.getAttribute("empleadoSesion"));
                    req.setAttribute("lastId", eDAO.lastEmpleado());
                    req.getRequestDispatcher("admin/createEmpleado.jsp").forward(req, resp);
                    break;
                case "ActualizarProductos":
                    req.setAttribute("Empleado", session.getAttribute("empleadoSesion"));
                    pizzas = pDao.allPizzas();
                    req.setAttribute("pizzas", pizzas);
                    req.getRequestDispatcher("admin/updatePizza.jsp").forward(req, resp);
                    break;
                case "ActualizarOrden":
                    
                    oDao.updateOrden(req.getParameter("idOrden"), Integer.parseInt(req.getParameter("idCliente")), Integer.parseInt(req.getParameter("idPizza")), Integer.parseInt(req.getParameter("idEstado")));

                    req.setAttribute("Nuevo", ocDao.EstadoOrdenCliente(1));
                    req.setAttribute("Preparado", ocDao.EstadoOrdenCliente(2));
                    req.setAttribute("Empleado", session.getAttribute("empleadoSesion"));
                    req.getRequestDispatcher("admin/dashboard.jsp").forward(req, resp);
                    break;
                case "EliminarOrden":

                    oDao.deleteOrden(req.getParameter("idOrden"), Integer.parseInt(req.getParameter("idCliente")), Integer.parseInt(req.getParameter("idPizza")));

                    req.setAttribute("Nuevo", ocDao.EstadoOrdenCliente(1));
                    req.setAttribute("Preparado", ocDao.EstadoOrdenCliente(2));
                    req.setAttribute("Empleado", session.getAttribute("empleadoSesion"));
                    req.getRequestDispatcher("admin/dashboard.jsp").forward(req, resp);
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
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
            int i = 0;

            req.setAttribute("Empleado", session.getAttribute("empleadoSesion"));
            switch (accion) {
                case "Seleccionar Pizza":
                    Pizza p = pDao.pizza(Integer.parseInt(req.getParameter("pizza")));
                    req.setAttribute("PizzaE", p);
                    req.getRequestDispatcher("admin/updatePizza.jsp").forward(req, resp);
                    break;
                case "Actualizar Pizza":
                    pDao.updatePizza(Integer.parseInt(req.getParameter("id")), req.getParameter("pizza"), req.getParameter("precio"), req.getParameter("descripcion"));
                    req.setAttribute("valor", "Pizza Actualizada");
                    req.setAttribute("pizzas", pDao.allPizzas());
                    req.getRequestDispatcher("admin/updatePizza.jsp").forward(req, resp);
                    break;
                case "Crear Pizza":
                    if (req.getParameter("pizza").isEmpty()) {
                        i++;
                    }

                    if (req.getParameter("precio").isEmpty()) {
                        i++;
                    }

                    if (req.getParameter("descripcion").isEmpty()) {
                        i++;
                    }
                    if (i == 0) {
                        pDao.createPizza(req.getParameter("pizza"), req.getParameter("precio"), req.getParameter("descripcion"));
                        req.setAttribute("valor", "La Pizza se creo con exito");
                        req.getRequestDispatcher("admin/createPizza.jsp").forward(req, resp);
                    } else {
                        req.setAttribute("valor", "Todos los campos son obligatorios");
                        req.getRequestDispatcher("admin/createPizza.jsp").forward(req, resp);
                    }

                    break;
                case "Crear Empleado":
                    
                    if (req.getParameter("nombre").isEmpty()) {
                        i++;
                    }

                    if (req.getParameter("apellido").isEmpty()) {
                        i++;
                    }

                    if (req.getParameter("usuario").isEmpty()) {
                        i++;
                    }

                    if (req.getParameter("pass").isEmpty()) {
                        i++;
                    }

                    if (req.getParameter("puesto") == null) {
                        i++;
                    }

                    if (i == 0) {
                        edao.createEmpleado(req.getParameter("nombre"), req.getParameter("apellido"), req.getParameter("usuario"), req.getParameter("pass"), Integer.parseInt(req.getParameter("puesto")));
                        req.setAttribute("valor", "El empleado se ingreso con exito");
                        req.getRequestDispatcher("admin/createEmpleado.jsp").forward(req, resp);
                    } else {
                        req.setAttribute("valor", "Todos los campos son obligatorios");
                        req.getRequestDispatcher("admin/createEmpleado.jsp").forward(req, resp);
                    }

                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
