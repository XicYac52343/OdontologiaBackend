package com.mycompany.odontologia;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.claseUsuariosOdon;
import logica.controladora;

@WebServlet(name = "servletEditarUsuario", urlPatterns = {"/servletEditarUsuario"})
public class servletEditarUsuario extends HttpServlet {
    controladora control = new controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletEditarUsuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletEditarUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<claseUsuariosOdon> listaUsuarios = new ArrayList<>();
        listaUsuarios = control.traerUsuario();
        HttpSession misession = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        
        for(int i = 0; i < listaUsuarios.size(); i++){
            if(listaUsuarios.get(i).getId() == id){
               misession.setAttribute("usuarioEditar", listaUsuarios.get(i));
               response.sendRedirect("verUsuarios.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String contrasenia = request.getParameter("contrasenia");
        String rol = request.getParameter("rol");
        
        claseUsuariosOdon usu = new claseUsuariosOdon();
        
        usu.setNombre(nombre);
        usu.setApellido(apellido);
        usu.setCorreo(correo);
        usu.setContrasenia(contrasenia);
        usu.setRol(rol);
        
        control.editarUsuario(usu);
        response.sendRedirect("verUsuarios.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
