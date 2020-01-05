package org.pushingbarriers.bgsystem.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="game")
public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gameId;

    @Column(nullable = false, name="gameTeamId")
    private Integer gameTeamId;

    @Column(length = 150, nullable = false, name = "gameTeam")
    private String gameTeam;

    @Column(length = 30, nullable = false, name = "gameRound")
    private String gameRound;

    @Column(nullable = false, name = "gameDate")
    private Date gameDate;

    @Column(length = 10, nullable = false, name = "gameTime")
    private String gameTime;

    @Column(length = 100, nullable = false, name = "gameVenue")
    private String gameVenue;

    @Column(length = 170, nullable = false, name = "gameAddress")
    private String gameAddress;

    @Column(length = 150, nullable = false, name = "gameOpposition")
    private String gameOpposition;

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getGameTeamId() {
        return gameTeamId;
    }

    public void setGameTeamId(Integer gameTeamId) {
        this.gameTeamId = gameTeamId;
    }

    public String getGameTeam() {
        return gameTeam;
    }

    public void setGameTeam(String gameTeam) {
        this.gameTeam = gameTeam;
    }

    public String getGameRound() {
        return gameRound;
    }

    public void setGameRound(String gameRound) {
        this.gameRound = gameRound;
    }

    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    public String getGameTime() {
        return gameTime;
    }

    public void setGameTime(String gameTime) {
        this.gameTime = gameTime;
    }

    public String getGameVenue() {
        return gameVenue;
    }

    public void setGameVenue(String gameVenue) {
        this.gameVenue = gameVenue;
    }

    public String getGameAddress() {
        return gameAddress;
    }

    public void setGameAddress(String gameAddress) {
        this.gameAddress = gameAddress;
    }

    public String getGameOpposition() {
        return gameOpposition;
    }

    public void setGameOpposition(String gameOpposition) {
        this.gameOpposition = gameOpposition;
    }
}
