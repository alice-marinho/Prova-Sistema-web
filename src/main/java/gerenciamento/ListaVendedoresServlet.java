package gerenciamento;

import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.Banco;
import model.Salesman;

@WebServlet("/listaVendedores")
public class ListaVendedoresServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Salesman> vendedores = Banco.buscaTodosVendedores();
        request.setAttribute("vendedores", vendedores);

        RequestDispatcher dispatcher = request.getRequestDispatcher("listaVendedores.jsp");
        dispatcher.forward(request, response);
    }
}
