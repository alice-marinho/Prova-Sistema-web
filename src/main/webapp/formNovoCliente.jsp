<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.Customer, dao.Banco, model.Salesman" %>
    
<!DOCTYPE html>
<html>
<head>
	<title>Novo Cliente</title>
	 <link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body>
    <h2>Cadastrar Cliente</h2>
    
    <% if (request.getAttribute("erro") != null) { %>
    <p style="color: red; font-weight: bold;">
        <%= request.getAttribute("erro") %>
    </p>
<% } %>
    <form action="novoCliente" method="post">
        Nome: <input type="text" name="nome" required><br>
        Cidade: <input type="text" name="cidade" required><br>

		<div class="radio-group">
		  Grade:<br>
		  <label><input type="radio" name="grade" value="1" required> Bronze</label>
		  <label><input type="radio" name="grade" value="2"> Prata</label>
		  <label><input type="radio" name="grade" value="3"> Ouro</label>
		</div><br>

        Vendedor: <select name="salesman_id" required>
    <option value="">-- Selecione um vendedor --</option>
    <%
        List<Salesman> vendedores = Banco.buscaTodosVendedores(); // ajuste o método conforme sua DAO
        for (Salesman v : vendedores) {
    %>
        <option value="<%= v.getId() %>"><%= v.getNome() %></option>
    <%
        }
    %>
</select><br><br>
        <input type="submit" value="Cadastrar">
    </form>
    <a href="listaClientes.jsp">Voltar</a>
</body>
</html>
