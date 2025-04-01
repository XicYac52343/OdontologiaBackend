package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.controladoraPersistencia;
import persistencia.exceptions.NonexistentEntityException;


public class controladora {
    controladoraPersistencia controlPersis = new controladoraPersistencia();
    
    public void crearUsuario(claseUsuariosOdon usu){
        controlPersis.crearUsuario(usu);
    }
    
    public List<claseUsuariosOdon> traerUsuario(){
        return controlPersis.obtenerUsuarios();
    }
    
    public void eliminarUsuario(int id){
        controlPersis.eliminarUsuario(id);
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
