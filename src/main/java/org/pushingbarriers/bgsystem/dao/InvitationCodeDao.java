package org.pushingbarriers.bgsystem.dao;

import org.pushingbarriers.bgsystem.model.InvitationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by baodong on 2020/2/15.
 */
@Repository
public interface InvitationCodeDao extends JpaRepository<InvitationCode, Integer> {
    InvitationCode findInvitationCodeByCodeString(String codeString);

    Boolean existsByCodeString(String codeString);

    List<InvitationCode> findInvitationCodesByCodeName(String codeName);

    List<InvitationCode> findInvitationCodesByCodeNameContaining(String codeName);
}
