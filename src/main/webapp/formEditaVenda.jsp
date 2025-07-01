<%@ page import="model.Order, dao.Banco" %>
<%
    int id = Integer.parseInt(request.getParameter("ord_no"));
    Order o = Banco.buscaVendaPeloId(id);
%>
<html>
<head>
<title>Editar Venda</title>
 <link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body>
    <h2>Editar Venda</h2>
    <form action="alteraVenda" method="post">
        <input type="hidden" name="ord_no" value="<%= o.getOrdNo() %>">
        Valor da Compra: <input type="text" name="purch_amt" value="<%= o.getPurchAmt() %>"><br>
        Data do Pedido: <input type="date" name="ord_date" value="<%= o.getOrdDate() %>"><br>
        ID do Cliente: <input type="text" name="customer_id" value="<%= o.getCustomerId() %>"><br>
        ID do Vendedor: <input type="text" name="salesman_id" value="<%= o.getSalesmanId() %>"><br>
        <input type="submit" value="Atualizar">
    </form>
    <a href="listaVendas.jsp">Voltar</a>
</body>
</html>
