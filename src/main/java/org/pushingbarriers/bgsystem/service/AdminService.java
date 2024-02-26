package org.pushingbarriers.bgsystem.service;

import org.pushingbarriers.bgsystem.model.Admin;

public interface AdminService {
    Boolean adminExistence(String adminName);
    Admin getAdmin(String adminName);
}
