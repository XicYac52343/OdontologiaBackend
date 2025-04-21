package com.mycompany.odontologia;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
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

@WebServlet(name = "servletTurno", urlPatterns = {"/servletTurno"})
public class servletTurno extends HttpServlet {

    controladora control = new controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletTurno</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletTurno at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<claseTurnos> listaTurnos = new ArrayList<>();
        listaTurnos = control.traerTurnos();

        HttpSession misession = request.getSession();
        misession.setAttribute("listaTurnos", listaTurnos);
        
        response.sendRedirect("verTurnos.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LocalDate fecha_turno = LocalDate.parse(request.getParameter("fecha_turno"));
        LocalTime hora_turno = LocalTime.parse(request.getParameter("hora_turno"));

        String tratamiento = request.getParameter("tratamiento");
        int id_Odontologo = Integer.parseInt(request.getParameter("odontologo"));
        int id_Paciente = Integer.parseInt(request.getParameter("unPaciente"));

        claseTurnos turno = new claseTurnos();
        turno.setFecha_turno(fecha_turno);
        turno.setHora_turno(hora_turno);
        turno.setTratamiento(tratamiento);
        turno.setUnOdontologo(control.traerOdontologo(id_Odontologo));
        turno.setUnPaciente(control.traerPaciente(id_Paciente));

        control.crearTurno(turno);
        response.sendRedirect("index.jsp");

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
