package com.mycompany.odontologia;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.claseResponsable;
import logica.controladora;

@WebServlet(name = "servletEditarResponsable", urlPatterns = {"/servletEditarResponsable"})
public class servletEditarResponsable extends HttpServlet {

    controladora control = new controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletEditarResponsable</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletEditarResponsable at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idResponsable = Integer.parseInt(request.getParameter("id"));

        claseResponsable responsable = control.traerResponsable(idResponsable);

        HttpSession misession = request.getSession();
        misession.setAttribute("responsableEditar", responsable);

        response.sendRedirect("editarResponsable.jsp");
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

        claseResponsable responsable = (claseResponsable) request.getSession().getAttribute("responsableEditar");
        responsable.setDni(dni);
        responsable.setNombre(nombre);
        responsable.setApellidos(apellido);
        responsable.setTelefono(telefono);
        responsable.setDireccion(direccion);
        responsable.setFecha_nac(fecha_nac);
        responsable.setTipoResponsable(tipoResponsable);
        control.editarResponsable(responsable);

        response.sendRedirect("servletResponsable");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
