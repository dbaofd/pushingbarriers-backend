package org.pushingbarriers.bgsystem.dto;

/**
 * Created by baodong on 2019/12/29.
 */
public class PlayerTeam {
    private Integer playerId;

    private String playerName;

    private Integer teamId;

    private String teamName;

    public PlayerTeam(Integer playerId, String playerName, Integer teamId, String teamName){
        this.playerId=playerId;
        this.playerName=playerName;
        this.teamId=teamId;
        this.teamName=teamName;

    }

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
