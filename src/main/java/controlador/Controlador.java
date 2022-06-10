package controlador;

import datos.ClienteDao;
import datos.EmpleadoDAO;
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
import modelo.Pizza;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String accion = req.getParameter("accion");
            PizzaDAO pDao = new PizzaDAO();
            EmpleadoDAO eDAO = new EmpleadoDAO();
            HttpSession session = req.getSession();
            session.setAttribute("session", session);
            ArrayList<Pizza> pizzas = null;
 
           switch (accion) {
                case "Menu":
                    pizzas = pDao.allPizzas();
                    req.setAttribute("pizzas", pizzas);
                    req.getRequestDispatcher("Menu.jsp").forward(req, resp);
                    break;
                case "Ingresar":
                    req.setAttribute("Empleado", "Empleado");
                    req.getRequestDispatcher("Ingresar.jsp").forward(req, resp);
                    break;
                case "SalirUsuario":
                    session.removeAttribute("clienteSesion");
                    session.removeAttribute("empleadoSesion");
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                    break;
                case "Registro":
                    req.getRequestDispatcher("Registro.jsp").forward(req, resp);
                    break;
                case "Empleado":
                    req.getRequestDispatcher("admin/IngresarEmpleado.jsp").forward(req, resp);
                    break;
                case "dashboard":
                    req.getRequestDispatcher("admin/dashboard.jsp").forward(req, resp);
                    break;    
                case "AgregarPizza":
                    req.getRequestDispatcher("admin/createPizza.jsp").forward(req, resp);
                    break;
                case "CrearEmpleado":
                    req.setAttribute("lastId", eDAO.lastEmpleado());
                    req.getRequestDispatcher("admin/createEmpleado.jsp").forward(req, resp);
                    break;
                case "ActualizarProductos":
                    pizzas = pDao.allPizzas();
                    req.setAttribute("pizzas", pizzas);
                    req.getRequestDispatcher("admin/updatePizza.jsp").forward(req, resp);
                default:
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
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
            switch (accion) {
                case "Registro Cliente":
                    cDao.createCliente(req.getParameter("nombre"), req.getParameter("apellido"), req.getParameter("telefono"), Integer.parseInt(req.getParameter("edad")), req.getParameter("email"), req.getParameter("pass"));
                    req.setAttribute("valor", "Ya fuiste registrado, Ingresa con tu Email y Password");
                    req.getRequestDispatcher("Ingresar.jsp").forward(req, resp);
                    break;
                case "Ingresar Cliente":
                    Cliente c = cDao.ingresarCliente(req.getParameter("email"), req.getParameter("pass"));
                    
                    if (c != null) {
                        session.setAttribute("clienteSesion", c);
                        req.getRequestDispatcher("Menu.jsp").forward(req, resp);

                    } else {
                        req.setAttribute("valor", "No existe el usuario o tu contrañsea es incorrecta");
                        req.getRequestDispatcher("Ingresar.jsp").forward(req, resp);
                    }
                    break;
                case "Ingresar Empleado":
                    Empleado e = edao.validaEmpleado(req.getParameter("usuario"), req.getParameter("pass"));
                    if (e != null) {
                        session.setAttribute("empleadoSesion", e);
                        req.getRequestDispatcher("admin/dashboard.jsp").forward(req, resp);

                    } else {
                        req.setAttribute("valor", "No existe el usuario o tu contrañsea es incorrecta");
                        req.getRequestDispatcher("admin/IngresarEmpleado.jsp").forward(req, resp);
                    }
                    break;
                case "Crear Empleado":
                    System.out.println(req.getParameter("nombre") + req.getParameter("apellido") + req.getParameter("usuario") + req.getParameter("pass") + Integer.parseInt(req.getParameter("puesto")));
                    edao.createEmpleado(req.getParameter("nombre"), req.getParameter("apellido"), req.getParameter("usuario"), req.getParameter("pass") ,Integer.parseInt(req.getParameter("puesto")));
                    req.setAttribute("Exito", "El empleado se ingreso con exito");
                    req.getRequestDispatcher("admin/createEmpleado.jsp").forward(req, resp);
                    break;
                case "Seleccionar Pizza":
                    Pizza p  = pDao.pizza(Integer.parseInt(req.getParameter("pizza")));
                    req.setAttribute("PizzaE", p);
                    req.getRequestDispatcher("admin/updatePizza.jsp").forward(req, resp);
                    break;
                case "Actualizar Pizza":
                    pDao.updatePizza(Integer.parseInt(req.getParameter("id")), req.getParameter("pizza"), req.getParameter("precio"), req.getParameter("descripcion"));
                    req.setAttribute("Exito", "Pizza Actualizada");
                    req.getRequestDispatcher("admin/dashboard.jsp").forward(req, resp);
                    break;
                case "Crear Pizza":
                    System.out.println(req.getParameter("pizza") + req.getParameter("precio") + req.getParameter("descripcion"));
                    pDao.createPizza(req.getParameter("pizza"), req.getParameter("precio"), req.getParameter("descripcion"));
                    req.setAttribute("Exito", "La Pizza se creo con exito");
                    req.getRequestDispatcher("admin/createPizza.jsp").forward(req, resp);
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
