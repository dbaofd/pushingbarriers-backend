package org.pushingbarriers.bgsystem.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="training")
public class Training implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trainingId;

    @Column(name = "trainingDate")
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

    @Column(nullable = false, name = "trainingStatus")
    private Integer trainingStatus=0;

    @Column(length = 500, name = "trainingNote")
    private String trainingNote;

    public Training(){}
    public Training(Date trainingDate,String trainingDay,
                    String trainingTime,Integer trainingPlayerId,String trainingPlayer,
                    String trainingPlayerGender,Integer trainingDriverId,String trainingDriver,
                    String trainingDriverGender,String trainingClub,String trainingPlayerAddress,
                    String trainingAddress, Integer trainingStatus,String trainingNote){
        this.trainingDate=trainingDate;
        this.trainingDay=trainingDay;
        this.trainingTime=trainingTime;
        this.trainingPlayerId=trainingPlayerId;
        this.trainingPlayer=trainingPlayer;
        this.trainingPlayerGender=trainingPlayerGender;
        this.trainingDriverId=trainingDriverId;
        this.trainingDriver=trainingDriver;
        this.trainingDriverGender=trainingDriverGender;
        this.trainingClub=trainingClub;
        this.trainingPlayerAddress=trainingPlayerAddress;
        this.trainingAddress=trainingAddress;
        this.trainingStatus=trainingStatus;
        this.trainingNote=trainingNote;
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
}
