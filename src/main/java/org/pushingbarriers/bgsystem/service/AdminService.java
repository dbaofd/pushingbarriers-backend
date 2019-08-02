package org.pushingbarriers.bgsystem.service;

import org.pushingbarriers.bgsystem.model.Admin;

public interface AdminService {
    public Boolean adminExistence(String adminName);
    public Admin getAdmin(String adminName);
}
