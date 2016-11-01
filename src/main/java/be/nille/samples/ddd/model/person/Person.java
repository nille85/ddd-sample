/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.ddd.model.person;


import be.nille.samples.ddd.model.magazine.Magazine;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.ToString;

/**
 *
 * @author Niels Holvoet
 */
@ToString
public class Person {
    
    private Long id;
    private final PersonName name;
    private List<MagazineSubscription> subscriptions;
    
    //constructor used for reading existing persons
    Person(final Long id, final PersonName name){
        this.id = id;
        this.name = name;
        this.subscriptions = new ArrayList<>();
    }
    //constructor used for saving new persons
    Person(final PersonName name){
        this(null, name);
    }

    public Long getId() {
        return id;
    }
    
    public PersonName getName(){
        return name;
    }
    
    public void subscribeTo(final Magazine magazine){
        MagazineSubscription subscription = new MagazineSubscription(magazine);
        subscriptions.add(subscription);
    }
    
    public void unsubscribe(final Magazine magazine){
        this.subscriptions = subscriptions.stream().filter(s -> {
            return !magazine.getCode().equals(s.getMagazine().getCode());
        }).collect(Collectors.toList());
    }

    

    public List<MagazineSubscription> getSubscriptions() {
        return subscriptions;
    }
    
    
    
    
    
    
    
}
