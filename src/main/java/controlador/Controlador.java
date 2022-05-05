package controlador;

import datos.PizzaDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Pizza;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        
        switch(accion){
            case "Menu":
                PizzaDAO pDao = new PizzaDAO();
                ArrayList<Pizza> pizzas = pDao.listaPizzas();
                req.setAttribute("pizzas", pizzas);
                req.getRequestDispatcher("Menu.jsp").forward(req, resp);
                break;
            case "Ingresar":
                req.getRequestDispatcher("Ingresar.jsp").forward(req, resp);
                break;
            default:
                break;
        }
    }
}
