package logica;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.claseOdontologo;
import logica.clasePacientes;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-04-20T22:37:30")
@StaticMetamodel(claseTurnos.class)
public class claseTurnos_ { 

    public static volatile SingularAttribute<claseTurnos, LocalTime> hora_turno;
    public static volatile SingularAttribute<claseTurnos, clasePacientes> unPaciente;
    public static volatile SingularAttribute<claseTurnos, Integer> id;
    public static volatile SingularAttribute<claseTurnos, LocalDate> fecha_turno;
    public static volatile SingularAttribute<claseTurnos, claseOdontologo> odontologo;
    public static volatile SingularAttribute<claseTurnos, String> tratamiento;

}