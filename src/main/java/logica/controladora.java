package logica;

import java.util.ArrayList;
import java.util.List;
import persistencia.controladoraPersistencia;


public class controladora {
    controladoraPersistencia controlPersis = new controladoraPersistencia();
    
    public void crearUsuario(claseUsuariosOdon usu){
        controlPersis.crearUsuario(usu);
    }
    
    public Boolean validarCredenciales(String correo, String contrasenia){
        List <claseUsuariosOdon> listaUsuarios = new ArrayList<>();
        listaUsuarios = controlPersis.obtenerUsuarios();
        
        for(claseUsuariosOdon usu : listaUsuarios){
            if(correo.equals(usu.getCorreo()) && contrasenia.equals(usu.getContrasenia())){
                return true;
            }
        }
        return false;
    }
}
