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
        <link href="<c:url value='/css/plantas/plantas.css' />" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Plantas de ${projeto.nome}</h1>
        <input type="hidden" name="projetoPlanta.planta.id" value="${projeto.id}" />
        <c:if test="${empty plantas}" >
            Você ainda não possui nenhuma planta no seu projeto!<br>
        </c:if>
        <button id="btnAdicionarPlanta" class="btn btn-primary" onclick="window.location = '/horta/meuprojeto/adicionarplanta/${projeto.id}'">Adicionar Planta</button>
        <button id="btnVoltar" class="btn btn-primary" onclick="window.location = '/horta'">Voltar</button>
        <c:forEach var="item" items="${plantas}">
            <div class="minhaplanta">
                <h2>${item.planta.nome}</h2>
                <p class="foto">
                    <img src="<c:url value='/img/content/' />${item.planta.fotoPath}" />
                </p>
                <p>
                    <h3>Luminosidade</h3>
                    ${item.planta.iluminacao}
                </p>
                <p>
                    <h3>Irrigação</h3>
                    ${item.planta.irrigacao}
                </p>
                <p>
                    <h3>Dica</h3>
                    ${item.planta.dica}
                </p>
                <p>
                    <form id="form1" method="post" action="<c:url value="/" />salvarObs">
                        <input type="hidden" name="_method" id="_method" value="POST" />
                        <input type="hidden" name="ppId" value="${item.id}" />
                        <h3>Observações</h3>
                        <textarea id="txtObservacoes" name="observacao" class="field">${item.observacao}</textarea>
                        <br>
                        <button class="btn btn-primary">Registrar</button>
                    </form>
                </p>
            </div>
        </c:forEach>
            
    </body>
</html>
