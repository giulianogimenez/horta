<%-- 
    Document   : planta
    Created on : Oct 27, 2016, 10:28:41 AM
    Author     : giuliano.gimenez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Plantas de ${projeto.nome}</h1>
        <input type="hidden" name="projetoPlanta.planta.id" value="${projeto.id}" />
        <c:if test="${empty plantas}" >
            Você ainda não possui nenhuma planta no seu projeto!<br>
        </c:if>
        <button id="btnAdicionarPlanta" class="btn btn-primary" onclick="window.location = '/horta/meuprojeto/adicionarplanta/${projeto.id}'">Adicionar Planta</button>
        <c:forEach var="item" items="${plantas}">
            <div class="planta">
                <h2>${item.nome}</h2>
                <p class="foto">
                    <img src="<c:url value='/img/content/' />${item.fotoPath}" />
                </p>
                <p>
                    <h2>Luminosidade</h2>
                    ${item.iluminacao}
                </p>
                <p>
                    <h2>Irrigação</h2>
                    ${item.irrigacao}
                </p>
                <p>
                    <h2>Dica</h2>
                    ${item.dica}
                </p>
            </div>
        </c:forEach>
            
    </body>
</html>
