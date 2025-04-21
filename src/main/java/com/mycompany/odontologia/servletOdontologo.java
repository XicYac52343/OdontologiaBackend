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
import logica.claseHorario;
import logica.claseOdontologo;
import logica.claseUsuariosOdon;
import logica.controladora;

@WebServlet(name = "servletOdontologo", urlPatterns = {"/servletOdontologo"})
public class servletOdontologo extends HttpServlet {

    controladora control = new controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletOdontologo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletOdontologo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*List<claseHorario> listaHorarios = new ArrayList<>();
        listaHorarios = control.traerHorarios();

        HttpSession miSession = request.getSession();
        miSession.setAttribute("listaHorarios", listaHorarios);
    
        response.sendRedirect("altaOdontologos.jsp");*/

        List<claseOdontologo> listaOdontologos = new ArrayList<>();
        listaOdontologos = control.traerOdontologos();

        HttpSession misession = request.getSession();
        misession.setAttribute("listaOdontologos", listaOdontologos);

        response.sendRedirect("verOdontologos.jsp");
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
        String especialidad = request.getParameter("especialidad");
        String contrasenia = request.getParameter("contrasenia");
        int unHorario = Integer.parseInt(request.getParameter("unHorario"));

        claseUsuariosOdon usu = new claseUsuariosOdon();
        usu.setNombre(nombre);
        usu.setContrasenia(contrasenia);
        usu.setRol("odontologo");


        claseOdontologo odonto = new claseOdontologo();
        odonto.setDni(dni);
        odonto.setNombre(nombre);
        odonto.setApellidos(apellido);
        odonto.setTelefono(telefono);
        odonto.setDireccion(direccion);
        odonto.setFecha_nac(fecha_nac);
        odonto.setEspecialidad(especialidad);
        odonto.setUnUsuario(usu);

        odonto.setUnHorario(control.traerHorario(unHorario));

        control.crearOdontologo(odonto);

        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
