package org.pushingbarriers.bgsystem.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.pushingbarriers.bgsystem.annotation.AuthToken;
import org.pushingbarriers.bgsystem.model.Training;
import org.pushingbarriers.bgsystem.model.Trainingtemplate;
import org.pushingbarriers.bgsystem.service.TrainingtemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping(value="/updateTrainingTemplateInfo")
    @AuthToken
    public JSONObject updateTrainingtemplate(String day, String time, Integer playerId, String playerName,
                                             String playerGender, Integer driverId, String driverName,
                                             String driverGender, String club, String playerAddress,
                                             String trainingAddress, Integer id){
        trainingtemplateService.updateTrainingtemplate(day,time, playerId,playerName,
                playerGender,driverId,driverName,driverGender,club,playerAddress,trainingAddress,id);
        JSONObject result = new JSONObject();
        result.put("msg","update training template info successfully");
        return result;
    }

    @PostMapping(value="/insertNewTraining")
    @AuthToken
    public JSONObject insertNewTraining(String day, String time, Integer playerId, String playerName,
                                        String playerGender, Integer driverId, String driverName,
                                        String driverGender, String club, String playerAddress,
                                        String trainingAddress){
        trainingtemplateService.saveNewTraining(day,time, playerId,playerName,
                playerGender,driverId,driverName,driverGender,club,playerAddress,trainingAddress);
        JSONObject result = new JSONObject();
        result.put("msg","addnew training info successfully");
        return result;
    }

    @PostMapping(value="/deleteTraining")
    @AuthToken
    public JSONObject deleteTraining(Integer id){
        trainingtemplateService.deleteTraining(id);
        JSONObject result = new JSONObject();
        result.put("msg","delete training successfully");
        return result;
    }
}
