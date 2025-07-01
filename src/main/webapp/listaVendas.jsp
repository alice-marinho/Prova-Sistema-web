<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.Order" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Vendas</title>
    <link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body>
    <h2>Vendas Realizadas</h2>

    <%
        List<Order> vendas = (List<Order>) request.getAttribute("vendas");
        if (vendas == null) {
            vendas = new ArrayList<>();
        }
    %>

    <% if (vendas.isEmpty()) { %>
        <center><p>Nenhuma venda cadastrada!</p></center>
    <% } else { %>
        <table border="1">
            <tr>
                <th>Ordem Nº</th>
                <th>Valor</th>
                <th>Data</th>
                <th>Cliente ID</th>
                <th>Vendedor ID</th>
                <th>Ações</th>
            </tr>
            <%
                for (Order o : vendas) {
            %>
            <tr>
                <td><%= o.getOrdNo() %></td>
                <td>R$ <%= String.format(Locale.US, "%.2f", o.getPurchAmt()) %></td>
                <td><%= o.getOrdDate() %></td>
                <td><%= o.getCustomerId() %></td>
                <td><%= o.getSalesmanId() %></td>
                <td>
                    <a href="formEditaVenda.jsp?ord_no=<%= o.getOrdNo() %>">Editar</a> |
                    <a href="removeVenda?ord_no=<%= o.getOrdNo() %>" onclick="return confirm('Tem certeza que deseja excluir esta venda?');">Excluir</a>
                </td>
            </tr>
            <% } %>
        </table>
    <% } %>

    <br/>
    <a href="formNovaVenda.jsp">Cadastrar Nova Venda</a><br><br>
    <a href="menu.jsp">Voltar ao Menu</a>
</body>
</html>
