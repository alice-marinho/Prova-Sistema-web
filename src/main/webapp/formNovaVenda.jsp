<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.Customer, dao.Banco, model.Salesman" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nova Venda</title>
    <link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body>
    <h2>Registrar Nova Venda</h2>
    <form action="novaVenda" method="post">
     Cliente:
        <select name="customer_id" required>
            <option value="">-- Selecione um cliente --</option>
            <%
                List<Customer> clientes = Banco.buscaTodosClientes();
                for (Customer c : clientes) {
            %>
                <option value="<%= c.getId() %>"><%= c.getNome() %></option>
            <%
                }
            %>
        </select>
        <br><br>
        
        Valor da Compra: <input type="text" name="purch_amt" required><br><br>

        Data do Pedido: <input type="date" name="ord_date" required><br><br>

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

    <br>
    <a href="listaVendas">Voltar</a>
</body>
</html>
