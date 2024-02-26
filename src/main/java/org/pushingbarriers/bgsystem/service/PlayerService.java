package org.pushingbarriers.bgsystem.service;

import org.pushingbarriers.bgsystem.dto.PlayerTeam;
import org.pushingbarriers.bgsystem.model.Player;

import java.util.Date;
import java.util.List;

/**
 * Created by baodong on 2019/12/11.
 */
public interface PlayerService {
    List<Player> findAllPlayers();

    void updatePlayerInfo(String name, String gender, String phoneNum, Date birthday,
                          String parentName, String parentPhoneNum, String address,
                          String referralPerspon, Integer status, Integer id,
                          Integer[] teamArray, String photo, String school, String consent,
                          String coachManager, String visa, String note, String sport );

    List<Player> findPlayersByPlayerName(String playerName);

    List<Player> findPlayersByPlayerNameAndPlayerStatus(String playerName, Integer playerStatus);

    List<Player> findPlayersByPlayerStatus(Integer status);

    void saveNewPlayer(String playerName, String playerGender, String playerPhoneNum, Date playerBirthDay,
                       String playerParentName, String playerParentPhoneNum, String playerAddress,
                       Integer playerStatus, Integer[] playerTeams, String playerPhoto,
                       String playerReferralPerspon, String playerSchool, String playerConsent,
                       String playerCoachManager, String playerVisa, String playerNote, String sport);

    Player findPlayerByPlayerId(Integer playerId);
}
