package persistencia;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import logica.claseHorario;
import logica.claseOdontologo;
import logica.clasePacientes;
import logica.claseResponsable;
import logica.claseSecretaria;
import logica.claseTurnos;
import logica.claseUsuariosOdon;
import persistencia.exceptions.NonexistentEntityException;

public class controladoraPersistencia {

    claseUsuariosOdonJpaController controladoraJPA = new claseUsuariosOdonJpaController();
    claseHorarioJpaController controladoraHorarioJPA = new claseHorarioJpaController();
    claseOdontologoJpaController controladoraOdonJPA = new claseOdontologoJpaController();
    clasePacientesJpaController controladoraPacienteJPA = new clasePacientesJpaController();
    claseTurnosJpaController controladoraTurnosJPA = new claseTurnosJpaController();
    claseSecretariaJpaController controladoraSecreaJPA = new claseSecretariaJpaController();
    claseResponsableJpaController controladoraResponsableJPA = new claseResponsableJpaController();

    public void crearUsuario(claseUsuariosOdon usu) {
        controladoraJPA.create(usu);
    }

    public void crearHorario(claseHorario horario) {
        controladoraHorarioJPA.create(horario);
    }

    public void crearOdontologo(claseOdontologo odontologo) {
        controladoraOdonJPA.create(odontologo);
    }

    public void crearSecretaria(claseSecretaria secretaria) {
        controladoraSecreaJPA.create(secretaria);
    }

    public void crearPaciente(clasePacientes paciente) {
        controladoraPacienteJPA.create(paciente);
    }

    public void crearTurno(claseTurnos turno) {
        controladoraTurnosJPA.create(turno);
    }

    public void crearResponsable(claseResponsable responsable) {
        controladoraResponsableJPA.create(responsable);
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

    public List<claseSecretaria> traerSecretarias() {
        return controladoraSecreaJPA.findclaseSecretariaEntities();
    }

    public claseSecretaria traerSecretaria(int id) {
        return controladoraSecreaJPA.findclaseSecretaria(id);
    }

    public List<clasePacientes> traerPacientes() {
        return controladoraPacienteJPA.findclasePacientesEntities();
    }

    public List<claseTurnos> traerTurnos() {
        return controladoraTurnosJPA.findclaseTurnosEntities();
    }
    
    public claseTurnos traerTurno(int id){
        return controladoraTurnosJPA.findclaseTurnos(id);
    }

    public List<claseResponsable> traerResponsables() {
        return controladoraResponsableJPA.findclaseResponsableEntities();
    }

    public claseResponsable traerResponsable(int id) {
        return controladoraResponsableJPA.findclaseResponsable(id);
    }

    public List<claseTurnos> traerTurnosActuales(int usuario, LocalDate fechaActual) {
        EntityManager em = controladoraTurnosJPA.getEntityManager();

        if (usuario != -1) {
            Query query = em.createQuery("SELECT t FROM claseTurnos t WHERE t.odontologo.id = :idOdon AND t.fecha_turno =:fechaActual");
            query.setParameter("idOdon", usuario);
            query.setParameter("fechaActual", fechaActual);
            List<claseTurnos> listaTurnos = query.getResultList();
            return listaTurnos;
        }
        return controladoraTurnosJPA.findclaseTurnosEntities();
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

    public void eliminarTurno(int id) {
        try {
            controladoraTurnosJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarSecretaria(int id) {
        try {
            controladoraSecreaJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarPaciente(int id) {
        try {
            controladoraPacienteJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarOdontologo(int id) {
        try {
            controladoraOdonJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarResponsable(int id) {
        try {
            controladoraResponsableJPA.destroy(id);
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

    public void editarOdontologo(claseOdontologo odon) {
        try {
            controladoraOdonJPA.edit(odon);
        } catch (Exception ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarPaciente(clasePacientes paciente) {
        try {
            controladoraPacienteJPA.edit(paciente);
        } catch (Exception ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarResponsable(claseResponsable responsable) {
        try {
            controladoraResponsableJPA.edit(responsable);
        } catch (Exception ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarSecretaria(claseSecretaria secretaria) {
        try {
            controladoraSecreaJPA.edit(secretaria);
        } catch (Exception ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editarTurno(claseTurnos turno){
        try {
            controladoraTurnosJPA.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
