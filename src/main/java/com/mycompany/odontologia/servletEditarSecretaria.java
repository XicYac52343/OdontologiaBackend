package com.mycompany.odontologia;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.claseSecretaria;
import logica.claseUsuariosOdon;
import logica.controladora;


@WebServlet(name = "servletEditarSecretaria", urlPatterns = {"/servletEditarSecretaria"})
public class servletEditarSecretaria extends HttpServlet {
    controladora control = new controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletEditarSecretaria</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletEditarSecretaria at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idSecretaria = Integer.parseInt(request.getParameter("id"));
        
        claseSecretaria secretaria = control.traerSecretaria(idSecretaria);
        HttpSession misession = request.getSession();
        misession.setAttribute("secretariaEditar", secretaria);
        
        response.sendRedirect("editarSecretaria.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        LocalDate fecha_nac = LocalDate.parse(request.getParameter("fecha_nac"));
        String sector = request.getParameter("sector");
        String contrasenia = request.getParameter("contrasenia");
        
        
        claseSecretaria secretaria = (claseSecretaria) request.getSession().getAttribute("secretariaEditar");
        
        secretaria.setDni(dni);
        secretaria.setNombre(nombre);
        secretaria.setApellidos(apellido);
        secretaria.setTelefono(telefono);
        secretaria.setDireccion(direccion);
        secretaria.setFecha_nac(fecha_nac);
        secretaria.setSector(sector);
        secretaria.getUnUsuario().setNombre(nombre);
        secretaria.getUnUsuario().setContrasenia(contrasenia);
        

        control.editarSecretaria(secretaria);

        response.sendRedirect("servletSecretaria");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
