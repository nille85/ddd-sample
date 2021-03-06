/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.samples.infrastructure.legacy.database.magazines;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Niels Holvoet
 */
@Repository
public interface MagazineRepository extends JpaRepository<Magazine, Long> {

    Magazine findByCode(final String code);
}
