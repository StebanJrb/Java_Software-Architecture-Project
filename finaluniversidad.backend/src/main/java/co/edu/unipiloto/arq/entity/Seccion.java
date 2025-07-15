/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arq.entity;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Seccion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String periodo;

    @ManyToOne
    private Curso curso;

    @ManyToOne
    private Docente docente;

    @ManyToMany
    private List<Estudiante> estudiantes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }
    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }
    public Docente getDocente() { return docente; }
    public void setDocente(Docente docente) { this.docente = docente; }
    public List<Estudiante> getEstudiantes() { return estudiantes; }
    public void setEstudiantes(List<Estudiante> estudiantes) { this.estudiantes = estudiantes; }
}
