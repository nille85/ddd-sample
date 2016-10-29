/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.ddd.acl.person;

import be.nille.samples.ddd.model.person.Person;

import be.nille.samples.infrastructure.database.users.User;
import be.nille.samples.infrastructure.database.users.UserRepository;
import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Niels Holvoet
 */
@Slf4j
public class ACLPersonRepositoryTest {

    @Mock
    private UserRepository userRepository;

    

    @InjectMocks
    private ACLPersonRepository aclPersonRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loadPersonWithoutSubscriptions() {

        User user = new User();
        user.setFamilyName("Doe");
        user.setGivenName("John");
      

        when(userRepository.findOne(any(Long.class))).thenReturn(user);

        
       
        Person person = aclPersonRepository.findOne(1L);
        assertEquals("John Doe", person.getName().toString());
        

    }
    
    

}
