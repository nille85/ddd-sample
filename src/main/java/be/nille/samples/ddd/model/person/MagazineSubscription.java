/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.ddd.model.person;

import be.nille.samples.ddd.model.magazine.Magazine;
import java.util.Calendar;
import java.util.Date;
import lombok.ToString;

/**
 *
 * @author Niels Holvoet
 */
@ToString
public class MagazineSubscription {

    private final Date expirationDate;
    private final Magazine magazine;

    public MagazineSubscription(final Magazine magazine) {
        this.expirationDate = calculateExpirationDate();
        this.magazine = magazine;
    }

   
    public Date getExpirationDate() {
        return expirationDate;
    }

    private Date calculateExpirationDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, 1);
        return c.getTime();
    }

    public Magazine getMagazine() {
        return magazine;
    }
    
    

}
