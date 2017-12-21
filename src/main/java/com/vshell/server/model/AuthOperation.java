package com.vshell.server.model;

import java.util.Date;

public class AuthOperation {
    private Integer id;

    private String opCode;

    private String opName;

    private String opHref;

    private Integer opSeq;

    private Date addTime;

    private Date updateTime;

    private Integer deleteSign;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode == null ? null : opCode.trim();
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName == null ? null : opName.trim();
    }

    public String getOpHref() {
        return opHref;
    }

    public void setOpHref(String opHref) {
        this.opHref = opHref == null ? null : opHref.trim();
    }

    public Integer getOpSeq() {
        return opSeq;
    }

    public void setOpSeq(Integer opSeq) {
        this.opSeq = opSeq;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteSign() {
        return deleteSign;
    }

    public void setDeleteSign(Integer deleteSign) {
        this.deleteSign = deleteSign;
    }
}