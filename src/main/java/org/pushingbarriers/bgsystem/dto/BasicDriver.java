package org.pushingbarriers.bgsystem.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by baodong on 2019/12/11.
 */
//Driver dto, no password included
public class BasicDriver implements Serializable {
    private Integer driverId;

    private String driverUserName;

    private String driverName;

    private String driverGender;

    private String driverPhoneNum;

    private String driverPlateNum;

    private Date driverBirthday;

    private String driverAddress;

    private Integer driverAvailability;

    public BasicDriver(Integer driverId,String driverUserName,String driverName,
                       String driverGender,String driverPhoneNum,String driverPlateNum,
                       Date driverBirthday,String driverAddress, Integer driverAvailability){
        this.driverId=driverId;
        this.driverUserName=driverUserName;
        this.driverName=driverName;
        this.driverGender=driverGender;
        this.driverPhoneNum=driverPhoneNum;
        this.driverPlateNum=driverPlateNum;
        this.driverBirthday=driverBirthday;
        this.driverAddress=driverAddress;
        this.driverAvailability=driverAvailability;

    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
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
}
