package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.claseUsuariosOdon;
import persistencia.exceptions.NonexistentEntityException;


public class controladoraPersistencia {
    claseUsuariosOdonJpaController controladoraJPA = new claseUsuariosOdonJpaController();
    
    public void crearUsuario(claseUsuariosOdon usu){
        controladoraJPA.create(usu);
    }
    
    public List<claseUsuariosOdon> obtenerUsuarios(){
        return controladoraJPA.findclaseUsuariosOdonEntities();
    }
    
    public void eliminarUsuario(int id){
        try {
            controladoraJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
