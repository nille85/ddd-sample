/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.ddd.model.person;

/**
 *
 * @author Niels Holvoet
 */
public class PersonFactory {
    
    public static Person create(final Long id, final PersonName name){
        return new Person(id, name);
    }
    
}
