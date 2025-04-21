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
                            <form action="servletEditarResponsable" method="POST">
                                <table id="datatablesSimple">
                                    <thead style="background-color: grey">
                                        <tr>
                                            <th>Id</th>
                                            <th>Dni</th>
                                            <th>Nombre</th> 
                                            <th>Apellidos</th>
                                            <th>Teléfono</th>
                                            <th>Dirección</th>
                                            <th>Fecha de nacimiento</th>
                                            <th>Tipo de responsable</th>                    
                                        </tr>
                                    </thead>
                                    <tbody>                             
                                        <%                                            
                                            claseResponsable responsable = (claseResponsable) request.getSession().getAttribute("responsableEditar");
                                        %>
                                        <tr>
                                            <td>
                                                <p><input type="text" name="id" value="<%=responsable.getId()%>" disabled></p>
                                            </td>
                                            <td>
                                                <p><input type="number" name="dni" value="<%=responsable.getDni()%>"></p>
                                            </td>
                                            <td>
                                                <p><input type="text" name="nombre" value="<%=responsable.getNombre()%>"></p>
                                            </td>
                                            <td>
                                                <p><input type="text" name="apellido" value="<%=responsable.getApellidos()%>"></p>
                                            </td>
                                            <td>
                                                <p><input type="number" name="telefono" value="<%=responsable.getTelefono()%>"></p>
                                            </td>
                                            <td>
                                                <p><input type="text" name="direccion" value="<%=responsable.getDireccion()%>"></p>
                                            </td>
                                            <td>
                                                <p><input type="date" name="fecha_nac" value="<%=responsable.getFecha_nac()%>"></p>
                                            </td>
                                            <td>
                                                <p><input type="text" name="tipoResponsable" value="<%=responsable.getTipoResponsable()%>"></p>
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

