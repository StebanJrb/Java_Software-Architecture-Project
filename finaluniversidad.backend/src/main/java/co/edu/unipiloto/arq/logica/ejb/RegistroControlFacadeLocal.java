/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arq.logica.ejb;


import co.edu.unipiloto.arq.entity.RegistroControl;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ASUS
 */
@Local
public interface RegistroControlFacadeLocal {

    void create(RegistroControl registroControl);

    void edit(RegistroControl registroControl);

    void remove(RegistroControl registroControl);

    RegistroControl find(Object id);

    List<RegistroControl> findAll();

    List<RegistroControl> findRange(int[] range);

    int count();
    
}
