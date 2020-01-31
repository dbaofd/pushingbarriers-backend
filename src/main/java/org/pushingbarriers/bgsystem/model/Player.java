package org.pushingbarriers.bgsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="player")
public class Player implements Serializable {
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
    private Integer playerStatus;

    @Column(length = 200, nullable = false, name = "playerPhoto")
    @JsonIgnore
    private String playerPhoto;
    //The Exception:Failed to write HTTP message: org.springframework.http.converter.HttpMessageNotWritableException:
    //The fix is to get Jackson to be able to handle bi-directional references.
    //And this is done by using two Annotations: @JsonManagedReference and @JsonBackReference.
    //@JsonManagedReference is used to annotate the inverse side while @JsonBackReference maps the owning side of the relationship.
    @ManyToMany
    @JoinTable(name = "player_team",joinColumns = @JoinColumn(name = "playerId"),
            inverseJoinColumns = @JoinColumn(name = "teamId"))
    @JsonBackReference
    private List<Team> teamList;

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

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    public String getPlayerPhoto() {
        return playerPhoto;
    }

    public void setPlayerPhoto(String playerPhoto) {
        this.playerPhoto = playerPhoto;
    }
}
