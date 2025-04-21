package logica;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="TB_Responsables")
public class claseResponsable extends clasePersona implements Serializable {
    private String tipoResponsable;
    
    public claseResponsable(){
        
    }
    
    public claseResponsable(int id, String dni, String nombre, String apellidos, String telefono, String direccion, LocalDate fecha_nac, String tipoResponsable){
        super(id, dni, nombre, apellidos, telefono, direccion, fecha_nac);
        this.tipoResponsable = tipoResponsable;
    }
    
    public void setTipoResponsable(String tipoResponsable){
        this.tipoResponsable = tipoResponsable;
    }
    
    public String getTipoResponsable(){
        return tipoResponsable;
    }
}
