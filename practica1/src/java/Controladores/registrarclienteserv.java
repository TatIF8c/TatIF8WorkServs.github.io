/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import Logica.Arrays;
import Logica.Cliente;
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
@WebServlet(name = "registrarclienteserv", urlPatterns = {"/registrarclienteserv"})
public class registrarclienteserv extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
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

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
             String name= request.getParameter("name");
        String correo= request.getParameter("correo");
        String telefono= request.getParameter("cel");
        float saldo= Float.parseFloat(request.getParameter("saldo"));
        Cliente clii=new Cliente();
        if(clii.validarnombre(name)||clii.validarcorreo(correo)||clii.validartelefono(telefono)){
            Cliente cli= new Cliente(name,saldo,correo,telefono);
        Arrays.listcliente.add(cli);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head> <style>.contenedor { background-color: #f5f5f5; border: 1px solid #ccc; padding: 20px; width: 400px; margin: 0 auto; font-family: Arial, sans-serif; } h2 { font-size: 24px; margin-bottom: 10px; } ul { list-style: none; margin: 0; padding: 0; } li { font-size: 16px; line-height: 1.5; margin-bottom: 10px; } li strong { font-weight: bold; margin-right: 10px; } </style>");
            out.println("</head>");
            out.println("<body>");
            out.println(" <div class=\"contenedor\"><h1> Información del cliente </h1> <ul> <li><strong>Nombre:</strong>"+name+"</li>  <li><strong>Saldo:</strong>"+saldo+"</li> <li><strong>Correo:</strong>"+correo+"</li> <li><strong>Teléfono:</strong>"+telefono+"</li> </div>");
            out.println("</body>");
            out.println("</html>");
        }
        }else{
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head> <style>.contenedor { background-color: #f5f5f5; border: 1px solid #ccc; padding: 20px; width: 400px; margin: 0 auto; font-family: Arial, sans-serif; } h2 { font-size: 24px; margin-bottom: 10px; } ul { list-style: none; margin: 0; padding: 0; } li { font-size: 16px; line-height: 1.5; margin-bottom: 10px; } li strong { font-weight: bold; margin-right: 10px; } </style>");
            out.println("</head>");
            out.println("<body>");
            out.println(" <div class=\"contenedor\"><h1> No se pudo completar el registro </h1> </div>");
            out.println("</body>");
            out.println("</html>");
        }
        }
        }catch(InputMismatchException e){
             try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head> <style>.contenedor { background-color: #f5f5f5; border: 1px solid #ccc; padding: 20px; width: 400px; margin: 0 auto; font-family: Arial, sans-serif; } h2 { font-size: 24px; margin-bottom: 10px; } ul { list-style: none; margin: 0; padding: 0; } li { font-size: 16px; line-height: 1.5; margin-bottom: 10px; } li strong { font-weight: bold; margin-right: 10px; } </style>");
            out.println("</head>");
            out.println("<body>");
            out.println(" <div class=\"contenedor\"><h1> No se pudo completar el registro </h1> </div>");
            out.println("</body>");
            out.println("</html>");
        }
       
        
    }}

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
