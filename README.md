# Sistema Universitario - Gestión Académica

Este repositorio contiene el desarrollo del sistema universitario propuesto para la materia de Arquitectura de Software. El sistema está diseñado para gestionar de forma integral los procesos académicos de una institución educativa, incluyendo matrícula, asignación de docentes, administración de asignaturas, consulta de calificaciones, y más.

## 🧑‍💻 Integrantes del grupo

- **Julian Steban Ruiz Benavides**  
  `julian-ruiz2@upc.edu.co`  
- **Nicolas Esteban Calvo Ospina**  
  `nicolas-calvo@upc.edu.co`  
- **Santiago Chavez Lopez**  
  `santiago-chavez@upc.edu.co`  

---

## 📌 Descripción del proyecto

Este sistema permite automatizar y controlar el ciclo académico universitario. Está desarrollado siguiendo una arquitectura en capas (MVC), aplicando principios de modularidad, separación de responsabilidades y escalabilidad.

### Características principales:

- **Gestión de estudiantes**: Registro, consulta y seguimiento del historial académico.
- **Gestión de docentes**: Asignación a grupos y consulta de carga académica.
- **Matrícula de asignaturas**: Control por periodos, validación de cupos y prerrequisitos.
- **Gestión de calificaciones**: Registro y consulta por parte de los docentes.
- **Administración de planes de estudio**: Organización de asignaturas por programa.
- **Reportes académicos**: Generación de listados de notas, promedio, etc.

---

## ⚙️ Tecnologías utilizadas

- **Java EE 7**
- **GlassFish 4.1**
- **Apache Derby (embebido)**
- **JPA (Java Persistence API)**
- **JSF / JSP / Servlets**
- **EJB (Enterprise Java Beans)**
- **NetBeans 8.2**

---

## 📐 Arquitectura

El sistema sigue una arquitectura **en capas**:


Los módulos funcionales (matrícula, calificaciones, docentes, etc.) están organizados como paquetes independientes para facilitar la modificabilidad y la escalabilidad del sistema.

---

## 🧪 Atributos de calidad validados

A través de experimentación, se ha validado que el sistema cumple con los siguientes atributos de calidad:

- **Desempeño:** Opera con tiempos de respuesta < 2 segundos en escenarios de alta concurrencia.
- **Disponibilidad:** Soporta caídas parciales y reinicios con MTTR < 2 minutos.
- **Modificabilidad:** Permite implementar cambios funcionales en tiempo controlado sin impactar módulos no relacionados.

---

## 🗃️ Estructura del repositorio


---

## 📄 Licencia

Este proyecto es de uso académico, desarrollado como parte del curso de Arquitectura de Software de la Universidad Piloto de Colombia.

---

## 📬 Contacto

Para preguntas o reportes, puedes contactar a cualquiera de los integrantes del grupo.


