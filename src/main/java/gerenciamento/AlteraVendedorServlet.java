package gerenciamento;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Banco;
import model.Salesman;

@WebServlet("/alteraVendedor")
public class AlteraVendedorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Alterando vendedor");

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String cidade = request.getParameter("cidade");
            double comissao = Double.parseDouble(request.getParameter("comissao"));

            Salesman vendedor = Banco.buscaVendedorPeloId(id);
            vendedor.setNome(nome);
            vendedor.setCidade(cidade);
            vendedor.setComissao(comissao);
            vendedor.setId(id);

            Banco.atualizaVendedor(vendedor);

            response.sendRedirect("listaVendedores");
        } catch (Exception e) {
            throw new ServletException("Erro ao atualizar vendedor", e);
        }
    }
}
