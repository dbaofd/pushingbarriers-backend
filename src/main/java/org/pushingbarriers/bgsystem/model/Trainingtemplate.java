package org.pushingbarriers.bgsystem.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by baodong on 2019/12/2.
 */
@Entity
@Table(name="trainingtemplate")
public class Trainingtemplate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trainingId;

    @Column(nullable = true, name = "trainingDate")
    private Date trainingDate;

    @Column(length = 10,nullable = false, name = "trainingDay")
    private String trainingDay;

    @Column(length = 30, nullable = false, name = "trainingTime")
    private String trainingTime;

    @Column(nullable = false, name = "trainingPlayerId")
    private Integer trainingPlayerId;

    @Column(length = 50, nullable = false, name = "trainingPlayer")
    private String trainingPlayer;

    @Column(length = 15, nullable = false, name = "trainingPlayerGender")
    private String trainingPlayerGender;

    @Column(nullable = false, name = "trainingDriverId")
    private Integer trainingDriverId;

    @Column(length = 50, nullable = false, name = "trainingDriver")
    private String trainingDriver;

    @Column(length = 15, nullable = false, name = "trainingDriverGender")
    private String trainingDriverGender;

    @Column(length = 150, nullable = false, name = "trainingClub")
    private String trainingClub;

    @Column(length = 170, nullable = false, name = "trainingPlayerAddress")
    private String trainingPlayerAddress;

    @Column(length = 170, nullable = false, name = "trainingAddress")
    private String trainingAddress;

    /**
     * 0 stands for unconfirmed
     * 1 stands for confirmed
     * 2 stands for refused
     * 3 stands for cancelled
      */
    @Column(name = "trainingStatus")
    private Integer trainingStatus;

    @Column(length = 500, name = "trainingNote")
    private String trainingNote;

    /**
     * 1 stands for return
     * 2 stands for player address to training address
     * 3 stands for training address to player address
     */
    @Column(name = "trainingType")
    private Integer trainingType;

    public Trainingtemplate(){

    }

    public Trainingtemplate(String day, String time, Integer playerId, String playerName,
                            String playerGender, Integer driverId, String driverName,
                            String driverGender, String club, String playerAddress,
                            String trainingAddress){
        this.trainingDay=day;
        this.trainingTime=time;
        this.trainingPlayerId=playerId;
        this.trainingPlayer=playerName;
        this.trainingPlayerGender=playerGender;
        this.trainingDriverId=driverId;
        this.trainingDriver=driverName;
        this.trainingDriverGender=driverGender;
        this.trainingClub=club;
        this.trainingPlayerAddress=playerAddress;
        this.trainingAddress=trainingAddress;

    }
    public Integer getTrainingId() {
        return trainingId;
    }

    public Date getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(Date trainingDate) {
        this.trainingDate = trainingDate;
    }

    public String getTrainingDay() {
        return trainingDay;
    }

    public void setTrainingDay(String trainingDay) {
        this.trainingDay = trainingDay;
    }

    public String getTrainingTime() {
        return trainingTime;
    }

    public void setTrainingTime(String trainingTime) {
        this.trainingTime = trainingTime;
    }

    public Integer getTrainingPlayerId() {
        return trainingPlayerId;
    }

    public void setTrainingPlayerId(Integer trainingPlayerId) {
        this.trainingPlayerId = trainingPlayerId;
    }

    public String getTrainingPlayer() {
        return trainingPlayer;
    }

    public void setTrainingPlayer(String trainingPlayer) {
        this.trainingPlayer = trainingPlayer;
    }

    public Integer getTrainingDriverId() {
        return trainingDriverId;
    }

    public void setTrainingDriverId(Integer trainingDriverId) {
        this.trainingDriverId = trainingDriverId;
    }

    public String getTrainingDriver() {
        return trainingDriver;
    }

    public void setTrainingDriver(String trainingDriver) {
        this.trainingDriver = trainingDriver;
    }

    public String getTrainingClub() {
        return trainingClub;
    }

    public void setTrainingClub(String trainingClub) {
        this.trainingClub = trainingClub;
    }

    public String getTrainingPlayerAddress() {
        return trainingPlayerAddress;
    }

    public void setTrainingPlayerAddress(String trainingPlayerAddress) {
        this.trainingPlayerAddress = trainingPlayerAddress;
    }

    public String getTrainingAddress() {
        return trainingAddress;
    }

    public void setTrainingAddress(String trainingAddress) {
        this.trainingAddress = trainingAddress;
    }

    public Integer getTrainingStatus() {
        return trainingStatus;
    }

    public void setTrainingStatus(Integer trainingConfirmation) {
        this.trainingStatus = trainingConfirmation;
    }

    public String getTrainingNote() {
        return trainingNote;
    }

    public void setTrainingNote(String trainingNote) {
        this.trainingNote = trainingNote;
    }

    public String getTrainingPlayerGender() {
        return trainingPlayerGender;
    }

    public void setTrainingPlayerGender(String trainingPlayerGender) {
        this.trainingPlayerGender = trainingPlayerGender;
    }

    public String getTrainingDriverGender() {
        return trainingDriverGender;
    }

    public void setTrainingDriverGender(String trainingDriverGender) {
        this.trainingDriverGender = trainingDriverGender;
    }

    public Integer getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(Integer trainingType) {
        this.trainingType = trainingType;
    }
}
