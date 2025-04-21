<%@page import="logica.clasePacientes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.claseOdontologo"%>
<%@page import="java.util.List"%>
<%@page import="logica.controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <%@include file="layout/header.jsp" %>
    <body class="sb-nav-fixed">
        <%@include file="layout/navBar.jsp" %>
        <div id="layoutSidenav">
            <%@include file="layout/layoutSidenav_nav.jsp" %>
            <div id="layoutSidenav_content">
                <main>
                    <div class="mt-1 m-3">
                        <h2 class="mt-4">Alta de Turnos</h2>
                        <p>Por favor, completa la siguiente información:</p>
                        <form action="servletTurno" method="POST">
                            <div class="row mb-3">
                                <div class="col">
                                    <h5>Día de turno</h5>
                                    <input type="date" class="form-control" placeholder="Ingresa la fecha" name="fecha_turno" required>
                                </div>
                                <div class="col">
                                    <h5>Hora de turno</h5>
                                    <input type="time" class="form-control" placeholder="Ingresa la hora" name="hora_turno" required>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col">
                                    <h5>Odontólogo</h5>
                                    <select name="odontologo">
                                        <%                                            controladora control = new controladora();
                                            List<claseOdontologo> listaOdontologos = new ArrayList<>();
                                            listaOdontologos = control.traerOdontologos();
                                            for (claseOdontologo odon : listaOdontologos) {
                                        %>
                                        <option value="<%=odon.getId()%>"><%=odon.getNombre()%> <%=odon.getApellidos()%></option>
                                        <%
                                            }
                                        %>
                                    </select>                                    
                                </div>
                                <div class="col">
                                    <h5>Paciente</h5>
                                    <select name="unPaciente">
                                        <%
                                            List<clasePacientes> listaPacientes = new ArrayList<>();
                                            listaPacientes = control.traerPacientes();
                                            for (clasePacientes paciente : listaPacientes) {
                                        %>
                                        <option value="<%=paciente.getId()%>"><%=paciente.getNombre()%> <%=paciente.getApellidos()%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                            </div>
                            <div class="row mb">
                                <div class="col">
                                    <input type="text" class="form-control" placeholder="Ingrese el tratamiento" name="tratamiento" required>
                                </div>
                            </div>
                            <div style="margin-top:10px">
                                <button type="submit" class="btn btn-success">Añadir</button>
                            </div>
                        </form>
                    </div>
                </main>
                <%@include file="layout/footer.jsp" %>
            </div>
        </div>
        <%@include file="layout/scripts.jsp" %>
    </body>
</html>
