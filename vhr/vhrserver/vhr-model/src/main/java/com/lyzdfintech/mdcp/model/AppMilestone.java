package com.lyzdfintech.mdcp.model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by wangmeigong on 2020/5/11.
 */
public class AppMilestone {
    private int id;
    private String appKey;
    private Date productReleaseDate;
    private String name;
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
