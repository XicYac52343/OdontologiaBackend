<%@page import="logica.claseResponsable"%>
<%@page import="logica.claseResponsable"%>
<%@page import="logica.clasePacientes"%>
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
                            Editar Paciente:
                        </div>
                        <div class="card-body">
                            <form action="servletEditarPaciente" method="POST">
                                <table id="datatablesSimple">
                                    <thead style="background-color: grey">
                                        <tr>
                                            <th>Id</th>
                                            <th>Dni</th>
                                            <th>Nombre</th> 
                                            <th>Apellidos</th>
                                            <th>Teléfono</th>
                                            <th>Dirección</th>
                                            <th>Fecha Nacimiento</th>
                                            <th>EPS</th>
                                            <th>Tipo de Sangre</th>
                                            <th>Responsable</th>                     
                                        </tr>
                                    </thead>
                                    <tbody>                             
                                        <%                                            clasePacientes paciente = (clasePacientes) request.getSession().getAttribute("pacienteEditar");
                                        %>
                                        <tr>
                                            <td>
                                                <p><input type="text" name="id" value="<%=paciente.getId()%>" disabled></p>
                                            </td>
                                            <td>
                                                <p><input type="number" name="dni" value="<%=paciente.getDni()%>"></p>
                                            </td>
                                            <td>
                                                <p><input type="text" name="nombre" value="<%=paciente.getNombre()%>"></p>
                                            </td>
                                            <td>
                                                <p><input type="text" name="apellido" value="<%=paciente.getApellidos()%>"></p>
                                            </td>
                                            <td>
                                                <p><input type="number" name="telefono" value="<%=paciente.getTelefono()%>"></p>
                                            </td>
                                            <td>
                                                <p><input type="text" name="direccion" value="<%=paciente.getDireccion()%>"></p>
                                            </td>
                                            <td>
                                                <p><input type="date" name="fecha_nac" value="<%=paciente.getFecha_nac()%>"></p>
                                            </td>
                                            <td>
                                                <div class="col">
                                                    <h5>¿Posee EPS?</h5>
                                                    <div class="form-check">
                                                        <input type="radio" class="form-check-input" id="eps" name="eps" value="true" checked>
                                                        <label class="form-check-label" for="radio1">Si</label>
                                                    </div>
                                                    <div class="form-check">
                                                        <input type="radio" class="form-check-input" id="eps" name="eps" value="false" checked>
                                                        <label class="form-check-label" for="radio1">No</label>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="col">
                                                    <h5>Tipo de Sangre</h5>
                                                    <select name="tipo_sangre">
                                                        <option value="o+">O+</option>
                                                        <option value="o-">O-</option>
                                                        <option value="b-">B+</option>
                                                        <option value="b-">B-</option>
                                                    </select>
                                                </div>
                                            </td>
                                            <td>
                                                <h5>Responsable</h5>
                                                <select name="unResponsable">

                                                    <%                                        controladora control = new controladora();
                                                        List<claseResponsable> listaResponsables = new ArrayList<>();
                                                        listaResponsables = control.traerResponsables();

                                                        for (claseResponsable responsable : listaResponsables) {

                                                    %>
                                                    <option value="<%=responsable.getId()%>"><%=responsable.getNombre()%> <%=responsable.getApellidos()%></option>

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

