<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.Salesman" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Vendedores</title>
    <link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body>
    <h2>Vendedores Cadastrados</h2>

    <%
	    List<Salesman> vendedores = (List<Salesman>) request.getAttribute("vendedores");
	    if (vendedores == null) {
	        vendedores = new ArrayList<>(); // evita NullPointerException
	    }
	%>

	<% if (vendedores.isEmpty()) { %>
	    <center><p>Nenhum vendedor cadastrado!</p></center>
	<% } else { %>
	    <table border="1">
	        <tr>
	            <th>ID</th><th>Nome</th><th>Cidade</th><th>Comissão</th><th>Ações</th>
	        </tr>
	        <% for (Salesman v : vendedores) { %>
	        <tr>
	            <td><%= v.getId() %></td>
	            <td><%= v.getNome() %></td>
	            <td><%= v.getCidade() %></td>
	            <td><%= v.getComissao() %></td>
	            <td>
	                <a href="formEditaVendedor.jsp?id=<%= v.getId() %>">Editar</a> |
	                <a href="removeVendedor?id=<%= v.getId() %>">Excluir</a>
	            </td>
	        </tr>
	        <% } %>
	    </table>
	<% } %>

    <br/>
    <a href="formNovoVendedor.jsp">Cadastrar Novo Vendedor</a><br><br>
    <a href="menu.jsp">Voltar ao Menu</a>
   
</body>
</html>
