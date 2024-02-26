package org.pushingbarriers.bgsystem.controller;

import org.pushingbarriers.bgsystem.annotation.AuthToken;
import org.pushingbarriers.bgsystem.model.GameUpdateTime;
import org.pushingbarriers.bgsystem.service.UpdatetimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdatetimeController {
    @Autowired
    private UpdatetimeService updatetimeService;

    @GetMapping(value = "/get-update-time/{id}")
    @AuthToken
    public GameUpdateTime getUpdateTime(@PathVariable(value = "id") Integer id){
        return updatetimeService.getUpdateTime(id);
    }
}
