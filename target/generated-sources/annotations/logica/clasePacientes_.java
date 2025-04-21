package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.claseResponsable;
import logica.claseTurnos;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-04-20T22:37:30")
@StaticMetamodel(clasePacientes.class)
public class clasePacientes_ extends clasePersona_ {

    public static volatile SingularAttribute<clasePacientes, Boolean> eps;
    public static volatile SingularAttribute<clasePacientes, claseResponsable> unResponsable;
    public static volatile SingularAttribute<clasePacientes, String> tipo_sangre;
    public static volatile ListAttribute<clasePacientes, claseTurnos> listaTurnos;

}