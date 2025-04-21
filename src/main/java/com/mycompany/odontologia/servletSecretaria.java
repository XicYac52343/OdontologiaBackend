package com.mycompany.odontologia;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.claseOdontologo;
import logica.claseSecretaria;
import logica.claseUsuariosOdon;
import logica.controladora;


@WebServlet(name = "servletSecretaria", urlPatterns = {"/servletSecretaria"})
public class servletSecretaria extends HttpServlet {
    controladora control = new controladora();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletSecretaria</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletSecretaria at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List <claseSecretaria> listaSecretarias = new ArrayList<>();
        listaSecretarias = control.traerSecretarias();
        
        HttpSession misession = request.getSession();
        misession.setAttribute("listaSecretarias", listaSecretarias);
      
        response.sendRedirect("verSecretarios.jsp");
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
        
        claseUsuariosOdon usuario = new claseUsuariosOdon();
        usuario.setNombre(nombre);
        usuario.setContrasenia(contrasenia);
        usuario.setRol("secretaria");
        
        
        claseSecretaria secretaria = new claseSecretaria();
        secretaria.setDni(dni);
        secretaria.setNombre(nombre);
        secretaria.setApellidos(apellido);
        secretaria.setTelefono(telefono);
        secretaria.setDireccion(direccion);
        secretaria.setFecha_nac(fecha_nac);
        secretaria.setSector(sector);
        secretaria.setUnUsuario(usuario);
        

        control.crearSecretaria(secretaria);

        response.sendRedirect("index.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
