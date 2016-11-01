/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.infrastructure.legacy.database.magazines;


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
@ContextConfiguration(classes = UserDatabaseConfig.class)
@Slf4j
public class MagazineRepositoryIT {
    
    @Autowired
    private MagazineRepository repository;
    
    @Test
    public void testSave(){
        Magazine magazine = new Magazine();
        magazine.setCode("KL");
        magazine.setDescription("Description of a simple magazine");
        
        repository.save(magazine);
        repository.findAll().stream()
                .forEach(m -> log.debug(m.toString()));
    }
    
}
