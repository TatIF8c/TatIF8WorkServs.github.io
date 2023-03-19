/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import Logica.Arrays;
import Logica.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author santi
 */
@WebServlet(name = "modificarserv", urlPatterns = {"/modificarserv"})
public class modificarserv extends HttpServlet {

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
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        try{
                try (PrintWriter out = response.getWriter()) {
           
    out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
             out.println("<head> <style>.contenedor { background-color: #f5f5f5; border: 1px solid #ccc; padding: 20px; width: 400px; margin: 0 auto; font-family: Arial, sans-serif; } h2 { font-size: 24px; margin-bottom: 10px; } ul { list-style: none; margin: 0; padding: 0; } li { font-size: 16px; line-height: 1.5; margin-bottom: 10px; } li strong { font-weight: bold; margin-right: 10px; } </style>");
            out.println("</head>");
            String bus=request.getParameter("buspro");
            bus=bus.toUpperCase();
        for (Producto prod : Arrays.listprodu) {
            if(prod.getProducto().toUpperCase().equals(bus)){
                prod.setExistencias((prod.getExistencias()+Integer.parseInt(request.getParameter("cantpro"))));
               out.println(" <div class=\"contenedor\"><h1> Producto actualizado </h1> <ul> <li><strong>Nombre:</strong>"+prod.getProducto() +"</li> <li><strong>Precio:</strong>"+prod.getPresio()+"</li> <li><strong>Existencias:</strong>"+prod.getExistencias()+"</li> ");
            }
            else{
                out.println("<div class=\"contenedor\"><h1> El producto no esta registrado </h1>");
            }
        }
            out.println("</body>");
            out.println("</html>");
      } 
            }catch(InputMismatchException e){
                try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head> <style>.contenedor { background-color: #f5f5f5; border: 1px solid #ccc; padding: 20px; width: 400px; margin: 0 auto; font-family: Arial, sans-serif; } h2 { font-size: 24px; margin-bottom: 10px; } ul { list-style: none; margin: 0; padding: 0; } li { font-size: 16px; line-height: 1.5; margin-bottom: 10px; } li strong { font-weight: bold; margin-right: 10px; } </style>");
            out.println("</head>");
            out.println("<body>");
           out.println(" <div class=\"contenedor\"><h1> No se pudo completar el registro </h1> "); 
            out.println("</body>");
            out.println("</html>");
            }}
  
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
