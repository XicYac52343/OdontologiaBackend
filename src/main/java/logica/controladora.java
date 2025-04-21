package logica;

import java.time.LocalDate;
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
    
    public void crearSecretaria(claseSecretaria secretaria){
        controlPersis.crearSecretaria(secretaria);
    }

    public void crearPaciente(clasePacientes paciente) {
        controlPersis.crearPaciente(paciente);
    }
    
    public void crearTurno(claseTurnos turno){
        controlPersis.crearTurno(turno);
    }
    
    public void crearResponsable(claseResponsable responsable){
        controlPersis.crearResponsable(responsable);
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
    
    public List<claseSecretaria> traerSecretarias(){
        return controlPersis.traerSecretarias();
    }
    
    public claseSecretaria traerSecretaria(int id){
        return controlPersis.traerSecretaria(id);
    }
    
    public List<claseTurnos> traerTurnos(){
        return controlPersis.traerTurnos();
    }
    
    public claseTurnos traerTurno(int id){
        return controlPersis.traerTurno(id);
    }
    
    public List<claseResponsable> traerResponsables(){
        return controlPersis.traerResponsables();
    }
    
    public claseResponsable traerResponsable(int id){
        return controlPersis.traerResponsable(id);
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

    
    public List<claseTurnos> traerTurnosActuales(int usuario, LocalDate fechaActual){
        
        List<claseOdontologo> listaOdontologos = new ArrayList<>();
        listaOdontologos = controlPersis.traerOdontologos();
        
        for(claseOdontologo odon :listaOdontologos){
            if(odon.getUnUsuario().getId() == usuario){
                return controlPersis.traerTurnosActuales(odon.getId(), fechaActual);
            }  
        }
        return controlPersis.traerTurnosActuales(-1, fechaActual);
    }
    
    public void editarUsuario(claseUsuariosOdon usu) {
        controlPersis.editarUsuario(usu);
    }
    
    public void editarOdontologo(claseOdontologo odon){
        controlPersis.editarOdontologo(odon);
    }
    
    public void editarResponsable(claseResponsable responsable){
        controlPersis.editarResponsable(responsable);
    }
        
    public void editarPaciente(clasePacientes paciente){
        controlPersis.editarPaciente(paciente);
    }
    
    public void editarSecretaria(claseSecretaria secretaria){
        controlPersis.editarSecretaria(secretaria);
    }
    
    public void editarTurno(claseTurnos turno){
        controlPersis.editarTurno(turno);
    }

    public void eliminarUsuario(int id) {
        controlPersis.eliminarUsuario(id);
    }

    public void eliminarHorario(int id) {
        controlPersis.eliminarHorario(id);
    }
    
    public void eliminarTurno(int id){
        controlPersis.eliminarTurno(id);
    }
    
    public void eliminarSecretaria(int id){
        controlPersis.eliminarSecretaria(id);
    }
    
    public void eliminarPaciente(int id){
        controlPersis.eliminarPaciente(id);
    }
    
    public void eliminarOdontologo(int id){
        controlPersis.eliminarOdontologo(id);
    }
    
    public void eliminarResponsable(int id){
        controlPersis.eliminarResponsable(id);
    }

    public int validarCredenciales(String correo, String contrasenia) {
        List<claseUsuariosOdon> listaUsuarios = new ArrayList<>();
        listaUsuarios = controlPersis.obtenerUsuarios();

        for (claseUsuariosOdon usu : listaUsuarios) {
            if (correo.equals(usu.getNombre()) && contrasenia.equals(usu.getContrasenia())) {
                return usu.getId();                
            }
        }
        return -1;
    }
}
