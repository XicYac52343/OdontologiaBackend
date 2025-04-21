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
                        <h2 class="mt-4">Alta de Secretarias</h2>
                        <p>Por favor, completa la siguiente información:</p>
                        <form action="servletSecretaria" method="POST">
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
                                    <h5 style="visibility: hidden">Hola</h5>
                                    <input type="text" class="form-control" placeholder="Ingrese una dirección" name="direccion" required>
                                </div>
                                <div class="col">
                                    <h5>Fecha de nacimiento</h5>
                                    <input type="date" class="form-control" placeholder="Ingresa una fecha de nacimiento" name="fecha_nac" required>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col">
                                    <input type="text" class="form-control" placeholder="Ingrese el sector" name="sector" required>
                                </div>
                                <div class="col">
                                    <input type="password" class="form-control" placeholder="Ingresa una contraseña" name="contrasenia" required>
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
