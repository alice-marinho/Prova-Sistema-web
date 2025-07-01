<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Informações da Dupla</title>
    <link rel="stylesheet" href="<c:url value='/estilo.css' />">
</head>
<body>
    <div class="container">
        <h1>Informações da Dupla</h1>

        <div class="box">
            <h3>Integrante 1</h3>
            <p><strong>Alice Marinho</strong></p>
            <p><strong>RA:</strong> CB3025772</p>
        </div>

        <div class="box">
            <h3>Integrante 2</h3>
            <p><strong>Matheus Leandro</strong></p>
            <p><strong>RA:</strong> CB3025772</p>
        </div>

        <a class="button" href="menu.jsp">Voltar ao Menu</a>
    </div>
</body>
</html>
