/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.ddd.acl.person;


import be.nille.samples.ddd.model.person.PersonTransformer;
import be.nille.samples.ddd.model.magazine.Magazine;
import be.nille.samples.ddd.model.person.MagazineSubscription;
import be.nille.samples.ddd.model.person.Person;
import be.nille.samples.ddd.model.person.PersonName;
import be.nille.samples.ddd.model.person.PersonRepository;
import be.nille.samples.infrastructure.legacy.database.magazines.MagazineRepository;
import be.nille.samples.infrastructure.legacy.database.users.Subscription;
import be.nille.samples.infrastructure.legacy.database.users.User;
import be.nille.samples.infrastructure.legacy.database.users.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Niels Holvoet
 */
@Slf4j
public class ACLPersonRepository implements PersonRepository {

    private final UserRepository userRepository;
    private final MagazineRepository magazineRepository;

    public ACLPersonRepository(final UserRepository userRepository, final MagazineRepository magazineRepository) {
        this.userRepository = userRepository;
        this.magazineRepository = magazineRepository;
    }

   
    @Override
    public Person findOne(Long personId) {
        User user = userRepository.findOne(personId);
        return new PersonTransformer().transform(user);
    }

    @Override
    public List<Person> findAll() {
        return userRepository.findAll().stream()
                .map(user -> new PersonTransformer().transform(user))
                .collect(Collectors.toList());
    }

    @Override
    public Person save(Person person) {
        User user=  new User();
        PersonName personName = person.getName();
        if(personName != null){
            user.setFamilyName(personName.getLastName());
            user.setGivenName(personName.getFirstName());
        }
        List<MagazineSubscription> magazineSubscriptions = person.getSubscriptions();
        magazineSubscriptions.stream().forEach(magazineSubscription -> 
        {
            Subscription subscription = new Subscription();
            subscription.setExpirationDate(magazineSubscription.getExpirationDate());
            subscription.setUser(user);
            Magazine personMagazine = magazineSubscription.getMagazine();
            be.nille.samples.infrastructure.legacy.database.magazines.Magazine magazine = magazineRepository.findByCode(personMagazine.getCode());
            subscription.setMagazine(magazine);
            user.getSubscriptions().add(subscription);
            
        });
        
       
        User savedUser = userRepository.save(user);
        log.debug(savedUser.toString());
        return new PersonTransformer().transform(savedUser);
    }

    
}
