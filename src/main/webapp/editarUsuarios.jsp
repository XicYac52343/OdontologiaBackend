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
                <div class="mt-1 m-3 rounded-3" >
                    <h1 class="mt-4">Clinica Odontológica</h1>
                    <form action="servletEditarUsuario" method="POST">
                        <table class="table table-bordered table-hover">
                            <thead style="background-color: grey">
                                <tr>
                                    <th>Id</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Correo</th>
                                    <th>Contraseña</th>
                                    <th>Rol</th>           
                                    <th>Opciones</th>                                
                                </tr>
                            </thead>
                            <tbody>                             
                                <%                                    claseUsuariosOdon usu = (claseUsuariosOdon) request.getSession().getAttribute("usuarioEditar");
                                %>
                                <tr>
                                    <td><%=usu.getId()%></td>
                            <p><input type="hidden" name="id" value="<%=usu.getId()%>"></p>
                            <td><input type="text" name="nombre" value="<%=usu.getNombre()%>"></td>
                            <%--<td><input type="text" name="apellido" value="<%=usu.getApellido()%>"</td>
                            <td><input type="text" name="correo" value="<%=usu.getCorreo()%>"</td>--%>
                            <td><input type="text" name="contrasenia" value="<%=usu.getContrasenia()%>"</td>
                            <td>Rol:<%=usu.getRol()%>
                                <div class="form-check">
                                    <input type="radio" class="form-check-input" id="rol" name="rol" value="secretaria" checked>
                                    <label class="form-check-label" for="radio1">Secretaria</label>
                                </div>
                                <div class="form-check">
                                    <input type="radio" class="form-check-input" id="rol" name="rol" value="odontologo" checked>
                                    <label class="form-check-label" for="radio1">Odontólogo</label>
                                </div>
                            </td>      
                            </tr>
                            </tbody>
                        </table>
                        <button type="submit" class="btn btn-success">
                            Guardar
                        </button>
                    </form>
                    <form action="servletUsuario" method="GET">
                        <button type="submit" class="btn btn-danger" style="margin-top:10px">
                            Cancelar
                        </button>
                    </form>
                </div>
            </main>
            <%@include file="layout/footer.jsp" %>
        </div>
    </div>
    <%@include file="layout/scripts.jsp" %>
</body>
</html>

