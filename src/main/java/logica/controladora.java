package logica;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.controladoraPersistencia;
import persistencia.exceptions.NonexistentEntityException;

public class controladora {

    controladoraPersistencia controlPersis = new controladoraPersistencia();

    public void crearUsuario(claseUsuariosOdon usu) {
        controlPersis.crearUsuario(usu);
    }

    public void crearHorario(LocalTime hora_inicio, LocalTime hora_fin) {
        claseHorario horario = new claseHorario();
        horario.setHora_inicio(hora_inicio);
        horario.setHora_fin(hora_fin);
        controlPersis.crearHorario(horario);
    }

    public void crearOdontologo(claseOdontologo odontologo) {
        controlPersis.crearOdontologo(odontologo);
    }

    public void crearPaciente(clasePacientes paciente) {
        controlPersis.crearPaciente(paciente);
    }
    
    public void crearTurno(claseTurnos turno){
        controlPersis.crearTurno(turno);
    }

    public List<claseUsuariosOdon> traerUsuario() {
        return controlPersis.obtenerUsuarios();
    }

    public List<claseHorario> traerHorarios() {
        return controlPersis.traerHorarios();
    }

    public List<claseOdontologo> traerOdontologos() {
        return controlPersis.traerOdontologos();
    }

    public List<clasePacientes> traerPacientes() {
        return controlPersis.traerPacientes();
    }

    public claseHorario traerHorario(int id) {
        return controlPersis.traerHorario(id);
    }

    public claseOdontologo traerOdontologo(int id) {
        return controlPersis.traerOdontologo(id);
    }

    public clasePacientes traerPaciente(int id) {
        return controlPersis.traerPacientes(id);
    }

    public void editarUsuario(claseUsuariosOdon usu) {
        controlPersis.editarUsuario(usu);
    }

    public void eliminarUsuario(int id) {
        controlPersis.eliminarUsuario(id);
    }

    public void eliminarHorario(int id) {
        controlPersis.eliminarHorario(id);
    }

    public Boolean validarCredenciales(String correo, String contrasenia) {
        List<claseUsuariosOdon> listaUsuarios = new ArrayList<>();
        listaUsuarios = controlPersis.obtenerUsuarios();

        for (claseUsuariosOdon usu : listaUsuarios) {
            if (correo.equals(usu.getNombre()) && contrasenia.equals(usu.getContrasenia())) {
                return true;
            }
        }
        return false;
    }
}
