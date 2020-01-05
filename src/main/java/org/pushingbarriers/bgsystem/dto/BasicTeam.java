package org.pushingbarriers.bgsystem.dto;

import java.io.Serializable;

/**
 * Created by baodong on 2020/1/5.
 */
public class BasicTeam implements Serializable {
    private Integer teamId;
    private String teamName;

    public BasicTeam(Integer teamId, String teamName){
        this.teamId=teamId;
        this.teamName=teamName;
    }
    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
