/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.infrastructure.users;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Niels Holvoet
 */
@Entity
@Table(name = "USER")
@Getter
@ToString
public class User {
    
    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;
    
    @Column(name="GIVEN_NAME")
    @Setter
    private String givenName;
    
    @Column(name="FAMILY_NAME")
    @Setter
    private String familyName;
    
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Subscription> subscriptions;
    
 
    
}
