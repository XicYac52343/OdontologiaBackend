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
                    <form action="servletEliminarUsuario" method="POST">
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
                                <%                                    
                                    List<claseUsuariosOdon> listaUsuarios = (List) request.getSession().getAttribute("listaUsuarios");
                                    for (claseUsuariosOdon usu : listaUsuarios) {
                                %>
                                <tr>
                                    <td><%=usu.getId()%></td>
                                    <p><input type="hidden" name="id" value="<%=usu.getId()%>"></p>
                                    <td><%=usu.getNombre()%></td>
                                    <td><%=usu.getApellido()%></td>
                                    <td><%=usu.getCorreo()%></td>
                                    <td><%=usu.getContrasenia()%></td>
                                    <td><%=usu.getRol()%></td>      
                                    <td style="width:10%; text-align:center;">                                        
                                        <button type="submit" style="padding:0; margin:0; border:0 transparent; background-color: transparent">
                                            <img src="img/bote-de-basura.png" alt="imagenEliminar" style="width: 20%"/>
                                        </button>
                                        <a style="margin-top:-5%" href="">
                                            <img src="img/lapiz.png" alt="imagenEditar" style="width: 20%; margin-left: 15%;">
                                        </a>
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
                    </form>
                </div>
            </main>
            <%@include file="layout/footer.jsp" %>
        </div>
    </div>
    <%@include file="layout/scripts.jsp" %>
</body>
</html>

