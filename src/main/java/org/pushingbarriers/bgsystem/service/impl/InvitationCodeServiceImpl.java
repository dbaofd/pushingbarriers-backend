package org.pushingbarriers.bgsystem.service.impl;

import org.pushingbarriers.bgsystem.dao.InvitationCodeDao;
import org.pushingbarriers.bgsystem.model.InvitationCode;
import org.pushingbarriers.bgsystem.service.InvitationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by baodong on 2020/2/15.
 */
@Service
public class InvitationCodeServiceImpl implements InvitationCodeService {
    @Autowired
    private InvitationCodeDao invitationCodeDao;

    public void insertInvitationCode(String codeString, String codeName){
        InvitationCode invitationCode=new InvitationCode();
        invitationCode.setCodeString(codeString);
        invitationCode.setCodeName(codeName);
        invitationCodeDao.save(invitationCode);
    }

    public boolean checkInvitationCodeExistence(String codeString){
        return invitationCodeDao.existsByCodeString(codeString);
    }

    public InvitationCode getInvitationCodeByCodeString(String codeString){
        return invitationCodeDao.findInvitationCodeByCodeString(codeString);
    }

    public List<InvitationCode> getInvitationCodesByCodeName(String codeName){
        return invitationCodeDao.findInvitationCodesByCodeName(codeName);
    }

    public void updateInvitationCodeStatus(String codeString){
        InvitationCode invitationCode=invitationCodeDao.findInvitationCodeByCodeString(codeString);
        invitationCode.setCodeStatus(0);
        invitationCodeDao.save(invitationCode);
    }
}
