package com.lyzdfintech.mdcp.model;

import java.sql.Timestamp;

/**
 * Created by wangmeigong on 2020/5/11.
 */
public class AppReleaseHook {
    private int id;
    private String appKey;
    private String envName;
    private int appModule;
    private String moduleId;
    private String releaseHook;
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

    public int getAppModule() {
        return appModule;
    }

    public void setAppModule(int appModule) {
        this.appModule = appModule;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getReleaseHook() {
        return releaseHook;
    }

    public void setReleaseHook(String releaseHook) {
        this.releaseHook = releaseHook;
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
        return "AppReleaseHook{" +
                "id=" + id +
                ", appKey='" + appKey + '\'' +
                ", envName='" + envName + '\'' +
                ", appModule=" + appModule +
                ", moduleId='" + moduleId + '\'' +
                ", releaseHook='" + releaseHook + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
