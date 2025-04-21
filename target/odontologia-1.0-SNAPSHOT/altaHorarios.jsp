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
                        <h2 class="mt-4">Alta de Horario</h2>
                        <p>Por favor, completa la siguiente información:</p>
                        <form action="servletHorario" method="POST">
                            <div class="row mb-3">
                                <div class="col">
                                    <h5>Hora Inicio</h5>
                                    <input type="time" class="form-control" placeholder="Ingrese una hora de Inicio" name="hora_inicio" required> 
                                </div>
                                <div class="col">
                                    <h5>Hora Fin</h5>
                                    <input type="time" class="form-control" placeholder="Ingresa una hora de Fin" name="hora_fin" required>
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
