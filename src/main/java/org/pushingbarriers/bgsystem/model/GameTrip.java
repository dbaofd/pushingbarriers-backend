package org.pushingbarriers.bgsystem.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by baodong on 2020/1/21.
 */
@Entity
@Table(name = "gametrip")
public class GameTrip implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tripId;

    @Column(name = "tripDate")
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

    @Column(name = "tripDriverId")
    private Integer tripDriverId;

    @Column(length = 50, name = "tripDriver")
    private String tripDriver;

    @Column(length = 15, name = "tripDriverGender")
    private String tripDriverGender;

    @Column(length = 150, nullable = false, name = "tripTeam")
    private String tripTeam;

    @Column(length = 170, nullable = false, name = "tripPlayerAddress")
    private String tripPlayerAddress;

    @Column(length = 170, nullable = false, name = "tripAddress")
    private String tripAddress;

    @Column(nullable = false, name = "tripStatus")
    private Integer tripStatus=0;

    @Column(length = 500, name = "tripNote")
    private String tripNote;

    public Integer getTripId() {
        return tripId;
    }

    public Date getTripDate() {
        return tripDate;
    }

    public void setTripDate(Date tripDate) {
        this.tripDate = tripDate;
    }

    public String getTripDay() {
        return tripDay;
    }

    public void setTripDay(String tripDay) {
        this.tripDay = tripDay;
    }

    public String getTripTime() {
        return tripTime;
    }

    public void setTripTime(String tripTime) {
        this.tripTime = tripTime;
    }

    public Integer getTripPlayerId() {
        return tripPlayerId;
    }

    public void setTripPlayerId(Integer tripPlayerId) {
        this.tripPlayerId = tripPlayerId;
    }

    public String getTripPlayer() {
        return tripPlayer;
    }

    public void setTripPlayer(String tripPlayer) {
        this.tripPlayer = tripPlayer;
    }

    public String getTripPlayerGender() {
        return tripPlayerGender;
    }

    public void setTripPlayerGender(String tripPlayerGender) {
        this.tripPlayerGender = tripPlayerGender;
    }

    public Integer getTripDriverId() {
        return tripDriverId;
    }

    public void setTripDriverId(Integer tripDriverId) {
        this.tripDriverId = tripDriverId;
    }

    public String getTripDriver() {
        return tripDriver;
    }

    public void setTripDriver(String tripDriver) {
        this.tripDriver = tripDriver;
    }

    public String getTripDriverGender() {
        return tripDriverGender;
    }

    public void setTripDriverGender(String tripDriverGender) {
        this.tripDriverGender = tripDriverGender;
    }

    public String getTripTeam() {
        return tripTeam;
    }

    public void setTripTeam(String tripClub) {
        this.tripTeam = tripClub;
    }

    public String getTripPlayerAddress() {
        return tripPlayerAddress;
    }

    public void setTripPlayerAddress(String tripPlayerAddress) {
        this.tripPlayerAddress = tripPlayerAddress;
    }

    public String getTripAddress() {
        return tripAddress;
    }

    public void setTripAddress(String tripAddress) {
        this.tripAddress = tripAddress;
    }

    public Integer getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(Integer tripStatus) {
        this.tripStatus = tripStatus;
    }

    public String getTripNote() {
        return tripNote;
    }

    public void setTripNote(String tripNote) {
        this.tripNote = tripNote;
    }
}
