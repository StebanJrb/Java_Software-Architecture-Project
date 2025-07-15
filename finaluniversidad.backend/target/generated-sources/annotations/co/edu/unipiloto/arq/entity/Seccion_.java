package co.edu.unipiloto.arq.entity;

import co.edu.unipiloto.arq.entity.Curso;
import co.edu.unipiloto.arq.entity.Docente;
import co.edu.unipiloto.arq.entity.Estudiante;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-07-15T18:04:05")
@StaticMetamodel(Seccion.class)
public class Seccion_ { 

    public static volatile SingularAttribute<Seccion, String> periodo;
    public static volatile SingularAttribute<Seccion, Curso> curso;
    public static volatile SingularAttribute<Seccion, Docente> docente;
    public static volatile SingularAttribute<Seccion, Long> id;
    public static volatile ListAttribute<Seccion, Estudiante> estudiantes;

}