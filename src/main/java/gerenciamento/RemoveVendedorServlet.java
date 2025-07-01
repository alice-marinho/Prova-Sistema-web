package gerenciamento;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Banco;

@WebServlet("/removeVendedor")
public class RemoveVendedorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Banco.deletaVendedor(id);
            response.sendRedirect("listaVendedores");
        } catch (Exception e) {
            throw new ServletException("Erro ao remover vendedor", e);
        }
    }
}

