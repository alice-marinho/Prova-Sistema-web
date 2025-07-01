package gerenciamento;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Banco;
import model.Order;

@WebServlet("/alteraVenda")
public class AlteraVendaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Alterando venda");

        try {
            int ordNo = Integer.parseInt(request.getParameter("ord_no"));
            double valor = Double.parseDouble(request.getParameter("purch_amt"));
            Date data = Date.valueOf(request.getParameter("ord_date"));
            int clienteId = Integer.parseInt(request.getParameter("customer_id"));
            int vendedorId = Integer.parseInt(request.getParameter("salesman_id"));

            Order o = Banco.buscaVendaPeloId(ordNo);
            o.setOrdNo(ordNo);
            o.setPurchAmt(valor);
            o.setOrdDate(data);
            o.setCustomerId(clienteId);
            o.setSalesmanId(vendedorId);
            
            Banco.atualizaVenda(o);
            response.sendRedirect("listaVendas");
        } catch (Exception e) {
            throw new ServletException("Erro ao atualizar venda", e);
        }
    }
}
