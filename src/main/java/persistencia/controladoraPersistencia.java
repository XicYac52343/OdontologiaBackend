package persistencia;

import java.util.List;
import logica.claseUsuariosOdon;


public class controladoraPersistencia {
    claseUsuariosOdonJpaController controladoraJPA = new claseUsuariosOdonJpaController();
    
    public void crearUsuario(claseUsuariosOdon usu){
        controladoraJPA.create(usu);
    }
    
    public List<claseUsuariosOdon> obtenerUsuarios(){
        return controladoraJPA.findclaseUsuariosOdonEntities();
    }
}
