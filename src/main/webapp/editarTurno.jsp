<%@page import="logica.clasePacientes"%>
<%@page import="logica.claseTurnos"%>
<%@page import="logica.claseHorario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.controladora"%>
<%@page import="logica.claseOdontologo"%>
<%@page import="java.util.List"%>
<%@page import="logica.claseUsuariosOdon"%>
<%@page import="logica.claseUsuariosOdon"%>
<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en">
    <%@include file="layout/header.jsp" %>
</head>
<body class="sb-nav-fixed">
    <%@include file="layout/navBar.jsp" %>
    <div id="layoutSidenav">
        <%@include file="layout/layoutSidenav_nav.jsp" %>
        <div id="layoutSidenav_content">

            <main>
                <div class="mt-1 m-3" >
                    <div class="card mb-4">
                        <div class="card-header">
                            <i class="fas fa-table me-1"></i>
                            Editar Odontólogo:
                        </div>
                        <div class="card-body">
                            <form action="servletEditarTurnos" method="POST">
                                <table id="datatablesSimple">
                                    <thead style="background-color: grey">
                                        <tr>
                                            <th>Id</th>
                                            <th>Fecha de Turno</th>
                                            <th>Hora de Turno</th> 
                                            <th>Tratamiento</th>
                                            <th>Odontólogo</th>
                                            <th>Paciente</th>                   
                                        </tr>
                                    </thead>
                                    <tbody>                             
                                        <%                                            claseTurnos turno = (claseTurnos) request.getSession().getAttribute("turnoEditar");
                                        %>
                                        <tr>
                                            <td>
                                                <p><input type="text" name="id" value="<%=turno.getId()%>" disabled></p>
                                            </td>
                                            <td>
                                                <p><input type="date" name="fecha_turno" value="<%=turno.getFecha_turno()%>"></p>
                                            </td>
                                            <td>
                                                <p><input type="time" name="hora_turno" value="<%=turno.getHora_turno()%>"></p>
                                            </td>
                                            <td>
                                                <p><input type="tratamiento" name="tratamiento" value="<%=turno.getTratamiento()%>"></p>
                                            </td>
                                            <td>
                                                <select name="odontologo">
                                                    <%
                                                        controladora control = new controladora();
                                                        List<claseOdontologo> listaOdontologos = new ArrayList<>();
                                                        listaOdontologos = control.traerOdontologos();
                                                        for (claseOdontologo odonto : listaOdontologos) {
                                                    %>
                                                    <option value="<%=odonto.getId()%>"><%=odonto.getNombre()%> <%=odonto.getApellidos()%></option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </td>
                                            <td>
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
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                                <button type="submit" class="btn btn-success">
                                    Guardar
                                </button>
                                <form action="servletUsuario" method="GET">
                                    <button type="submit" class="btn btn-danger">
                                        Cancelar
                                    </button>
                                </form>
                            </form>
                        </div>
                    </div>

                </div>
            </main>
            <%@include file="layout/footer.jsp" %>
        </div>
    </div>
    <%@include file="layout/scripts.jsp" %>
</body>
</html>

