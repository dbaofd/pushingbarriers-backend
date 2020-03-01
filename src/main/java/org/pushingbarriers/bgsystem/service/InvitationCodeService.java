package org.pushingbarriers.bgsystem.service;

import org.pushingbarriers.bgsystem.model.InvitationCode;

import java.util.List;

/**
 * Created by baodong on 2020/2/15.
 */
public interface InvitationCodeService {
    void insertInvitationCode(String codeString, String codeName);

    boolean checkInvitationCodeExistence(String codeString);

    InvitationCode getInvitationCodeByCodeString(String codeString);

    List<InvitationCode> getInvitationCodesByCodeName(String codeName);

    void updateInvitationCodeStatus(String codeString);

    List<InvitationCode> findAllInvitationCode();

    List<InvitationCode> getInvitationCodeByCodeNameContaining(String codeName);
}
