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
                            <form action="servletEditarOdontologo" method="POST">
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
                                            <th>Especialidad</th>
                                            <th>Contraseña</th>
                                            <th>Horario</th>                     
                                        </tr>
                                    </thead>
                                    <tbody>                             
                                        <%                                    claseOdontologo odon = (claseOdontologo) request.getSession().getAttribute("odontologo");
                                        %>
                                        <tr>
                                            <td>
                                                <p><input type="text" name="id" value="<%=odon.getId()%>" disabled></p>
                                            </td>
                                            <td>
                                                <p><input type="number" name="dni" value="<%=odon.getDni()%>"></p>
                                            </td>
                                            <td>
                                                <p><input type="text" name="nombre" value="<%=odon.getNombre()%>"></p>
                                            </td>
                                            <td>
                                                <p><input type="text" name="apellido" value="<%=odon.getApellidos()%>"></p>
                                            </td>
                                            <td>
                                                <p><input type="number" name="telefono" value="<%=odon.getTelefono()%>"></p>
                                            </td>
                                            <td>
                                                <p><input type="text" name="direccion" value="<%=odon.getDireccion()%>"></p>
                                            </td>
                                            <td>
                                                <p><input type="date" name="fecha_nac" value="<%=odon.getFecha_nac()%>"></p>
                                            </td>
                                            <td>
                                                <p><input type="text" name="especialidad" value="<%=odon.getEspecialidad()%>"></p>
                                            </td>
                                            <td>
                                                <p><input type="text" name="contrasenia" value="<%=odon.getUnUsuario().getContrasenia()%>"></p>
                                            </td>
                                            <td>
                                                <select name="unHorario">
                                                    <%                                            controladora control = new controladora();
                                                        List<claseHorario> listaHorarios = new ArrayList<>();
                                                        listaHorarios = control.traerHorarios();
                                                        for (claseHorario horario : listaHorarios) {
                                                    %>
                                                    <option value="<%=horario.getId()%>"><%=horario.getHora_inicio()%> a <%=horario.getHora_fin()%></option>
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

