package gerenciamento;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.Banco;
import model.Salesman;

@WebServlet("/novoVendedor")
public class NovoVendedorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        System.out.println("Cadastrando novo vendedor");

        String nome = request.getParameter("nome");
        String cidade = request.getParameter("cidade");
        String comissaoStr = request.getParameter("comissao");

        Double comissao = null;

        try {
            if (comissaoStr != null && !comissaoStr.isEmpty()) {
                comissaoStr = comissaoStr.replace(",", ".");
                comissao = Double.valueOf(comissaoStr);
            }
        } catch (NumberFormatException e) {
            throw new ServletException("Erro na conversão da comissão", e);
        }

        Salesman vendedor = new Salesman();
        vendedor.setNome(nome);
        vendedor.setCidade(cidade);
        vendedor.setComissao(comissao);

        Banco.adicionaVendedor(vendedor);

        response.sendRedirect("listaVendedores?cadastro=sucesso");
    }
}
