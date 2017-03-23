<%-- 
    Document   : buscar
    Created on : 14/03/2017, 08:28:44 PM
    Author     : LSTI-22
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar page</title>

        
        
    </head>
    <body>
        <form action="ComentariosControlador" method="POST">
            <h1>Datos generales </h1>
            
            Nombre:     <input type="text" name="txt-nombre">       <br><br>    
            Comentario: <input type="text" name="txt-comentario">
            
            <input type="submit" value="Enviar">
            
            <input type="hidden" name="accion" value="buscar">
            
        </form>
        
        <% 
            if(session != null){
                List comentarios = (List) session.getAttribute("comentarios");
                if(comentarios != null){
        %>        
        
                <table border="1">
                    <tr>
                        <th>Nombre</th>
                        <th>Comentario</th>
                    </tr>       
                    
                <% 
                    for(Object o : comentarios){
                        ComentarioBean comentario  = (ComentarioBean) o;
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
