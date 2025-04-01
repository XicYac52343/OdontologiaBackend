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
                        <h2 class="mt-4">Alta de Usuarios</h2>
                        <p>Por favor, completa la siguiente información:</p>
                        <form action="servletUsuario" method="POST">
                            <div class="row mb-3">
                                <div class="col">
                                    <input type="text" class="form-control" placeholder="Ingrese un nombre" name="nombre" required> 
                                </div>
                                <div class="col">
                                    <input type="text" class="form-control" placeholder="Ingresa un apellido" name="apellido" required>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <input type="text" class="form-control" placeholder="Ingrese un correo" name="correo" required>
                                </div>
                                <div class="col">
                                    <input type="password" class="form-control" placeholder="Ingresa una contraseña" name="contrasenia" required>
                                </div>
                            </div>
                            <div class="form-check">
                                <input type="radio" class="form-check-input" id="rol" name="rol" value="secretaria" checked>
                                <label class="form-check-label" for="radio1">Secretaria</label>
                            </div>
                            <div class="form-check">
                                <input type="radio" class="form-check-input" id="rol" name="rol" value="odontologo" checked>
                                <label class="form-check-label" for="radio1">Odontólogo</label>
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
