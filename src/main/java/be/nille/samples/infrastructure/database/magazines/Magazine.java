/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.infrastructure.database.magazines;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Niels Holvoet
 */
@Entity
@Table(name = "MAGAZINE")
@Getter
@ToString
public class Magazine {

    
    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;
    
    @Column(name="CODE")
    @Setter
    private String code;
    
    @Column(name="DESCRIPTION")
    @Setter
    private String description;

}
