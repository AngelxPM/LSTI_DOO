/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AngelxPM
 */
public class CrearLibro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            
                //El parámetro enviado a getParameter() deberá coincidir con la propiedad name del elemento de HTML
                //Ejemplo: <input type="text" name="variable" /> coincide con la siguiente línea:
                String variable = request.getParameter("variable");

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                
                

                out.println("<title>Información del Libro</title>");
                out.println("<link href=\"static/bookstore.css\" rel=\"stylesheet\" type=\"text/css\"/>");
                
                out.println("</head>");
                out.println("<body>");

                out.println("<h1>Se a creado un libro</h1>");
                out.println("<p>Nombre: " + request.getParameter("nombre") + " </p>");
                out.println("<p>ISBN: " + request.getParameter("isbn") + " </p>");
                out.println("<p>Fecha: " + request.getParameter("fecha") + " </p>");
                out.println("<p>Genero: " + request.getParameter("genero") + " </p>");
                out.println("<p>Editorial: " + request.getParameter("editorial") + " </p>");
                out.println("<p>Autor: " + request.getParameter("autor") + " </p>");

                out.println("</body>");
                out.println("</html>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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


