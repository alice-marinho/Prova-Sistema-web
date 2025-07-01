<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Salesman, dao.Banco" %>
<!DOCTYPE html>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    Salesman v = Banco.buscaVendedorPeloId(id);
%>
<html>
<head><title>Editar Vendedor</title>
	 <link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body>
    <h2>Editar Vendedor</h2>
    <form action="alteraVendedor" method="post">
        <input type="hidden" name="id" value="<%= v.getId() %>">
        Nome: <input type="text" name="nome" value="<%= v.getNome() %>"><br>
        Cidade: <input type="text" name="cidade" value="<%= v.getCidade() %>"><br>
        Comissão: <input type="text" name="comissao" value="<%= v.getComissao() %>"><br>
        <input type="submit" value="Atualizar">
    </form>
    <a href="listaVendedores.jsp">Voltar</a>
</body>
</html>
