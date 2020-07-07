package com.lyzdfintech.mdcp.model;

import java.sql.Timestamp;

/**
 * Created by wangmeigong on 2020/5/11.
 */
public class AppEnvironment {
    private int id;
    private String appKey;
    private String envName;
    private String envDesc;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getEnvName() {
        return envName;
    }

    public void setEnvName(String envName) {
        this.envName = envName;
    }

    public String getEnvDesc() {
        return envDesc;
    }

    public void setEnvDesc(String envDesc) {
        this.envDesc = envDesc;
    }

    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "AppEnvironment{" +
                "id=" + id +
                ", appKey='" + appKey + '\'' +
                ", envName='" + envName + '\'' +
                ", envDesc='" + envDesc + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
