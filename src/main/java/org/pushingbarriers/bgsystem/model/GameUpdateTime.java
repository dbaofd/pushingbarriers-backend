package org.pushingbarriers.bgsystem.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="gameupdatetime")
public class GameUpdateTime implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gameupdatetimeId;

    @Column(length = 150, nullable = false, name = "gameupdatetimeDate")
    private Date gameupdatetimeDate;

    public Integer getGameupdatetimeId() {
        return gameupdatetimeId;
    }

    public Date getGameupdatetimeDate() {
        return gameupdatetimeDate;
    }

    public void setGameupdatetimeDate(Date gameupdatetimeDate) {
        this.gameupdatetimeDate = gameupdatetimeDate;
    }
}
