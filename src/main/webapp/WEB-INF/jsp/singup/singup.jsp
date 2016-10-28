<%-- 
    Document   : singup
    Created on : Oct 26, 2016, 3:20:06 PM
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
        <h1>Cadastre-se e comece a tornar sua vida mais saudável!</h1>
        <fieldset>
            <form id="form1" method="post" action="<c:url value="/" />singup">
                <input type="hidden" name="_method" id="_method" value="POST" />
                <div class="fields">
                    <div class="field">
                        <label for="txtNome">Nome</label>
                        <input type="text" id="txtNome" name="usuario.nome" class="input-xxlarge">
                    </div>
                    <div class="field">
                        <label for="txtEmail">E-mail</label>
                        <input type="text" id="txtEmail" name="usuario.email" class="input-large">
                    </div>
                    <div class="field">
                        <label for="txtSenha">Senha</label>
                        <input type="password" id="txtSenha" name="usuario.senha" class="input-large">
                    </div>
                    <div class="buttons">
                        <button class="btn btn-primary">Inscrever</button>
                    </div>
                </div>
            </form>
        </fieldset>
    </body>
</html>
