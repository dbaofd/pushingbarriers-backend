package org.pushingbarriers.bgsystem.dao;

import org.pushingbarriers.bgsystem.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by baodong on 2019/12/27.
 */
@Repository
public interface TeamDao extends JpaRepository<Team,Integer> {
}
