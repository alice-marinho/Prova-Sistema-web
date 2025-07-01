package gerenciamento;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Banco;

@WebServlet("/removeCliente")
public class RemoveClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String paramId = request.getParameter("id");

        try {
            int id = Integer.parseInt(paramId);
            int status = Banco.deletaCliente(id);

            if (status > 0) {
                System.out.println("Cliente removido com sucesso.");
            } else {
                System.out.println("Erro ao remover cliente.");
            }

            response.sendRedirect("listaClientes");
        } catch (Exception e) {
            throw new ServletException("Erro ao remover cliente", e);
        }
    }
}
