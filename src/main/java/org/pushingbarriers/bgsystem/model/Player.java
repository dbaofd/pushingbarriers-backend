package org.pushingbarriers.bgsystem.model;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer playerId;

    @Column(length = 100, nullable = false, name = "playerName")
    private String playerName;

    @Column(length = 15, nullable = false, name = "playerGender")
    private String playerGender;

    @Column(length = 15, nullable = false, name = "playerPhoneNum")
    private String playerPhoneNum;

    @Column(nullable = false, name = "playerBirthday")
    private Date playerBirthday;

    @Column(length = 170, nullable = false, name = "playerAddress")
    private String playerAddress;

    @Column(length = 100, nullable = false, name = "playerParentName")
    private String playerParentName;

    @Column(length = 15, nullable = false, name = "playerParentPhoneNum")
    private String playerParentPhoneNum;

    @Column(nullable = false, name = "playerStatus")
    private Integer playerStatus=1;

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerGender() {
        return playerGender;
    }

    public void setPlayerGender(String playerGender) {
        this.playerGender = playerGender;
    }

    public String getPlayerPhoneNum() {
        return playerPhoneNum;
    }

    public void setPlayerPhoneNum(String playerPhoneNum) {
        this.playerPhoneNum = playerPhoneNum;
    }

    public Date getPlayerBirthday() {
        return playerBirthday;
    }

    public void setPlayerBirthday(Date playerBirthday) {
        this.playerBirthday = playerBirthday;
    }

    public String getPlayerAddress() {
        return playerAddress;
    }

    public void setPlayerAddress(String playerAddress) {
        this.playerAddress = playerAddress;
    }

    public String getPlayerParentName() {
        return playerParentName;
    }

    public void setPlayerParentName(String playerParentName) {
        this.playerParentName = playerParentName;
    }

    public String getPlayerParentPhoneNum() {
        return playerParentPhoneNum;
    }

    public void setPlayerParentPhoneNum(String playerParentPhoneNum) {
        this.playerParentPhoneNum = playerParentPhoneNum;
    }

    public Integer getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(Integer playerStatus) {
        this.playerStatus = playerStatus;
    }
}
