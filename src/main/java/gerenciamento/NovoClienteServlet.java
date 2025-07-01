package gerenciamento;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.Banco;
import model.Customer;

@WebServlet("/novoCliente")
public class NovoClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        System.out.println("Cadastrando novo cliente");

        String nome = request.getParameter("nome");
        String cidade = request.getParameter("cidade");
        String gradeStr = request.getParameter("grade");
        String salesmanIdStr = request.getParameter("salesman_id");

        Integer grade = null;
        Integer salesmanId = null;

        try {
            grade = Integer.valueOf(gradeStr);
            salesmanId = Integer.valueOf(salesmanIdStr);
        } catch (NumberFormatException e) {
            throw new ServletException("Erro na conversão dos números", e);
        }
        
        if (!Banco.vendedorExiste(salesmanId)) {
            request.setAttribute("erro", "Erro: o vendedor informado não existe.");
            request.getRequestDispatcher("/formNovoCliente.jsp").forward(request, response);
            return;
        }

        
        Customer cliente = new Customer();
        cliente.setNome(nome);
        cliente.setCidade(cidade);
        cliente.setGrade(grade);
        cliente.setSalesmanId(salesmanId);

        Banco.adicionaCliente(cliente);

        response.sendRedirect("listaClientes?cadastro=sucesso");
    }
}
