<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en">
    <%@include file="layout/header.jsp" %>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-5">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Iniciar Sesión</h3>
                                        <%
                                            HttpSession misession = request.getSession();
                                            Integer fallo = (Integer) request.getSession().getAttribute("fallo");
                                            if(fallo != null){
                                                if(fallo==1){
                                        %>
                                        <div class="alert alert-danger">
                                            <strong>Error</strong> en las credenciales
                                        </div>
                                        <%
                                                }
                                            }
                                        %>
                                    </div>
                                    <div class="card-body">
                                        <form action="servletLogin" method="POST">
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="inputNombre" type="text" placeholder="admin" name="nombre"/>
                                                <label for="inputName">Nombre</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="inputPassword" type="password" placeholder="Password" name="contrasenia" />
                                                <label for="inputPassword">Contraseña</label>
                                            </div>
                                            <div class="form-check mb-3">
                                                <input class="form-check-input" id="inputRememberPassword" type="checkbox" value="" />
                                                <label class="form-check-label" for="inputRememberPassword">Recordar Contraseña</label>
                                            </div>
                                            <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                                <a class="small" href="password.html">¿Olvidaste tu contraseña?</a>
                                                <button type="submit" class="btn btn-primary">Iniciar Sesión</button>
                                            </div>
                                        </form>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
                <%@include file="layout/footer.jsp" %>
            </div>
        </div>
        <%@include file="layout/scripts.jsp" %>
    </body>
</html>
