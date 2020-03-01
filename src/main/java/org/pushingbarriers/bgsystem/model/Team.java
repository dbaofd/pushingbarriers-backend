package org.pushingbarriers.bgsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by baodong on 2019/12/27.
 */
@Entity
@Table(name="team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teamId;

    @Column(length = 100,nullable = false, name = "teamName")
    private String teamName;

    @Column(length = 100,nullable = false, name = "clubName")
    private String clubName;

    @Column(length = 170,nullable = false, name = "clubAddress")
    private String clubAddress;

    @Column(length = 100, name = "teamCoachName")
    private String teamCoachName;

    @Column(length = 15, name = "teamCoachPhoneNum")
    private String teamCoachPhoneNum;

    @Column(length = 100, name = "teamManagerName")
    private String teamManagerName;

    @Column(length = 15, name = "teamManagerPhoneNum")
    private String teamManagerPhoneNum;

    @Column(nullable = false, name = "teamStatus")
    private Integer teamStatus=1;

    @ManyToMany(mappedBy = "teamList",fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Player> playerList;

    public Integer getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubAddress() {
        return clubAddress;
    }

    public void setClubAddress(String clubAddress) {
        this.clubAddress = clubAddress;
    }

    public Integer getTeamStatus() {
        return teamStatus;
    }

    public void setTeamStatus(Integer teamStatus) {
        this.teamStatus = teamStatus;
    }

    public String getTeamCoachName() {
        return teamCoachName;
    }

    public void setTeamCoachName(String teamCoachName) {
        this.teamCoachName = teamCoachName;
    }

    public String getTeamCoachPhoneNum() {
        return teamCoachPhoneNum;
    }

    public void setTeamCoachPhoneNum(String teamCoachPhoneNum) {
        this.teamCoachPhoneNum = teamCoachPhoneNum;
    }

    public String getTeamManagerName() {
        return teamManagerName;
    }

    public void setTeamManagerName(String teamManagerName) {
        this.teamManagerName = teamManagerName;
    }

    public String getTeamManagerPhoneNum() {
        return teamManagerPhoneNum;
    }

    public void setTeamManagerPhoneNum(String teamManagerPhoneNum) {
        this.teamManagerPhoneNum = teamManagerPhoneNum;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    //select a.* from player a
    //left join player_team pt on pt.player_id=a.player_id where pt.team_id=2
}
