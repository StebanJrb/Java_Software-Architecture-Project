package co.edu.unipiloto.arq.entity;

import co.edu.unipiloto.arq.entity.Seccion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-07-15T18:04:05")
@StaticMetamodel(Docente.class)
public class Docente_ { 

    public static volatile SingularAttribute<Docente, String> correo;
    public static volatile SingularAttribute<Docente, Long> id;
    public static volatile SingularAttribute<Docente, String> nombre;
    public static volatile ListAttribute<Docente, Seccion> secciones;

}