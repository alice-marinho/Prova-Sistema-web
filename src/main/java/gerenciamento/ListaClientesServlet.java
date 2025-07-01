package gerenciamento;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.Banco;
import model.Customer;

@WebServlet("/listaClientes")
public class ListaClientesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Busca a lista de clientes
        List<Customer> clientes = Banco.buscaTodosClientes(); // ajuste se o nome do método for diferente

        // Adiciona no request
        request.setAttribute("clientes", clientes);

        // Encaminha para a JSP
        request.getRequestDispatcher("listaClientes.jsp").forward(request, response);
    }
}
