/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.ddd.model.person;

import be.nille.samples.ddd.model.magazine.MagazineTransformer;
import be.nille.samples.infrastructure.legacy.database.users.Subscription;
import be.nille.samples.infrastructure.legacy.database.users.User;
import java.util.List;

/**
 *
 * @author Niels Holvoet
 */
public class PersonTransformer {

    public Person transform(final User user) {
        Person person = new Person(user.getId(),new PersonName(user.getGivenName(), user.getFamilyName()));
        MagazineTransformer magazineTransformer = new MagazineTransformer();
        List<Subscription> subscriptions = user.getSubscriptions();
        if (subscriptions != null) {
            subscriptions.forEach((Subscription subscription) -> {
                person.subscribeTo(magazineTransformer.transform(subscription.getMagazine()));
            });
        }
        return person;
    }
    
    

}
