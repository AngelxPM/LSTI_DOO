<%-- 
    Document   : buscar
    Created on : 20/03/2017, 06:18:11 PM
    Author     : Angel Adolfo Pacheco Mazuca 1656991
--%>

<%@page import="lab7.modelo.ComentariosPOJO"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar page</title>
    </head>
    <body>
        <form action="ComentariosControlador" method="POST">
            <h1>Datos buscar </h1>
            
            Nombre:     <input type="text" name="txt-nombre">       <br><br>    
            Comentario: <input type="text" name="txt-comentario">
            
            <input type="submit" value="Enviar">
            
            <input type="hidden" name="accion" value="buscar">
            
        </form>
        
        <% 
            if(session != null){
                ArrayList comentarios = (ArrayList) session.getAttribute("Comentarios");
                if(comentarios != null){
        %>        
        
                <table border="1">
                    <tr>
                        <th>Nombre</th>
                        <th>Comentario</th>
                    </tr>       
                    
                <% 
                    for(Object o : comentarios){
                        ComentariosPOJO comentario  = (ComentariosPOJO) o;
                %>       
                    <tr>
                        <td><%=comentario.getNombre()%></td>
                        <td><%=comentario.getComentario()%></td>
                    </tr>    
                        
                <%  }   //for   %>
                
                </table>    
                    
        <%      }
            }   %>
        
        
    </body>
</html>
