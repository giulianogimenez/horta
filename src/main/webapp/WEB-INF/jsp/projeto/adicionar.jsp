<%-- 
    Document   : adicionar
    Created on : Oct 27, 2016, 2:58:04 PM
    Author     : giuliano.gimenez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value='/ext/font-awesome-4.5.0/css/font-awesome.min.css' />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value='/css/plantas/plantas.css' />" rel="stylesheet" type="text/css"/>
        <script src="<c:url value='/js/plantas/plantas.js' />" type="text/javascript"></script>
    </head>
    <body>
        <h1>Adicionar planta no projeto ${projeto.nome}</h1>
        <c:forEach items="${plantas}" var="item">
            <div class="planta">
                <h2>${item.nome}</h2>
                <c:set var="tenho" value="false" />
                <c:forEach items="${minhasPlantas}" var="m">
                    <c:if test="${m.id == item.id}">
                        <c:set var="tenho" value="true" />
                    </c:if>
                </c:forEach>
                <div id="botao${item.id}">
                    <c:choose>
                        <c:when test="${tenho}">
                            <button id="btnRemover" type="button" onclick="remover(${projeto.id}, ${item.id});" class="btn btn-danger"><i class="fa fa-times"></i></button>
                        </c:when>
                        <c:otherwise>
                            <button id="btnAdd" type="button" class="btn btn-primary" onclick="add(${projeto.id}, ${item.id});"><i class="fa fa-plus"></i></button>
                        </c:otherwise>
                    </c:choose>
                </div>
                <p class="foto">
                    <img src="<c:url value='/img/content/' />${item.fotoPath}" />
                </p>
                <p>
                    <h3>Luminosidade</h3>
                    ${item.iluminacao}
                </p>
                <p>
                    <h3>Irrigação</h3>
                    ${item.irrigacao}
                </p>
                <p>
                    <h3>Dica</h3>
                    ${item.dica}
                </p>
            </div>
        </c:forEach>
    </body>
</html>
