<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Novo Vendedor</title>
	 <link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body>
    <h2>Cadastrar Vendedor</h2>
    <form action="novoVendedor" method="post">
        Nome: <input type="text" name="nome"><br>
        Cidade: <input type="text" name="cidade"><br>
        Comissão: <input type="text" name="comissao"><br>
        <input type="submit" value="Cadastrar">
    </form>
    <a href="listaVendedores">Voltar</a>
</body>
</html>
