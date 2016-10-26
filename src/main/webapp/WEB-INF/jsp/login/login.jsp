<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Entrar</h1>
        <fieldset>
            <div class="fields">
                <div class="field">
                    <label for="txtLogin">Login</label>
                    <input id="txtLogin" name="usuario.email" type="text" class="input-medium">
                </div>
                <div class="field">
                    <label for="txtSenha">Senha</label>
                    <input type="password" id="txtSenha" name="usuario.senha" class="input-medium">
                </div>
                <div class="buttons">
                    <button id="btnLogin" class="btn btn-primary">Entrar</button>
                </div>
            </div>
        </fieldset>
    </body>
</html>
