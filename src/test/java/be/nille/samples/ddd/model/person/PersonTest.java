/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.ddd.model.person;


import be.nille.samples.ddd.model.magazine.Magazine;
import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertFalse;

import org.junit.Test;


/**
 *
 * @author Niels Holvoet
 */
@Slf4j
public class PersonTest {
    
    
    
    @Test
    public void subscribeTo(){
        Magazine magazine = new Magazine("KL");
        magazine.setDescription("Description of this magazine");
        
        Person person = PersonFactory.create("John", "Doe");
        person.subscribeTo(magazine);
        assertFalse(person.getSubscriptions().isEmpty());
        
        person.getSubscriptions().forEach(subscription -> log.debug(subscription.toString()));
    }
    
}
