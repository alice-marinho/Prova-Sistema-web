package gerenciamento;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Banco;

@WebServlet("/removeVenda")
public class RemoveVendaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("ord_no"));
            Banco.deletaVenda(id);
            response.sendRedirect("listaVendas");
        } catch (Exception e) {
            throw new ServletException("Erro ao remover venda", e);
        }
    }
}
