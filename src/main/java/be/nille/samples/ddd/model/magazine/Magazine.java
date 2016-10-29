/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.ddd.model.magazine;

import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Niels Holvoet
 */
@ToString
public class Magazine {

  
    private final String code;
    private String description;

    public Magazine(final String code) {
        if(StringUtils.isBlank(code)){
            throw new IllegalArgumentException("Code is a mandatory field");
        }
        this.code = code;
    }

    public String getCode() {
        return code;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
