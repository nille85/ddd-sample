/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.ddd.acl.person;


import be.nille.samples.ddd.model.person.Person;
import be.nille.samples.infrastructure.legacy.database.magazines.Magazine;
import be.nille.samples.infrastructure.legacy.database.users.Subscription;
import be.nille.samples.infrastructure.legacy.database.users.User;
import be.nille.samples.infrastructure.legacy.database.users.UserRepository;
import java.util.Calendar;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
    
    @Test
    public void loadPersonWithSubscriptions(){
        User user = new User();
        user.setFamilyName("Doe");
        user.setGivenName("John");
        
        
        for(int i=1; i<4; i++){
            Subscription subscription = new Subscription();
            Calendar calendar = Calendar.getInstance();
            calendar.set(2017, 2, 16);
            subscription.setExpirationDate(calendar.getTime());
            Magazine magazine = new Magazine();
            magazine.setCode("KL"+i);
            magazine.setDescription("Magazine description " + i);
            subscription.setMagazine(magazine);
            user.getSubscriptions().add(subscription);
        }
        
        when(userRepository.findOne(any(Long.class))).thenReturn(user);

        Person person = aclPersonRepository.findOne(1L);
        assertFalse(person.getSubscriptions().isEmpty());
        log.debug(person.toString());
        
    }

}
