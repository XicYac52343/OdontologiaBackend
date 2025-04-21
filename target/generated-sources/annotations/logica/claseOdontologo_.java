package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.claseHorario;
import logica.claseTurnos;
import logica.claseUsuariosOdon;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-04-20T22:37:30")
@StaticMetamodel(claseOdontologo.class)
public class claseOdontologo_ extends clasePersona_ {

    public static volatile SingularAttribute<claseOdontologo, claseUsuariosOdon> unUsuario;
    public static volatile SingularAttribute<claseOdontologo, String> especialidad;
    public static volatile ListAttribute<claseOdontologo, claseTurnos> listaTurnos;
    public static volatile SingularAttribute<claseOdontologo, claseHorario> unHorario;

}