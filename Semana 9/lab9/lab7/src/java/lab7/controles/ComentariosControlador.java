/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab7.controles;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.*;
import lab7.modelo.*;
import laboratorio9.utils.Log;
/**
 *
 * @author AngelxPM
 */
@WebServlet(name = "ComentariosControlador", urlPatterns = {"/ComentariosControlador"})
public class ComentariosControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String accion = request.getParameter("accion");
            
            Log logg = Log.getInstance("E:\\Nueva carpeta\\lab9\\lab7\\loggs.txt");
            
            // Nombres desde la pagina anterior
            String nombre = request.getParameter("txt-nombre");
            String comentario = request.getParameter("txt-comentario");
            
            ComentariosDAO cDAO = new ComentariosDAO();
            ComentariosPOJO cPOJO = new ComentariosPOJO();
            
            cPOJO.setNombre(nombre);
            cPOJO.setComentario(comentario);
            
            HttpSession session = request.getSession();
            
            if(accion.equals("comentar")){
                
                try{
                    
                            cDAO.insertar(cPOJO);
                            
                            response.sendRedirect("buscar.jsp");
                            
                    }catch(SQLException ex) {
                            Logger.getLogger(ComentariosControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }  
                
                logg.write("Este metodo hace un arraylist con los comentarios \n\n");
                
                
                
                
                
            }else if(accion.equals("buscar")){
                
                try{
                    
                            ArrayList<ComentariosPOJO> comentarios = cDAO.buscar(cPOJO);
                            
                            session.setAttribute("Comentarios", comentarios);
                            
                            response.sendRedirect("buscar.jsp");
                            
                            
                    }catch(SQLException ex) {
                           
                    }  
                
                logg.write("Este if compara ´buscar´ \n\n");
                
                
            }else{
                    response.sendRedirect("error.jsp");
                    logg.write("else te manda a error xdxd \n\n");
                   
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ComentariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ComentariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
