<%-- 
    Document   : novo
    Created on : Oct 27, 2016, 8:56:26 AM
    Author     : giuliano.gimenez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="<c:url value='/js/projeto/novo.js'/>"></script>
    </head>
    <body>
        <h1>Novo Projeto</h1>
        <fieldset>
            <form id="form1" method="post" action="<c:url value='/' />meuprojeto" >
                <input type="hidden" nam="_method" id="_method" value="POST" />
                <div class="fields">
                    <div class="field">
                        <label for="txtNomeProjeto">Dê um nome ao seu projeto</label>
                        <input type="text" id="txtNomeProjeto" required name="projeto.nome" class="input-xxlarge" />
                        <input type="hidden" name="projeto.usuario.id" value="${usuarioSession.id}" />
                    </div>
                    <div class="buttons">
                        <button class="btn btn-primary">Escolher as plantas</button>
                    </div>
                </div>
            </form>
        </fieldset>
    </body>
</html>
