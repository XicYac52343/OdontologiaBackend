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
                            <%                                    List<claseUsuariosOdon> listaUsuarios = (List) request.getSession().getAttribute("listaUsuarios");
                                for (claseUsuariosOdon usu : listaUsuarios) {
                            %>
                            <tr>
                                <td><%=usu.getId()%></td>
                                <td><%=usu.getNombre()%></td>
                                <%--<td><%=usu.getApellido()%></td>
                                <td><%=usu.getCorreo()%></td>--%>
                                <td><%=usu.getContrasenia()%></td>
                                <td><%=usu.getRol()%></td>      

                        <td style="width:10%; text-align:center;">
                            <form action="servletEliminarUsuario" method="POST">
                                <p><input type="hidden" name="id" value="<%=usu.getId()%>"></p>
                                <button type="submit" class="btn btn-outline-danger" style="margin:10px">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16">
                                    <path d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8z"/>
                                    </svg>
                                </button>
                            </form>
                            <form action="servletEditarUsuario" method="GET">
                                 <p><input type="hidden" name="id" value="<%=usu.getId()%>"></p>
                                <button type="submit" class="btn btn-outline-success" style="margin:10px">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
                                    <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325"/>
                                    </svg>
                                </button>
                            </form>
                        </td>
                        </tr>
                        <%
                            }
                        %>
                        <tr>
                            <td style="width: 10%; text-align: center;">
                                <a href="altaUsuarios.jsp">
                                    <img src="img/mas.png" alt="imagenCrear" style="width: 20%;">
                                </a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </main>
            <%@include file="layout/footer.jsp" %>
        </div>
    </div>
    <%@include file="layout/scripts.jsp" %>
</body>
</html>

