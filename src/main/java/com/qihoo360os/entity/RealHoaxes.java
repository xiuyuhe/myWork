package com.qihoo360os.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by i-hexiuyu on 2017/6/27.
 */
@Entity
@Table(name = "tp_real_hoaxes")
public class RealHoaxes {
    private int realPid;
    private String realChannel;
    private String realM1;
    private String realM2;
    private String realEmmc;
    private String realCpu;
    private String realOsversion;
    private Date realServerTime;
    private String realEventKey;
    private String realPkgname;
    private String realCreateTime;
    private Date thedate;
    private String realInstaller;

    @Id
    public int getRealPid() {
        return realPid;
    }

    public void setRealPid(int realPid) {
        this.realPid = realPid;
    }

    public String getRealChannel() {
        return realChannel;
    }

    public void setRealChannel(String realChannel) {
        this.realChannel = realChannel;
    }

    @Column(name = "real_m1")
    public String getRealM1() {
        return realM1;
    }

    public void setRealM1(String realM1) {
        this.realM1 = realM1;
    }

    @Column(name = "real_m2")
    public String getRealM2() {
        return realM2;
    }

    public void setRealM2(String realM2) {
        this.realM2 = realM2;
    }

    public String getRealEmmc() {
        return realEmmc;
    }

    public void setRealEmmc(String realEmmc) {
        this.realEmmc = realEmmc;
    }

    public String getRealCpu() {
        return realCpu;
    }

    public void setRealCpu(String realCpu) {
        this.realCpu = realCpu;
    }

    public String getRealOsversion() {
        return realOsversion;
    }

    public void setRealOsversion(String realOsversion) {
        this.realOsversion = realOsversion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getRealServerTime() {
        return realServerTime;
    }

    public void setRealServerTime(Date realServerTime) {
        this.realServerTime = realServerTime;
    }

    public String getRealEventKey() {
        return realEventKey;
    }

    public void setRealEventKey(String realEventKey) {
        this.realEventKey = realEventKey;
    }

    public String getRealPkgname() {
        return realPkgname;
    }

    public void setRealPkgname(String realPkgname) {
        this.realPkgname = realPkgname;
    }

    public String getRealCreateTime() {
        return realCreateTime;
    }

    public void setRealCreateTime(String realCreateTime) {
        this.realCreateTime = realCreateTime;
    }

    public Date getThedate() {
        return thedate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public void setThedate(Date thedate) {
        this.thedate = thedate;
    }

    public String getRealInstaller() {
        return realInstaller;
    }

    public void setRealInstaller(String realInstaller) {
        this.realInstaller = realInstaller;
    }
}
