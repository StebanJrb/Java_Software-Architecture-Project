/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arq.logica.ejb;

import co.edu.unipiloto.arq.entity.RegistroNotas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ASUS
 */
@Local
public interface RegistroNotasFacadeLocal {

    void create(RegistroNotas registroNotas);

    void edit(RegistroNotas registroNotas);

    void remove(RegistroNotas registroNotas);

    RegistroNotas find(Object id);

    List<RegistroNotas> findAll();

    List<RegistroNotas> findRange(int[] range);

    int count();
    
}
