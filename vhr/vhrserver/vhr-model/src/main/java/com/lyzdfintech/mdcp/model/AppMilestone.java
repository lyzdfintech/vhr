package com.lyzdfintech.mdcp.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by wangmeigong on 2020/5/11.
 */
public class AppMilestone {
    private int id;
    private String appKey;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date productReleaseDate;
    private String name;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp gmtCreate;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
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

    public Date getProductReleaseDate() {
        return productReleaseDate;
    }

    public void setProductReleaseDate(Date productReleaseDate) {
        this.productReleaseDate = productReleaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "AppMilestone{" +
                "id=" + id +
                ", appKey='" + appKey + '\'' +
                ", productReleaseDate='" + productReleaseDate + '\'' +
                ", name='" + name + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
