package logica;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class claseSecretaria extends clasePersona implements Serializable {
    
    private String sector;
    
    @OneToOne (cascade = CascadeType.ALL)
    private claseUsuariosOdon unUsuario;
    
    public claseSecretaria(){
        
    }
    
    public claseSecretaria(String sector, claseUsuariosOdon unUsuario, int id, String dni, String nombre, String apellidos, String telefono, String direccion, LocalDate fecha_nac){
        super(id, dni, nombre, apellidos, telefono, direccion, fecha_nac);
        this.sector = sector;
        this.unUsuario = unUsuario;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public claseUsuariosOdon getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(claseUsuariosOdon unUsuario) {
        this.unUsuario = unUsuario;
    }
    
    
    
}
