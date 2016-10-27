/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.infrastructure;

import be.nille.samples.infrastructure.magazines.Magazine;
import be.nille.samples.infrastructure.magazines.MagazineRepository;
import be.nille.samples.infrastructure.magazines.MagazinesDatabaseConfig;
import be.nille.samples.infrastructure.users.User;
import be.nille.samples.infrastructure.users.UserDatabaseConfig;
import be.nille.samples.infrastructure.users.UserRepository;
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
@ContextConfiguration(classes = {UserDatabaseConfig.class, MagazinesDatabaseConfig.class})
@Slf4j
public class MultipleDatabasesIT {
    
    @Autowired
    private MagazineRepository mRepository;
    @Autowired
    private UserRepository uRepository;
    
    @Test
    public void testSave(){
        saveMagazine();
        saveUser();
        
        mRepository.findAll().stream()
                .forEach(m -> log.debug(m.toString()));
        uRepository.findAll().stream()
                .forEach(u -> log.debug(u.toString()));
    }
    
    private void saveMagazine(){
        Magazine magazine = new Magazine();
        magazine.setCode("KL");
        magazine.setDescription("Description of a simple magazine");
        mRepository.save(magazine);
    }
    
    private void saveUser(){
        User user = new User();
        user.setGivenName("John");
        user.setFamilyName("Doe");
        
        uRepository.save(user);
    }
    
}
