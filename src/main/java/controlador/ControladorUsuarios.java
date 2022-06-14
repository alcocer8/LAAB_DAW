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

@WebServlet("/ControladorUsuarios")
public class ControladorUsuarios extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Recuperamos el session
        HttpSession session = req.getSession();
        
        //Mandamos la session como parametro
        session.setAttribute("session", session);
        
        //Recuperamos la accion
        String accion = req.getParameter("accion");

        switch (accion) {
            case "Ingresar":
                //Acceso para ingreso empleado
                req.setAttribute("Empleado", "Empleado");
                req.getRequestDispatcher("Ingresar.jsp").forward(req, resp);
                break;
            case "Registro":
                req.getRequestDispatcher("Registro.jsp").forward(req, resp);
                break;
            case "Empleado":
                    req.getRequestDispatcher("admin/IngresarEmpleado.jsp").forward(req, resp);
                    break;
            case "SalirUsuario":
                
                //Eliminamos todos los atributos dentro de session actual
                session.removeAttribute("clienteSesion");
                session.removeAttribute("empleadoSesion");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //Recuperamos la session actual
            HttpSession session = req.getSession();
            session.setAttribute("session", session);
            //Recuperamos la accion
            String accion = req.getParameter("accion");
            
            //Variables
            ClienteDao cDao = new ClienteDao();
            EmpleadoDAO edao = new EmpleadoDAO();
            PizzaDAO pDao = new PizzaDAO();
            
            OrdenClientesDao ocDao = new OrdenClientesDao();
            int i = 0;
            switch (accion) {
                case "Registro Cliente":
                    
                    i = 0;
                    //Validamos que ningun campo este vacio
                    if (req.getParameter("nombre").isEmpty()) {
                        i++;
                    }
                    
                    if (req.getParameter("apellido").isEmpty()) {
                        i++;
                    }
                    
                    if (req.getParameter("telefono").isEmpty()) {
                        i++;
                    }
                    
                    if (req.getParameter("edad").isEmpty()) {
                        i++;
                    }
                    
                    if (req.getParameter("email").isEmpty()) {
                        i++;
                    }
                    
                    if (req.getParameter("pass").isEmpty()) {
                        i++;
                    }

                    //Si ningun campo esta vacio
                    if(i == 0){
                        //Creamos el cliente
                        cDao.createCliente(req.getParameter("nombre"), req.getParameter("apellido"), req.getParameter("telefono"), Integer.parseInt(req.getParameter("edad")), req.getParameter("email"), req.getParameter("pass"));
                        req.setAttribute("valor", "Ya fuiste registrado, Ingresa con tu Email y Password");
                        req.getRequestDispatcher("Ingresar.jsp").forward(req, resp);
                    }else{
                        //Retornamos un aviso de que no se pudo
                        req.setAttribute("valor", "Todos los campos son obligatorios");
                        req.getRequestDispatcher("Registro.jsp").forward(req, resp);
                    }
                    
                    break;
                case "Ingresar Cliente":
                    i = 0;
                    
                    if(req.getParameter("email").isEmpty()){
                        i++;
                    }
                    
                    if(req.getParameter("pass").isEmpty()){
                        i++;
                    }
                    Cliente c = null;
                    if(i == 0){
                        c = cDao.ingresarCliente(req.getParameter("email"), req.getParameter("pass"));
                    }else{
                        req.setAttribute("valor", "Todos los campos son obligatorios");
                        req.getRequestDispatcher("Ingresar.jsp").forward(req, resp);
                    }
                    

                    if (c != null) {
                        session.setAttribute("clienteSesion", c);
                        req.setAttribute("pizzas", pDao.allPizzas());
                        req.getRequestDispatcher("Menu.jsp").forward(req, resp);

                    } else {
                        req.setAttribute("valor", "No existe el usuario o tu contrañsea es incorrecta");
                        req.getRequestDispatcher("Ingresar.jsp").forward(req, resp);
                    }
                    break;
                case "Ingresar Empleado":
                     i = 0;
                    
                    if(req.getParameter("email").isEmpty()){
                        i++;
                    }
                    
                    if(req.getParameter("pass").isEmpty()){
                        i++;
                    }
                    Empleado e = null;
                    if(i == 0){
                        e = edao.validaEmpleado(req.getParameter("usuario"), req.getParameter("pass"));
                    }else{
                        req.setAttribute("valor", "Todos los campos son obligatorios");
                        req.getRequestDispatcher("admin/IngresarEmpleado.jsp").forward(req, resp);
                    }
                    
                    

                    if (e != null) {

                        req.setAttribute("Nuevo", ocDao.EstadoOrdenCliente(1));
                        req.setAttribute("Preparado", ocDao.EstadoOrdenCliente(2));

                        session.setAttribute("empleadoSesion", e);
                        req.setAttribute("Empleado", e);
                        req.getRequestDispatcher("admin/dashboard.jsp").forward(req, resp);

                    } else {
                        req.setAttribute("valor", "No existe el usuario o tu contrañsea es incorrecta");
                        req.getRequestDispatcher("admin/IngresarEmpleado.jsp").forward(req, resp);
                    }
                    break;
                case "Crear Empleado":
                    System.out.println(req.getParameter("nombre") + req.getParameter("apellido") + req.getParameter("usuario") + req.getParameter("pass") + Integer.parseInt(req.getParameter("puesto")));
                    edao.createEmpleado(req.getParameter("nombre"), req.getParameter("apellido"), req.getParameter("usuario"), req.getParameter("pass"), Integer.parseInt(req.getParameter("puesto")));
                    req.setAttribute("Exito", "El empleado se ingreso con exito");
                    req.getRequestDispatcher("admin/createEmpleado.jsp").forward(req, resp);
                    break;
                default:
                    break;

            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorUsuarios.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
