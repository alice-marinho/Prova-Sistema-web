<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.Customer, dao.Banco" %>
<!DOCTYPE html>

    
<html>
<head>
    <title>Lista de Clientes</title>
     <link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body>
    <h2>Clientes Cadastrados</h2>
   <%
    List<Customer> clientes = (List<Customer>) request.getAttribute("clientes");
    if (clientes == null) {
        clientes = new ArrayList<>(); // evita NullPointerException
    }
	%>

	<% if (clientes.isEmpty()) { %>
	    <center><p>Nenhum cliente cadastrado!</p></center>
	<% } else { %>
	    <table border="1">
	        <tr>
	            <th>ID</th><th>Nome</th><th>Cidade</th><th>Grade</th><th>Salesman ID</th><th>Ações</th>
	        </tr>
	        <%
	            for(Customer c : clientes) {
	        %>
	        <tr>
	            <td><%= c.getId() %></td>
	            <td><%= c.getNome() %></td>
	            <td><%= c.getCidade() %></td>
	            <td><%= c.getGrade() %></td>
	            <td><%= c.getSalesmanId() %></td>
	            <td>
	                <a href="formEditaCliente.jsp?id=<%= c.getId() %>">Editar</a> |
	                <a href="removeCliente?id=<%= c.getId() %>">Excluir</a>
	            </td>
	        </tr>
	        <% } %>
	    
	    </table> 
	    <% } %>
	    <br/>
    <a href="formNovoCliente.jsp">Cadastrar Novo Cliente</a><br><br>
    <a href="menu.jsp">Voltar ao Menu</a>
</body>
</html>