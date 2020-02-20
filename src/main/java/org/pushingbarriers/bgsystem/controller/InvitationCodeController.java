package org.pushingbarriers.bgsystem.controller;

import org.pushingbarriers.bgsystem.annotation.AuthToken;
import org.pushingbarriers.bgsystem.model.InvitationCode;
import org.pushingbarriers.bgsystem.service.InvitationCodeService;
import org.pushingbarriers.bgsystem.util.MyTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by baodong on 2020/2/15.
 */
@RestController
public class InvitationCodeController {
    @Autowired
    private InvitationCodeService invitationCodeService;

    @PostMapping(value="/generateInvitationCode")
    @AuthToken
    public void generateInvitationCode(String codeName){
        String codeString=MyTools.generateInvitationCode();
        invitationCodeService.insertInvitationCode(codeString,codeName);
    }
}
