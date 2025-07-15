/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arq.logica.ejb;


import co.edu.unipiloto.arq.entity.Docente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ASUS
 */
@Local
public interface DocenteFacadeLocal {

    void create(Docente docente);

    void edit(Docente docente);

    void remove(Docente docente);

    Docente find(Object id);

    List<Docente> findAll();

    List<Docente> findRange(int[] range);

    int count();
    
}
