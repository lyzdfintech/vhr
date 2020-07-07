package com.lyzdfintech.mdcp.model;

import java.sql.Timestamp;

/**
 * Created by wangmeigong on 2020/5/11.
 */
public class AppReleaseLog {
    private int id;
    private String appKey;
    private String envName;
    private int appModule;
    private String moduleId;
    private Timestamp releaseTime;
    private String version;
    private String developer;

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

    public Timestamp getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Timestamp releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    @Override
    public String toString() {
        return "AppReleaseLog{" +
                "id=" + id +
                ", appKey='" + appKey + '\'' +
                ", envName='" + envName + '\'' +
                ", appModule=" + appModule +
                ", moduleId='" + moduleId + '\'' +
                ", releaseTime=" + releaseTime +
                ", version='" + version + '\'' +
                ", developer='" + developer + '\'' +
                '}';
    }
}
