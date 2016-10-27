/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.ddd.model.person;

import java.util.List;

/**
 *
 * @author Niels Holvoet
 */
public interface PersonRepository {
    
    Person savePerson(Person person);
    
    void removePerson(final Long id);
    
    Person findPerson(final Long id);
    
    List<Person> findAll();
    
}
