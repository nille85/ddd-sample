/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.infrastructure.users;

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
@ContextConfiguration(classes = UserDatabaseConfig.class)
@Slf4j
public class UserRepositoryIT {
    
    @Autowired
    private UserRepository repository;
    
    @Test
    public void testSave(){
        User user = new User();
        user.setGivenName("John");
        user.setFamilyName("Doe");
        
        repository.save(user);
        
        repository.findAll().stream()
                .forEach(u -> log.debug(u.toString()));
    }
    
}
