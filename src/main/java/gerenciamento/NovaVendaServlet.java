package gerenciamento;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.Banco;
import model.Order;

@WebServlet("/novaVenda")
public class NovaVendaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        System.out.println("Cadastrando nova venda");

        // Recebendo os parâmetros do formulário
        String valorStr = request.getParameter("purch_amt");
        String dataStr = request.getParameter("ord_date");
        String clienteIdStr = request.getParameter("customer_id");
        String vendedorIdStr = request.getParameter("salesman_id");

        Double valor = null;
        Date data = null;
        Integer clienteId = null;
        Integer vendedorId = null;

        try {
            if (valorStr != null && !valorStr.isEmpty()) {
                valorStr = valorStr.replace(",", ".");
                valor = Double.valueOf(valorStr);
            }

            if (dataStr != null && !dataStr.isEmpty()) {
                data = Date.valueOf(dataStr); // formato: yyyy-MM-dd
            }

            if (clienteIdStr != null && !clienteIdStr.isEmpty()) {
                clienteId = Integer.valueOf(clienteIdStr);
            }

            if (vendedorIdStr != null && !vendedorIdStr.isEmpty()) {
                vendedorId = Integer.valueOf(vendedorIdStr);
            }

        } catch (Exception e) {
            throw new ServletException("Erro ao converter os dados do formulário", e);
        }

        Order venda = new Order();
        venda.setPurchAmt(valor);
        venda.setOrdDate(data);
        venda.setCustomerId(clienteId);
        venda.setSalesmanId(vendedorId);

        Banco.adicionaVenda(venda); // certifique-se de ter esse método

        response.sendRedirect("listaVendas?cadastro=sucesso");
    }
}
