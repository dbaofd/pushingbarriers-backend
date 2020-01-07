package org.pushingbarriers.bgsystem.service;

import org.pushingbarriers.bgsystem.model.GameUpdateTime;

public interface UpdatetimeService {
    GameUpdateTime getUpdateTime(Integer id);
}
