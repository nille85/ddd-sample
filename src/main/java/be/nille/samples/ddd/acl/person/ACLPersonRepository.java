/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.ddd.acl.person;

import be.nille.samples.ddd.model.person.Person;
import be.nille.samples.ddd.model.person.PersonRepository;
import be.nille.samples.infrastructure.magazines.MagazineRepository;
import be.nille.samples.infrastructure.users.User;
import be.nille.samples.infrastructure.users.UserRepository;
import java.util.List;

/**
 *
 * @author Niels Holvoet
 */
public class ACLPersonRepository implements PersonRepository {
    
    private final UserRepository userRepository;
    private final MagazineRepository magazineRepository;
    
    public ACLPersonRepository(final UserRepository userRepository, final MagazineRepository magazineRepository){
        this.userRepository = userRepository;
        this.magazineRepository = magazineRepository;
    }

    @Override
    public Person savePerson(Person person) {
        User user = PersonAdapter.getUserFromPerson(person);
        user = userRepository.save(user);
        return findPerson(user.getId());
    }

    @Override
    public void removePerson(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person findPerson(Long id) {
        User user = userRepository.findOne(id);
        return PersonAdapter.userToPerson(user);
    }

    @Override
    public List<Person> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
