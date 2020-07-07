package com.lyzdfintech.mdcp.model;

import java.sql.Timestamp;

/**
 * Created by wangmeigong on 2020/5/11.
 */
public class Application {
    private int id;
    private String appKey;
    private String appName;
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

    public String getAppName() {
        return appName;
    }

    public void setAppName(String app_name) {
        this.appName = app_name;
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
        return "Application{" +
                "id=" + id +
                ", appKey='" + appKey + '\'' +
                ", appName='" + appName + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
