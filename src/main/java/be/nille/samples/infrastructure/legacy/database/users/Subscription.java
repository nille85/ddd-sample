/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.infrastructure.legacy.database.users;

import be.nille.samples.infrastructure.legacy.database.magazines.Magazine;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Niels Holvoet
 */
@Entity
@Table(name = "SUBSCRIPTION")
@Getter
public class Subscription {
    
    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;
    
    @Temporal(DATE)
    @Column(name="EXP_DATE")
    @Setter
    private Date expirationDate;
    
    @ManyToOne
    @JoinColumn(name = "MAGAZINE_ID")
    @Setter
    private Magazine magazine;
    
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @Setter
    private User user;
    
 
    
}
