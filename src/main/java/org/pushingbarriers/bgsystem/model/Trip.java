package org.pushingbarriers.bgsystem.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by baodong on 2020/1/21.
 */
@Entity
@Table(name="trip")
public class Trip implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tripId;

    @Column(nullable = true, name = "tripDate")
    private Date tripDate;

    @Column(length = 10,nullable = false, name = "tripDay")
    private String tripDay;

    @Column(length = 30, nullable = false, name = "tripTime")
    private String tripTime;

    @Column(nullable = false, name = "tripPlayerId")
    private Integer tripPlayerId;

    @Column(length = 50, nullable = false, name = "tripPlayer")
    private String tripPlayer;

    @Column(length = 15, nullable = false, name = "tripPlayerGender")
    private String tripPlayerGender;

    @Column(nullable = false, name = "tripDriverId")
    private Integer tripDriverId;

    @Column(length = 50, nullable = false, name = "tripDriver")
    private String tripDriver;

    @Column(length = 15, nullable = false, name = "tripDriverGender")
    private String tripDriverGender;

    @Column(length = 150, nullable = false, name = "tripClub")
    private String tripClub;

    @Column(length = 170, nullable = false, name = "tripPlayerAddress")
    private String tripPlayerAddress;

    @Column(length = 170, nullable = false, name = "tripAddress")
    private String tripAddress;

    @Column(nullable = false, name = "tripStatus")
    private Integer tripStatus=0;

    @Column(length = 500, name = "tripNote")
    private String tripNote;
}
