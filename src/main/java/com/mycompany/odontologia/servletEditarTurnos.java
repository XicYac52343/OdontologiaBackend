package com.mycompany.odontologia;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.claseTurnos;
import logica.controladora;

@WebServlet(name = "servletEditarTurnos", urlPatterns = {"/servletEditarTurnos"})
public class servletEditarTurnos extends HttpServlet {

    controladora control = new controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletEditarTurnos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletEditarTurnos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idTurno = Integer.parseInt(request.getParameter("id"));

        claseTurnos turno = control.traerTurno(idTurno);

        HttpSession misession = request.getSession();
        misession.setAttribute("turnoEditar", turno);

        response.sendRedirect("editarTurno.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LocalDate fecha_turno = LocalDate.parse(request.getParameter("fecha_turno"));
        LocalTime hora_turno = LocalTime.parse(request.getParameter("hora_turno"));

        String tratamiento = request.getParameter("tratamiento");
        int id_Odontologo = Integer.parseInt(request.getParameter("odontologo"));
        int id_Paciente = Integer.parseInt(request.getParameter("unPaciente"));

        claseTurnos turno = (claseTurnos) request.getSession().getAttribute("turnoEditar");
        turno.setFecha_turno(fecha_turno);
        turno.setHora_turno(hora_turno);
        turno.setTratamiento(tratamiento);
        turno.setUnOdontologo(control.traerOdontologo(id_Odontologo));
        turno.setUnPaciente(control.traerPaciente(id_Paciente));

        control.editarTurno(turno);
        response.sendRedirect("servletTurno");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
