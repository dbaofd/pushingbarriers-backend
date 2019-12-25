package org.pushingbarriers.bgsystem.controller;

import com.alibaba.fastjson.JSONObject;
import org.pushingbarriers.bgsystem.annotation.AuthToken;
import org.pushingbarriers.bgsystem.model.Training;
import org.pushingbarriers.bgsystem.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainingController {
    @Autowired
    private TrainingService trainingService;

    @GetMapping(value="/alltrainings")
    @AuthToken
    public List<Training> findAllTrainings(){
        return trainingService.findAllTrainings();
    }

    @PostMapping(value="/updateConfirmation")
    @AuthToken
    public JSONObject updateConfirmation(Integer id, String status){
        JSONObject result = new JSONObject();
        trainingService.updateConfirmationStatus(id, status);
        result.put("msg","update status successfully");
        return result;
    }

    @PostMapping(value="/updateTrainingDetail")
    @AuthToken
    public JSONObject updateTrainingDetail(String driver, String time, String status, String note, Integer id){
        JSONObject result = new JSONObject();
        trainingService.updateTrainingDetail(driver,time, status, note, id);
        result.put("msg","update training detail successfully");
        return result;
    }
}
