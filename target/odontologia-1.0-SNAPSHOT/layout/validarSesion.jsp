<%@page import="logica.controladora"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.claseTurnos"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String usuario1 = (String) request.getSession().getAttribute("usuario");

    if (usuario1 == null) {
        response.sendRedirect("login.jsp");
    } else {
        controladora control = new controladora();
        List<claseTurnos> listaTurnosActuales = new ArrayList<>();
        LocalDate fechaActual = LocalDate.now();
           
        int idUsuario = (int) request.getSession().getAttribute("usuarioLoggeado");
        listaTurnosActuales = control.traerTurnosActuales(idUsuario, fechaActual);
        request.getSession().setAttribute("listaTurnosActuales", listaTurnosActuales);
    }
%>
