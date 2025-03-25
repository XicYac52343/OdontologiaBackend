<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession misession = request.getSession();
    String usuario = (String) request.getSession().getAttribute("usuario");
    
    if(usuario == null){
        response.sendRedirect("login.jsp");
    }

%>
