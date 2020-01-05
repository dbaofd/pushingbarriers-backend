package org.pushingbarriers.bgsystem.service;

import org.pushingbarriers.bgsystem.dto.PlayerTeam;
import org.pushingbarriers.bgsystem.model.Player;

import java.util.Date;
import java.util.List;

/**
 * Created by baodong on 2019/12/11.
 */
public interface PlayerService {
    public List<Player> findAllPlayers();

    public void updatePlayerInfo(String name, String gender, String phoneNum, Date birthday,
                                     String parentName, String parentPhoneNum, String address, Integer status, Integer id, Integer[] teamArray);

    public List<Player> findPlayersByPlayerName(String playerName);

    public void saveNewPlayer(String playerName, String playerGender, String playerPhoneNum, Date playerBirthDay,
                                String playerParentName, String playerParentPhoneNum, String playerAddress, Integer[] playerTeams);
}
