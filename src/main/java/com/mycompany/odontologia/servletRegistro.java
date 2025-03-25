package com.mycompany.odontologia;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.claseUsuariosOdon;
import logica.controladora;


@WebServlet(name = "servletRegistro", urlPatterns = {"/servletRegistro"})
public class servletRegistro extends HttpServlet {
    controladora control = new controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletRegistro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletRegistro at " + request.getContextPath() + "</h1>");
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
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String contrasenia = request.getParameter("contrasenia");
        String repContrasenia = request.getParameter("repContrasenia");
        
        if(contrasenia.equals(repContrasenia)){
            claseUsuariosOdon usu = new claseUsuariosOdon();
            usu.setNombre(nombre);
            usu.setApellido(apellido);
            usu.setCorreo(correo);
            usu.setContrasenia(contrasenia);
            
            control.crearUsuario(usu);
            response.sendRedirect("login.jsp");
            
        }else{
            response.sendRedirect("register.jsp");
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
