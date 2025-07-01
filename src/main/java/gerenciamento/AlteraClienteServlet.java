package gerenciamento;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Banco;
import model.Customer;

@WebServlet("/alteraCliente")
public class AlteraClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String paramId = request.getParameter("id");
            String nome = request.getParameter("nome");
            String cidade = request.getParameter("cidade");
            String gradeStr = request.getParameter("grade");
            String salesmanIdStr = request.getParameter("salesman_id");

            int id = Integer.parseInt(paramId);
            int grade = Integer.parseInt(gradeStr);
            int salesmanId = Integer.parseInt(salesmanIdStr);

            Customer cliente = Banco.buscaClientePeloId(id);
            cliente.setNome(nome);
            cliente.setCidade(cidade);
            cliente.setGrade(grade);
            cliente.setSalesmanId(salesmanId);

            int status = Banco.atualizaCliente(cliente);

            if (status > 0) {
                System.out.println("Cliente atualizado com sucesso!");
            }

            response.sendRedirect("listaClientes");
        } catch (Exception e) {
            throw new ServletException("Erro ao atualizar cliente", e);
        }
    }
}
