package org.pushingbarriers.bgsystem.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by baodong on 2020/2/15.
 */
@Entity
@Table(name="invitationcode")
public class InvitationCode implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codeId;

    @Column(length = 20, nullable = false, name = "codestring")
    private String codeString;

    @Column(length = 100, nullable = false, name = "codeName")
    private String codeName;

    @Column(nullable = false, name = "codeStatus")
    private Integer codeStatus=1;

    public Integer getCodeId() {
        return codeId;
    }

    public String getCodeString() {
        return codeString;
    }

    public void setCodeString(String codeString) {
        this.codeString = codeString;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public Integer getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(Integer codeStatus) {
        this.codeStatus = codeStatus;
    }
}
