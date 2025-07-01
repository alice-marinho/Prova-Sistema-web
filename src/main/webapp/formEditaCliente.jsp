<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Customer, model.Salesman, dao.Banco, java.util.List" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    Customer c = Banco.buscaClientePeloId(id); // ajuste conforme seu DAO

    // Buscar o nome do vendedor do cliente
	Salesman vendedor = Banco.buscaVendedorPeloId(c.getSalesmanId()); 
%>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Cliente</title>
    <link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body>
    <h2>Editar Cliente</h2>

    <form action="alteraCliente" method="post">
        <input type="hidden" name="id" value="<%= c.getId() %>">

        Nome: <input type="text" name="nome" value="<%= c.getNome() %>" required><br>
        Cidade: <input type="text" name="cidade" value="<%= c.getCidade() %>" required><br>

        <div class="radio-group">
            Grade:<br>
            <label><input type="radio" name="grade" value="1" <%= (c.getGrade() == 1 ? "checked" : "") %> required> Bronze</label>
            <label><input type="radio" name="grade" value="2" <%= (c.getGrade() == 2 ? "checked" : "") %>> Prata</label>
            <label><input type="radio" name="grade" value="3" <%= (c.getGrade() == 3 ? "checked" : "") %>> Ouro</label>
        </div><br>

        Vendedor: <br>
		<strong><label><%= vendedor.getNome() %></label></strong>
		<input type="hidden" name="salesman_id" value="<%= c.getSalesmanId() %>"><br><br>


        <input type="submit" value="Atualizar">
    </form>

    <br>
    <a href="listaClientes">Voltar</a>
</body>
</html>
