package controlador;

import datos.PizzaDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            
            String accion = req.getParameter("accion"); //Recuperando la accion
            //Variables
            PizzaDAO pDao = new PizzaDAO();

            switch (accion) {
                case "Menu":
                    //Envio de atributos
                    req.setAttribute("pizzas", pDao.allPizzas());
                    
                    //Redireccionamientos a pagina con atributos
                    req.getRequestDispatcher("Menu.jsp").forward(req, resp);
                
                default:
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
