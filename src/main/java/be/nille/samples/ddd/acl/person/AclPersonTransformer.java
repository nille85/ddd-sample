/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.ddd.acl.person;

import be.nille.samples.ddd.acl.magazine.AclMagazineTransformer;
import be.nille.samples.ddd.model.magazine.Magazine;
import be.nille.samples.ddd.model.person.MagazineSubscription;
import be.nille.samples.ddd.model.person.PersonName;
import be.nille.samples.ddd.model.person.Person;
import be.nille.samples.infrastructure.database.users.Subscription;
import be.nille.samples.infrastructure.database.users.User;
import java.util.List;

/**
 *
 * @author Niels Holvoet
 */
public class AclPersonTransformer {

    public Person transform(final User user) {
        Person person = new Person(user.getId(), new PersonName(user.getGivenName(), user.getFamilyName()));
        AclMagazineTransformer magazineTransformer = new AclMagazineTransformer();
        List<Subscription> subscriptions = user.getSubscriptions();
        if (subscriptions != null) {
            subscriptions.forEach((Subscription subscription) -> {
                person.subscribe(magazineTransformer.transform(subscription.getMagazine()));
            });
        }
        return person;
    }

}
