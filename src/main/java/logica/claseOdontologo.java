package logica;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class claseOdontologo extends clasePersona implements Serializable {

    private String especialidad;
    
    @OneToMany (mappedBy="odontologo", cascade = CascadeType.ALL)
    private List<claseTurnos> listaTurnos;
    
    @OneToOne (cascade = CascadeType.ALL)
    private claseUsuariosOdon unUsuario;
    
    @OneToOne
    private claseHorario unHorario;
    
    public claseOdontologo(){
        
    }
    
    public claseOdontologo(String especialidad, List<claseTurnos> listaTurnos, claseUsuariosOdon unUsuario, claseHorario unHorario, int id, String dni, String nombre, String apellidos, String telefono, String direccion, LocalDate fecha_nac ){
        super(id, dni, nombre, apellidos, telefono, direccion, fecha_nac);
        this.especialidad = especialidad;
        this.listaTurnos = listaTurnos;
        this.unUsuario = unUsuario;
        this.unHorario = unHorario;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<claseTurnos> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<claseTurnos> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }

    public claseUsuariosOdon getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(claseUsuariosOdon unUsuario) {
        this.unUsuario = unUsuario;
    }

    public claseHorario getUnHorario() {
        return unHorario;
    }

    public void setUnHorario(claseHorario unHorario) {
        this.unHorario = unHorario;
    }
    
}
