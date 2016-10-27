/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.ddd.model.person;

import java.util.ArrayList;
import java.util.List;
import lombok.ToString;

/**
 *
 * @author Niels Holvoet
 */
@ToString
public class Person {
    
    private Long id;
    private String firstName;
    private String lastName;
    private final List<Subscription> subscriptions;
    
    public Person(){
       
        this.subscriptions = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }
    
    public void addSubscription(final Subscription subscription){
        this.subscriptions.add(subscription);
    }
    
    
    
    
    
}
