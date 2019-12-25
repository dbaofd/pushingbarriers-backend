package org.pushingbarriers.bgsystem.dao;

import org.pushingbarriers.bgsystem.model.Trainingtemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by baodong on 2019/12/3.
 */

@Repository
public interface TrainingtemplateDao extends JpaRepository<Trainingtemplate,Integer> {

}
