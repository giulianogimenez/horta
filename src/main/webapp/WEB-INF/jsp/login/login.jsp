<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Entrar</h1>
        <fieldset>
            <form id="form1" method="post" action="<c:url value="/" />login">
                <input type="hidden" name="_method" id="_method" value="POST" />
                <div class="fields">
                    <div class="field">
                        <label for="txtLogin">Login</label>
                        <input id="txtLogin" name="email" type="text" class="input-medium">
                    </div>
                    <div class="field">
                        <label for="txtSenha">Senha</label>
                        <input type="password" id="txtSenha" name="senha" class="input-medium">
                    </div>
                    <div class="buttons">
                        <button id="btnLogin" class="btn btn-primary">Entrar</button>
                    </div>
                    <div >
                        <a href="<c:url value='/singup' />">Ainda não tem uma conta? Clique aqui para fazer uma!</a>
                    </div>
                </div>
            </form>
        </fieldset>
    </body>
</html>
