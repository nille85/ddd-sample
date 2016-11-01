/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.ddd.acl.person;

import be.nille.samples.ddd.model.person.Person;
import be.nille.samples.ddd.model.person.PersonFactory;
import be.nille.samples.infrastructure.legacy.database.UserDatabaseConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Niels Holvoet
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {UserDatabaseConfig.class, AclPersonRepositoryITConfig.class})
@Slf4j
public class AclPersonRepositoryIT {
    
    @Autowired
    private ACLPersonRepository personRepository;
    
    @Test
    public void saveLoad(){
        Person person = PersonFactory.create("John", "Doe");
        Person savedPerson = personRepository.save(person);
        log.debug(savedPerson.toString());
        Person retrievedPerson = personRepository.findOne(savedPerson.getId());
        log.debug(retrievedPerson.toString());
    }
    
    
}
