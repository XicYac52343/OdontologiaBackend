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
import logica.clasePacientes;
import logica.controladora;


@WebServlet(name = "servletEditarPaciente", urlPatterns = {"/servletEditarPaciente"})
public class servletEditarPaciente extends HttpServlet {
    controladora control = new controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletEditarPaciente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletEditarPaciente at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idPaciente = Integer.parseInt(request.getParameter("id"));
        clasePacientes paciente = control.traerPaciente(idPaciente);
        
        HttpSession misession = request.getSession();
        misession.setAttribute("pacienteEditar", paciente);
        response.sendRedirect("editarPaciente.jsp");
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

        String eps = request.getParameter("eps");
        String tipo_sangre = request.getParameter("tipo_sangre");
        
        int idResponsable = Integer.parseInt(request.getParameter("unResponsable"));
        
            
        clasePacientes paciente = (clasePacientes) request.getSession().getAttribute("pacienteEditar");
        paciente.setDni(dni);
        paciente.setNombre(nombre);
        paciente.setApellidos(apellido);
        paciente.setTelefono(telefono);
        paciente.setDireccion(direccion);
        paciente.setFecha_nac(fecha_nac);
        if(eps.equals("true")){
            paciente.setEps(true);
        }else{
            paciente.setEps(false);
        }
        paciente.setTipo_sangre(tipo_sangre);
        paciente.setUnResponsable(control.traerResponsable(idResponsable));

        control.editarPaciente(paciente);
        
        response.sendRedirect("servletPaciente");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
