package com.mycompany.odontologia;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.controladora;


@WebServlet(name = "servletEliminarPaciente", urlPatterns = {"/servletEliminarPaciente"})
public class servletEliminarPaciente extends HttpServlet {
    controladora control = new controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletEliminarPaciente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletEliminarPaciente at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idPaciente = Integer.parseInt(request.getParameter("id"));
        control.eliminarPaciente(idPaciente);
        
        response.sendRedirect("servletPaciente");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
