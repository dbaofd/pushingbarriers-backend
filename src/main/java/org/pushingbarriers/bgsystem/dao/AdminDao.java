package org.pushingbarriers.bgsystem.dao;

import org.pushingbarriers.bgsystem.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin,Integer> {
    Admin findAdminByAdminUsername(String adminName);

    Boolean existsAdminByAdminUsername(String adminName);

}
