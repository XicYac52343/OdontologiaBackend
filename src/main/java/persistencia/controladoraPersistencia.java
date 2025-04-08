package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.claseHorario;
import logica.claseOdontologo;
import logica.clasePacientes;
import logica.claseTurnos;
import logica.claseUsuariosOdon;
import persistencia.exceptions.NonexistentEntityException;

public class controladoraPersistencia {

    claseUsuariosOdonJpaController1 controladoraJPA = new claseUsuariosOdonJpaController1();
    claseHorarioJpaController1 controladoraHorarioJPA = new claseHorarioJpaController1();
    claseOdontologoJpaController controladoraOdonJPA = new claseOdontologoJpaController();
    clasePacientesJpaController controladoraPacienteJPA = new clasePacientesJpaController();
    claseTurnosJpaController controladoraTurnosJPA = new claseTurnosJpaController();

    public void crearUsuario(claseUsuariosOdon usu) {
        controladoraJPA.create(usu);
    }

    public void crearHorario(claseHorario horario) {
        controladoraHorarioJPA.create(horario);
    }

    public void crearOdontologo(claseOdontologo odontologo) {
        controladoraOdonJPA.create(odontologo);
    }

    public void crearPaciente(clasePacientes paciente) {
        controladoraPacienteJPA.create(paciente);
    }
    public void crearTurno(claseTurnos turno){
        controladoraTurnosJPA.create(turno);
    }
    public List<claseUsuariosOdon> obtenerUsuarios() {
        return controladoraJPA.findclaseUsuariosOdonEntities();
    }

    public List<claseHorario> traerHorarios() {
        return controladoraHorarioJPA.findclaseHorarioEntities();
    }

    public List<claseOdontologo> traerOdontologos() {
        return controladoraOdonJPA.findclaseOdontologoEntities();
    }

    public List<clasePacientes> traerPacientes() {
        return controladoraPacienteJPA.findclasePacientesEntities();
    }

    public claseHorario traerHorario(int id) {
        return controladoraHorarioJPA.findclaseHorario(id);
    }

    public claseOdontologo traerOdontologo(int id) {
        return controladoraOdonJPA.findclaseOdontologo(id);
    }

    public clasePacientes traerPacientes(int id) {
        return controladoraPacienteJPA.findclasePacientes(id);
    }

    public void eliminarUsuario(int id) {
        try {
            controladoraJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarHorario(int id) {
        try {
            controladoraHorarioJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarUsuario(claseUsuariosOdon usu) {
        try {
            controladoraJPA.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
