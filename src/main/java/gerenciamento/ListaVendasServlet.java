package gerenciamento;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.Banco;
import model.Order;

@WebServlet("/listaVendas")
public class ListaVendasServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Busca todas as vendas (orders) no banco
        List<Order> vendas = Banco.buscaTodasVendas();

        // Adiciona a lista de vendas ao request
        request.setAttribute("vendas", vendas);

        // Encaminha para a JSP que vai exibir os dados
        request.getRequestDispatcher("listaVendas.jsp").forward(request, response);
    }
}
