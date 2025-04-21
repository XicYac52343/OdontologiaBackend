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
import logica.clasePacientes;
import logica.claseResponsable;
import logica.controladora;

@WebServlet(name = "servletResponsable", urlPatterns = {"/servletResponsable"})
public class servletResponsable extends HttpServlet {
    controladora control = new controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletResponsable</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletResponsable at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<claseResponsable> listaResponsables = new ArrayList<>();
        listaResponsables = control.traerResponsables();
        
        HttpSession misession = request.getSession();
        misession.setAttribute("listaResponsables", listaResponsables);
        
        response.sendRedirect("verResponsables.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        LocalDate fecha_nac = LocalDate.parse(request.getParameter("fecha_nac"));

        String tipoResponsable = request.getParameter("tipoResponsable");

        claseResponsable responsable = new claseResponsable();
        responsable.setDni(dni);
        responsable.setNombre(nombre);
        responsable.setApellidos(apellido);
        responsable.setTelefono(telefono);
        responsable.setDireccion(direccion);
        responsable.setFecha_nac(fecha_nac);
        responsable.setTipoResponsable(tipoResponsable);
        control.crearResponsable(responsable);

        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
