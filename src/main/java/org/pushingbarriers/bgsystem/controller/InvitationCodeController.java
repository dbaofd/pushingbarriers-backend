package org.pushingbarriers.bgsystem.controller;

import com.alibaba.fastjson.JSONObject;
import org.pushingbarriers.bgsystem.annotation.AuthToken;
import org.pushingbarriers.bgsystem.model.InvitationCode;
import org.pushingbarriers.bgsystem.service.InvitationCodeService;
import org.pushingbarriers.bgsystem.util.MyTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by baodong on 2020/2/15.
 */
@RestController
public class InvitationCodeController {
    @Autowired
    private InvitationCodeService invitationCodeService;

    @GetMapping(value = "/findAllInvitationCode")
    @AuthToken
    public List<InvitationCode> findAllInvitationCode(){
        return invitationCodeService.findAllInvitationCode();
    }

    @GetMapping(value = "/getInvitationCodeByName/{codeName}")
    @AuthToken
    public List<InvitationCode> getInvitationCodeByName(@PathVariable(value = "codeName") String codeName){
        return invitationCodeService.getInvitationCodeByCodeNameContaining(codeName);
    }

    @PostMapping(value="/generateInvitationCode")
    @AuthToken
    public JSONObject generateInvitationCode(String codeName){
        String codeString=MyTools.generateInvitationCode();
        invitationCodeService.insertInvitationCode(codeString,codeName);
        JSONObject result=new JSONObject();
        result.put("msg","Generate invitation code successfully");
        return result;
    }
}
