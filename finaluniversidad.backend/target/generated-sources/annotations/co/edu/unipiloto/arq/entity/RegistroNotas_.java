package co.edu.unipiloto.arq.entity;

import co.edu.unipiloto.arq.entity.Estudiante;
import co.edu.unipiloto.arq.entity.Seccion;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-07-15T18:04:05")
@StaticMetamodel(RegistroNotas.class)
public class RegistroNotas_ { 

    public static volatile SingularAttribute<RegistroNotas, Estudiante> estudiante;
    public static volatile SingularAttribute<RegistroNotas, Seccion> seccion;
    public static volatile SingularAttribute<RegistroNotas, Long> id;
    public static volatile SingularAttribute<RegistroNotas, Double> nota;

}