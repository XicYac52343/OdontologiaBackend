<%@page import="logica.claseResponsable"%>
<%@page import="logica.controladora"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.claseHorario"%>
<%@page import="java.util.List"%>
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
                        <h2 class="mt-4">Alta de Pacientes</h2>
                        <p>Por favor, completa la siguiente información:</p>
                        <form action="servletPaciente" method="POST">
                            <div class="row mb-3">
                                <div class="col">
                                    <input type="number" class="form-control" placeholder="Ingrese un DNI" name="dni" required> 
                                </div>
                                <div class="col">
                                    <input type="text" class="form-control" placeholder="Ingrese un nombre" name="nombre" required> 
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col">
                                    <input type="text" class="form-control" placeholder="Ingresa un apellido" name="apellido" required>
                                </div>
                                <div class="col">
                                    <input type="number" class="form-control" placeholder="Ingresa un teléfono" name="telefono" required>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col">
                                    <input type="text" class="form-control" placeholder="Ingrese una dirección" name="direccion" required>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col">
                                    <h5>Fecha de nacimiento</h5>
                                    <input type="date" class="form-control" placeholder="Ingresa una fecha de nacimiento" name="fecha_nac" required>
                                </div>
                            </div>
                            <div class="row mb-3">
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
                                <div class="col">
                                    <h5>Tipo de Sangre</h5>
                                    <select name="tipo_sangre">
                                        <option value="o+">O+</option>
                                        <option value="o-">O-</option>
                                        <option value="b-">B+</option>
                                        <option value="b-">B-</option>
                                    </select>
                                </div>
                                <div class="col">
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
                                </div>

                            </div>
                            <button type="submit" class="btn btn-success">Añadir</button>
                        </form>
                    </div>
                </main>
                <%@include file="layout/footer.jsp" %>
            </div>
        </div>
        <%@include file="layout/scripts.jsp" %>
    </body>
</html>
