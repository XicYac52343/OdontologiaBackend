<%@page import="logica.claseTurnos"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en">
    <%@include file="layout/header.jsp" %>

</head>  
<body class="sb-nav-fixed">
    <%@include file="layout/navBar.jsp" %>
    <%@include file="layout/validarSesion.jsp"%>
    <div id="layoutSidenav">
        <%@include file="layout/layoutSidenav_nav.jsp" %>
        <div id="layoutSidenav_content">

            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Clinica Odontológica</h1>
                    <div class="card mb-4">
                        <div class="card-header">
                            El mejor servicio con el mejor personal
                        </div>
                        <div class="card-body">
                            <table id="datatablesSimple">
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Fecha Turno</th>
                                        <th>Hora Turno</th>
                                        <th>Tratamiento</th>           
                                        <th>Odontólogo</th>                                
                                        <th>Paciente</th>                                
                                    </tr>
                                </thead>
                                <tbody>                             
                                    <%  
                                        List<claseTurnos> listaTurnos = (List) request.getSession().getAttribute("listaTurnosActuales");
                                        if (listaTurnos != null){
                                            for (claseTurnos turno : listaTurnos) {
                                    %>
                                    <tr>
                                        <td><%=turno.getId()%></td>
                                        <td><%=turno.getFecha_turno()%></td>
                                        <td><%=turno.getHora_turno()%></td>
                                        <td><%=turno.getTratamiento()%></td> 
                                        <td><%=turno.getUnOdontologo().getNombre()%></td>      
                                        <td><%=turno.getUnPaciente().getNombre()%></td>      
                                    </tr>
                                    <%
                                            }
                                        }
                                    %>
                                </tbody>
                            </table>
                            <center>
                                <img src="img/fondoOdontologia.jpg" class="card-img" alt="alt" style="width: 100%"/>
                            </center>
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
