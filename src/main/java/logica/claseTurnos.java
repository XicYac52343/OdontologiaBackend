package logica;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="TB_Turnos")
public class claseTurnos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private LocalDate fecha_turno;
    
    private LocalTime hora_turno;
    
    private String tratamiento;
    
    @ManyToOne
    @JoinColumn(name="odontologo_id")
    private claseOdontologo odontologo; 
    
    @ManyToOne
    @JoinColumn(name="paciente")
    private clasePacientes unPaciente;
    
    
   
    
    public claseTurnos(){
        
    }

    public claseTurnos(int id, LocalDate fecha_turno, LocalTime hora_turno, String tratamiento, claseOdontologo unOdontologo, clasePacientes unPaciente) {
        this.id = id;
        this.fecha_turno = fecha_turno;
        this.hora_turno = hora_turno;
        this.tratamiento = tratamiento;
        this.odontologo = unOdontologo;
        this.unPaciente = unPaciente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha_turno() {
        return fecha_turno;
    }

    public void setFecha_turno(LocalDate fecha_turno) {
        this.fecha_turno = fecha_turno;
    }

    public LocalTime getHora_turno() {
        return hora_turno;
    }

    public void setHora_turno(LocalTime hora_turno) {
        this.hora_turno = hora_turno;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public claseOdontologo getUnOdontologo() {
        return odontologo;
    }

    public void setUnOdontologo(claseOdontologo unOdontologo) {
        this.odontologo = unOdontologo;
    }

    public clasePacientes getUnPaciente() {
        return unPaciente;
    }

    public void setUnPaciente(clasePacientes unPaciente) {
        this.unPaciente = unPaciente;
    }


    
}
