package org.pushingbarriers.bgsystem.dao;

import org.pushingbarriers.bgsystem.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by baodong on 2019/12/11.
 */

@Repository
public interface PlayerDao extends JpaRepository<Player,Integer> {
    public List<Player> findPlayersByPlayerName(String playerName);

//    @Query("update Player set playerName=?1,playerGender=?2,playerPhoneNum=?3, playerBirthday=?4," +
//            "playerParentName=?5, playerParentPhoneNum=?6, playerAddress=?7 ,playerStatus=?8 where playerId=?9")
//    @Modifying
//    @Transactional
//    public void updatePlayerInfo(String name, String gender, String phoneNum, Date birthday,
//                                     String parentName, String parentPhoneNum, String address, Integer status, Integer id);

//    @Query(value = "insert into player(player_name,player_gender,player_phone_num,player_birthday,player_parent_name," +
//            "player_parent_phone_num,player_address) values(?1,?2,?3,?4,?5,?6,?7)", nativeQuery=true)
//    @Modifying
//    @Transactional
//    public void insertNewPlayer(String playerName, String playerGender, String playerPhoneNum, Date playerBirthDay,
//                                String playerParentName, String playerParentPhoneNum, String playerAddress);
//
//
//    @Query(value="select p.player_id,p.player_name,t.team_id, t.team_name from player p \n" +
//            "left join player_team pt on p.player_id=pt.player_id\n" +
//            "left join team t on t.team_id=pt.team_id", nativeQuery = true)
//    public List<Object> getAllPlayerTeamMapping();
}
