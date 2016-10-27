/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.ddd.model.person;

import be.nille.samples.ddd.model.magazine.Magazine;
import java.util.Date;
import lombok.ToString;

/**
 *
 * @author Niels Holvoet
 */
@ToString
public class Subscription {

    private Long id;
    private Date expirationDate;
    private Magazine magazine;

    Subscription(){}

    public Long getId() {
        return id;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Magazine getMagazine() {
        return magazine;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }
    
    

}
