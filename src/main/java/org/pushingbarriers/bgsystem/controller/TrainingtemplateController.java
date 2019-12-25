package org.pushingbarriers.bgsystem.controller;

import org.pushingbarriers.bgsystem.annotation.AuthToken;
import org.pushingbarriers.bgsystem.model.Training;
import org.pushingbarriers.bgsystem.model.Trainingtemplate;
import org.pushingbarriers.bgsystem.service.TrainingtemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by baodong on 2019/12/3.
 */

@RestController
public class TrainingtemplateController {
    @Autowired
    private TrainingtemplateService trainingtemplateService;

    @GetMapping("/alltrainingtemplateinfo")
    @AuthToken
    public List<Trainingtemplate> findAllTrainingTemplateInfo(){
        return trainingtemplateService.findAllTrainingTemplateInfo();
    }

}
