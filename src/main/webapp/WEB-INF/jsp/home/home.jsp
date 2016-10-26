<%-- 
    Document   : home
    Created on : Oct 26, 2016, 11:50:01 AM
    Author     : giuliano.gimenez
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/home/home.css'/>">
        <script type="text/javascript" src="<c:url value='/js/home/home.js'/>"></script>
    </head>
    <body>
        <h1>Meus projetos</h1>
        <c:if test="${empty meusProjetos}">
            Você ainda não tem nenhum projeto<br>
        </c:if>
        <c:forEach items="${meusProjetos}" var="item">
            <button class="btn space" onclick="ir(${item.id})">${item.nome}</button> 
        </c:forEach>
        <button id="btnNovo" class="btn btn-primary" >Criar um novo projeto</button> 
    </body>
</html>
