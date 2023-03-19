/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import Logica.Arrays;
import Logica.Cliente;
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
@WebServlet(name = "comprarserv", urlPatterns = {"/comprarserv"})
public class comprarserv extends HttpServlet {

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
            boolean bandera=true;
            try{
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            out.println("<head> <style>.contenedor { background-color: #f5f5f5; border: 1px solid #ccc; padding: 20px; width: 400px; margin: 0 auto; font-family: Arial, sans-serif; } h2 { font-size: 24px; margin-bottom: 10px; } ul { list-style: none; margin: 0; padding: 0; } li { font-size: 16px; line-height: 1.5; margin-bottom: 10px; } li strong { font-weight: bold; margin-right: 10px; } </style>");
            out.println("</head>");
            String bus=request.getParameter("busn");
            
            int cant= Integer.parseInt(request.getParameter("cant"));
            
            bus=bus.toUpperCase();
            for (Producto prod : Arrays.listprodu) {
                if(prod.getProducto().toUpperCase().equals(bus)){
                    if(prod.getExistencias()-cant>0){
                        out.println(" <div class=\"contenedor\"><h1> Información de la compra </h1> <ul> <li><strong>Nombre:</strong>"+prod.getProducto() +"</li> <li><strong>Total:</strong>"+(prod.getPresio()*cant)+"</li> <li><strong>Adquiridos:</strong>"+cant+"</li> ");
    
                        prod.setExistencias((prod.getExistencias()-cant));
                        Cliente cli=new Cliente();
                        cli.registrarproducto(prod);
                    }else{
                        out.println("<div class=\"contenedor\"><h1> No hay suficientes existencias </h1> ");
                          }
                
                }
                else{
                    out.println("<h1>El producto no esta registrado</h1>");
                    }
            } 
            out.println("</body>");
            out.println("</html>");
        }}catch(InputMismatchException e){
                        try (PrintWriter out = response.getWriter()) {
                             out.println("<!DOCTYPE html>");
                                out.println("<html>");
                                out.println("<body>");
                                out.println("<head> <style>.contenedor { background-color: #f5f5f5; border: 1px solid #ccc; padding: 20px; width: 400px; margin: 0 auto; font-family: Arial, sans-serif; } h2 { font-size: 24px; margin-bottom: 10px; } ul { list-style: none; margin: 0; padding: 0; } li { font-size: 16px; line-height: 1.5; margin-bottom: 10px; } li strong { font-weight: bold; margin-right: 10px; } </style>");
                                out.println("</head>");          
                                out.println("<div class=\"contenedor\"><h1> No hay suficientes existencias </h1> ");
                                out.println("</body>");
                                out.println("</html>");

                        }

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
