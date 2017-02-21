<%-- 
    Document   : login
    Created on : 19/02/2017, 09:08:35 PM
    Author     : AngelxPM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        
    </head>
    <body>
        <header>
            <h1>
                Bienvenido, por favor inicia sesion. 
            </h1>
        </header>
        <form name="Formulario" action="LoginController" method="post">
            <label>Usuario: </label> 
            <br>
            <input type="text" id="user" name="txt-username" />
            <br>
            <br>
            <label>Contraseña: </label> 
            <br>
            <input type="password" id="pass" name="txt-password" />
            <br>
            <br>
            <input type="submit" id="sent" name="btn-enviar" value="Envar" />
            
        </form>
    </body>      
   
</html>
