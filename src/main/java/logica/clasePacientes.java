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
public class clasePacientes extends clasePersona implements Serializable {

    private boolean eps;
    private String tipo_sangre;
    
    @OneToMany (mappedBy="unPaciente", cascade = CascadeType.ALL)
    private List<claseTurnos> listaTurnos;
    
    @OneToOne
    private claseResponsable unResponsable;
    
    public clasePacientes(){
        
    }
    
    public clasePacientes(boolean eps, String tipo_sangre, List<claseTurnos> listaTurnos, int id, String dni, String nombre, String apellidos, String telefono, String direccion, LocalDate fecha_nac, claseResponsable unResponsable){
        super(id, dni, nombre, apellidos, telefono, direccion, fecha_nac);
        this.eps = eps;
        this.tipo_sangre = tipo_sangre;
        this.listaTurnos = listaTurnos;
        this.unResponsable = unResponsable;
    }

    public boolean isEps() {
        return eps;
    }

    public void setEps(boolean eps) {
        this.eps = eps;
    }

    public String getTipo_sangre() {
        return tipo_sangre;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }

    public List<claseTurnos> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<claseTurnos> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }

    public claseResponsable getUnResponsable() {
        return unResponsable;
    }

    public void setUnResponsable(claseResponsable unResponsable) {
        this.unResponsable = unResponsable;
    }
}
