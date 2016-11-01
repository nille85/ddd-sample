/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.ddd.model.person;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Niels Holvoet
 */
public class PersonFactoryTest {
    
    @Test
    public void create(){
        Person person = PersonFactory.create("John", "Doe");
        PersonName name = person.getName();
        assertEquals("John Doe", name.toString());
        
    }
    
}
