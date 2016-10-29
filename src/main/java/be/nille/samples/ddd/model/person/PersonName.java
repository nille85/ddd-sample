/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.ddd.model.person;

import org.apache.commons.lang3.StringUtils;



/**
 *
 * @author Niels Holvoet
 */
public final class PersonName {
    
    private final String firstName;
    private final String lastName;
    
    public PersonName(final String firstName, final String lastName){
        if(StringUtils.isBlank(firstName)){
            throw new IllegalArgumentException("Firstname is a mandatory field");
        }
        if(StringUtils.isBlank(lastName)){
            throw new IllegalArgumentException("Lastname is a mandatory field");
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    
    
    @Override
    public String toString(){
        return firstName + " " + lastName;
    }
    
}
