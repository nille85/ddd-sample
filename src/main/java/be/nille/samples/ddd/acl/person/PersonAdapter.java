/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.ddd.acl.person;

import be.nille.samples.ddd.model.person.Person;
import be.nille.samples.infrastructure.users.User;

/**
 *
 * @author Niels Holvoet
 */
public class PersonAdapter {

    public static Person userToPerson(final User user) {
        Person person = new Person();
        person.setFirstName(user.getGivenName());
        person.setLastName(user.getFamilyName());
        return person;
    }

    public static User getUserFromPerson(final Person person) {
        User user = new User();
        user.setFamilyName(person.getLastName());
        user.setGivenName(person.getFirstName());
        return user;
    }

}
