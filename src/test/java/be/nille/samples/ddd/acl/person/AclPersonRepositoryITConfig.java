/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.ddd.acl.person;

import be.nille.samples.infrastructure.legacy.database.magazines.MagazineRepository;
import be.nille.samples.infrastructure.legacy.database.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Niels Holvoet
 */
@Configuration
public class AclPersonRepositoryITConfig {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private MagazineRepository magazineRepository;
    
    @Bean
    public ACLPersonRepository personRepository(){
        return new ACLPersonRepository(userRepository, magazineRepository);
    }
    
}
