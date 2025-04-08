package com.mycompany.odontologia;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.claseHorario;
import logica.controladora;


@WebServlet(name = "servletHorario", urlPatterns = {"/servletHorario"})
public class servletHorario extends HttpServlet {
    controladora control = new controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletHorario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletHorario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<claseHorario> listaHorarios = new ArrayList<>();
        listaHorarios = control.traerHorarios();
        HttpSession miSession = request.getSession();
        miSession.setAttribute("listaHorarios", listaHorarios);
        response.sendRedirect("verHorarios.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LocalTime hora_inicio = LocalTime.parse(request.getParameter("hora_inicio"));
        LocalTime hora_fin = LocalTime.parse(request.getParameter("hora_fin"));
        
        control.crearHorario(hora_inicio, hora_fin);
        
        response.sendRedirect("servletHorario");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
