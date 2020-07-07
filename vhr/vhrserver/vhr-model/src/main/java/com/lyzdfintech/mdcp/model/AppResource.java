package com.lyzdfintech.mdcp.model;

import java.sql.Timestamp;

/**
 * Created by wangmeigong on 2020/5/11.
 */
public class AppResource {
    private int id;
    private String appKey;
    private String resourceId;
    private String resourceDesc;
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

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
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
        return "AppResource{" +
                "id=" + id +
                ", appKey='" + appKey + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", resourceDesc='" + resourceDesc + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
