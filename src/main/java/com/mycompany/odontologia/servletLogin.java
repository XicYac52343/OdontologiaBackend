package com.mycompany.odontologia;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.claseOdontologo;
import logica.claseTurnos;
import logica.controladora;
import logica.claseUsuariosOdon;


@WebServlet(name = "servletLogin", urlPatterns = {"/servletLogin"})
public class servletLogin extends HttpServlet {
    controladora control = new controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletLogin at " + request.getContextPath() + "</h1>");
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
        request.getSession().removeAttribute("usuario");
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath()+"/login.jsp");
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
        String nombre = request.getParameter("nombre");
        String contrasenia = request.getParameter("contrasenia");
        HttpSession misession = request.getSession(true);
        int usuario = control.validarCredenciales(nombre, contrasenia);
        
        if(usuario != -1){
            misession.setAttribute("usuario", nombre);
            misession.setAttribute("fallo", 0);
            
            List<claseTurnos> listaTurnosActuales = new ArrayList<>();
            LocalDate fechaActual = LocalDate.now();
            
            listaTurnosActuales = control.traerTurnosActuales(usuario, fechaActual);
            misession.setAttribute("listaTurnosActuales", listaTurnosActuales);
            misession.setAttribute("usuarioLoggeado", usuario);
            
            response.sendRedirect("index.jsp");
        }else{
            misession.setAttribute("fallo", 1);
            response.sendRedirect("login.jsp");
        }
        
        /*claseUsuariosOdon usu1 = new claseUsuariosOdon();
        usu1.setNombre("admin");
        usu1.setApellido("master");
        usu1.setCorreo("admin@gmail.com");
        usu1.setContrasenia("123456");
        usu1.setRol("secretaria");
        
        control.crearUsuario(usu1);
        
        response.sendRedirect("login.jsp");*/
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
