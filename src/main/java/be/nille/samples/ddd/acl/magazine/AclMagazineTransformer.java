/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.ddd.acl.magazine;

import be.nille.samples.ddd.model.magazine.Magazine;

/**
 *
 * @author Niels Holvoet
 */
public class AclMagazineTransformer {
    
     public Magazine transform(final be.nille.samples.infrastructure.database.magazines.Magazine magazine) {
        Magazine aMagazine = new Magazine(magazine.getCode());
        aMagazine.setDescription(magazine.getDescription());
        return aMagazine;
    }
}
