/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7.modelo;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import laboratorio9.utils.Log;

/**
 *
 * @author Angel Adolfo Pacheco Mazuca 1656991
 */
public class ComentariosDAO {
    
    private Connection conexion;
    Log logg = Log.getInstance("C:\\Users\\LSTI-20\\Desktop\\lab7\\loggs.txt");
    
    private void abrirConexion() throws SQLException, IOException{
        
        String URI = "jdbc:derby://localhost:1527/Comentarios";
        String username = "fcfm";
        String password = "lsti01";
        
        conexion = DriverManager.getConnection(URI,username,password);
        
        logg.write("Este metodo abre la conexion \n\n");
    }
    
    private void cerrarConexion() throws SQLException{
        
        conexion.close();
        
        logg.write("Este metodo cierra la conexion \n\n");
        
    }
    
    public void insertar(ComentariosPOJO cPOJO) throws SQLException, IOException{
        
        try{
            
            abrirConexion();
            
            String nombre = cPOJO.getNombre();
            String comentario = cPOJO.getComentario();
                        
            String sql = "insert into COMENTARIOS values ('" + nombre + "', ' " + comentario + "')";
            
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
            
            cerrarConexion();
            
        }catch(SQLException x){
            
            
        }
        
        logg.write("Este metodo inserta el comentario \n\n");
        
    }
    
    public ArrayList<ComentariosPOJO> buscar(ComentariosPOJO cPOJO) throws SQLException, IOException{
        
        ResultSet mensajes;
        ArrayList<ComentariosPOJO> beans = new ArrayList();
        
        String nombre = cPOJO.getNombre();
        String comentario = cPOJO.getComentario();
        
        try{
            
            abrirConexion();
                        
            String sql = "select * from COMENTARIOS where NOMBRE like '%"    + nombre + "%' and COMENTARIOS like '%" + comentario + "%'";
            
            Statement stmt = conexion.createStatement();
            mensajes =stmt.executeQuery(sql);
            
            while(mensajes.next()){
                
                ComentariosPOJO dto = new ComentariosPOJO();
                dto.setNombre(mensajes.getString("Nombre"));
                dto.setComentario(mensajes.getString("Comentarios"));
                
                beans.add(dto);
            
            }
            
            cerrarConexion();
            
        }catch(SQLException x){
            
            
        }
        
        
        
       
        logg.write("Este metodo hace un arraylist con los comentarios \n\n");
        
        
        return beans;
        
    }
    
}