package org.pushingbarriers.bgsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="driver")
public class Driver implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer driverId;

    @Column(length = 100, nullable = false, name = "driverUserName")
    private String driverUserName;

    @Column(length = 100, nullable = false, name = "driverName")
    private String driverName;

    @Column(length = 15, nullable = false, name = "driverGender")
    private String driverGender;

    @Column(length = 100, nullable = false, name = "driverPassword")
    @JsonIgnore
    //When check driver info, no need to return password, json will ignore it.
    private String driverPassword;

    @Column(length = 15, nullable = false, name = "driverPhoneNum")
    private String driverPhoneNum;

    @Column(length = 20, nullable = false, name = "driverPlateNum")
    private String driverPlateNum;

    @Column(nullable = false, name = "driverBirthday")
    private Date driverBirthday;

    @Column(length = 170, nullable = false, name = "driverAddress")
    private String driverAddress;

    /**
     * 0 stands for Temporarily Unavailable
     * 1 stands for Available
     * 2 stands for Permanently Unavailable
     */
    @Column(nullable = false, name = "driverAvailability")
    private Integer driverAvailability=1;

    @Column(length = 200, name = "driverLicense")
    @JsonIgnore
    private String driverLicense;

    @Column(length = 200, name = "driverBlueCard")
    @JsonIgnore
    private String driverBlueCard;

    public Integer getDriverId() {
        return driverId;
    }

    public String getDriverUserName() {
        return driverUserName;
    }

    public void setDriverUserName(String driverUserName) {
        this.driverUserName = driverUserName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverGender() {
        return driverGender;
    }

    public void setDriverGender(String driverGender) {
        this.driverGender = driverGender;
    }

    public String getDriverPassword() {
        return driverPassword;
    }

    public void setDriverPassword(String driverPassword) {
        this.driverPassword = driverPassword;
    }

    public String getDriverPhoneNum() {
        return driverPhoneNum;
    }

    public void setDriverPhoneNum(String driverPhoneNum) {
        this.driverPhoneNum = driverPhoneNum;
    }

    public String getDriverPlateNum() {
        return driverPlateNum;
    }

    public void setDriverPlateNum(String driverPlateNum) {
        this.driverPlateNum = driverPlateNum;
    }

    public Date getDriverBirthday() {
        return driverBirthday;
    }

    public void setDriverBirthday(Date driverBirthday) {
        this.driverBirthday = driverBirthday;
    }

    public String getDriverAddress() {
        return driverAddress;
    }

    public void setDriverAddress(String driverAddress) {
        this.driverAddress = driverAddress;
    }

    public Integer getDriverAvailability() {
        return driverAvailability;
    }

    public void setDriverAvailability(Integer driverAvailability) {
        this.driverAvailability = driverAvailability;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public String getDriverBlueCard() {
        return driverBlueCard;
    }

    public void setDriverBlueCard(String driverBlueCard) {
        this.driverBlueCard = driverBlueCard;
    }
}
