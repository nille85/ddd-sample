/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.ddd.model;

import java.util.List;

/**
 *
 * @author Niels Holvoet
 */
public interface ModelRepository<E,P> {
    
    void save(final E entity);
    
    E findOne(final P key);
    
    List<E> findAll();
    
}
