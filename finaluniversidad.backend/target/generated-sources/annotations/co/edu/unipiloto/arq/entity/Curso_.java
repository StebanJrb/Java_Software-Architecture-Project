package co.edu.unipiloto.arq.entity;

import co.edu.unipiloto.arq.entity.Seccion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-07-15T18:04:05")
@StaticMetamodel(Curso.class)
public class Curso_ { 

    public static volatile SingularAttribute<Curso, String> descripcion;
    public static volatile SingularAttribute<Curso, Long> id;
    public static volatile SingularAttribute<Curso, String> nombre;
    public static volatile ListAttribute<Curso, Seccion> secciones;

}