/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.ddd.acl.person;

import be.nille.samples.ddd.model.person.Person;
import be.nille.samples.ddd.model.person.PersonRepository;
import be.nille.samples.infrastructure.database.users.User;
import be.nille.samples.infrastructure.database.users.UserRepository;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Niels Holvoet
 */
public class ACLPersonRepository implements PersonRepository {

    private final UserRepository userRepository;
    

    public ACLPersonRepository(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   
    @Override
    public Person findOne(Long personId) {
        User user = userRepository.findOne(personId);
        return new AclPersonTransformer().transform(user);
    }

    @Override
    public List<Person> findAll() {
        return userRepository.findAll().stream()
                .map(user -> new AclPersonTransformer().transform(user))
                .collect(Collectors.toList());
    }

    
}
