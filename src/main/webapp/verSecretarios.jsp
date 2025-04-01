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
    <%@include file="layout/validarSesion.jsp" %>
    <div id="layoutSidenav">
        <%@include file="layout/layoutSidenav_nav.jsp" %>
        <div id="layoutSidenav_content">

            <main>
                <% 
                    List<claseUsuariosOdon> listaUsuarios = (List) request.getSession().getAttribute("listaUsuarios");
                    for (claseUsuariosOdon usu : listaUsuarios) {
                    if(usu.getRol().equals("Secretario")){
                %>
                <div class="card mb-4">
                    <div class="card-header">
                        <p>Nombre: <%=usu.getNombre()%></p>
                    </div>
                    <div class="card-body">
                        <p>Apellido: <%=usu.getApellido()%></p>
                        <p>Correo: <%=usu.getCorreo()%></p>
                        <p>Rol: <%=usu.getRol()%></p>
                    </div>
                </div>
                <%
                        }
                    }
                %>
            </main>
            <%@include file="layout/footer.jsp" %>
        </div>
    </div>
    <%@include file="layout/scripts.jsp" %>
</body>
</html>

