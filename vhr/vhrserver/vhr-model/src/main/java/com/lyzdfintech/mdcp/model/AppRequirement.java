package com.lyzdfintech.mdcp.model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by wangmeigong on 2020/5/11.
 */
public class AppRequirement {
    private int id;
    private String appKey;
    private String name;
    private Date milestone;
    private String owner;
    private String client;
    private String resource;
    private String service;
    private Integer state;
    private String descriptor;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getMilestone() {
        return milestone;
    }

    public void setMilestone(Date milestone) {
        this.milestone = milestone;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
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
        return "AppRequirement{" +
                "id=" + id +
                ", appKey='" + appKey + '\'' +
                ", name='" + name + '\'' +
                ", milestone='" + milestone + '\'' +
                ", owner='" + owner + '\'' +
                ", client='" + client + '\'' +
                ", resource='" + resource + '\'' +
                ", service='" + service + '\'' +
                ", state=" + state +
                ", descriptor='" + descriptor + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
