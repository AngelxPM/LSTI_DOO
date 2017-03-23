/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Angel Adolfo Pacheco 1656991 
 */
public class ComentariosDAO {
    
    Connection conexion;
    
    private void abrirConexion()throws SQLException {
        
        String dbURI = "jdbc:derby://localhost:1527/Comentarios";
        String user = "fcfm";
        String pass = "lsti01";
        
        conexion = DriverManager.getConnection(dbURI,user,pass);
    }
    
    private void cerrarConexion()throws SQLException{
        
        conexion.close();
    
    }
    
    public void insertar(ComentariosPOJO comentarios)throws SQLException{
        try{
            
            abrirConexion();
         
            String sql = "insert into COMENTARIOS values ('Ana', 'nunca es tarde')";
            
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
            
            cerrarConexion();
            
                    
        }catch(SQLException e){
            
        }
        
    }
    
    public List buscar(ComentariosPOJO comentarios)throws SQLException{
        
        List beans = new ArrayList();
        
        try{
            
            abrirConexion();
         
            String sql = "select * from COMENTARIOS where NOMBRE = 'Ana' and COMENTARIO like '%tarde%'";
            
            Statement stmt = conexion.createStatement();
            ResultSet mensajes = stmt.executeQuery(sql);
            
            while(mensajes.next()) {
                
                ComentariosPOJO dto = new ComentariosPOJO();
                
                dto.setNombre(mensajes.getString("Nombre"));
                dto.setComentario(mensajes.getString("Comentario"));
                
            }
        
            beans.add(dto);
            
            cerrarConexion();
            
                    
        }catch(SQLException e){
            
        }
        
        return beans;
    }
    
    
    
}
