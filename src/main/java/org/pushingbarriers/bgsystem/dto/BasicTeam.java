package org.pushingbarriers.bgsystem.dto;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * Created by baodong on 2020/1/5.
 */
public class BasicTeam implements Serializable {
    private Integer teamId;
    private String teamName;
    private String teamClub;
    private String teamAddress;
    private String teamCoachName;
    private String teamCoachPhoneNum;
    private String teamManagerName;
    private String teamManagerPhoneNum;
    private Integer teamStatus;

    public BasicTeam(Integer teamId, String teamName, String teamClub, String teamAddress, Integer teamStatus,
                     String teamCoachName, String teamCoachPhoneNum, String teamManagerName, String teamManagerPhoneNum){
        this.teamId=teamId;
        this.teamName=teamName;
        this.teamClub=teamClub;
        this.teamAddress=teamAddress;
        this.teamStatus=teamStatus;
        this.teamCoachName=teamCoachName;
        this.teamCoachPhoneNum=teamCoachPhoneNum;
        this.teamManagerName=teamManagerName;
        this.teamManagerPhoneNum=teamManagerPhoneNum;
    }
    public Integer getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamClub() {
        return teamClub;
    }

    public void setTeamClub(String teamClub) {
        this.teamClub = teamClub;
    }

    public String getTeamAddress() {
        return teamAddress;
    }

    public void setTeamAddress(String teamAddress) {
        this.teamAddress = teamAddress;
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
}
