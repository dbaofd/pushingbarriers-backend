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

    @ManyToMany(mappedBy = "teamList")
    @JsonManagedReference
    private List<Player> playerList;

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


//select a.* from player a
    //left join player_team pt on pt.player_id=a.player_id where pt.team_id=2
}
