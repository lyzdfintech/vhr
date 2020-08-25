package com.lyzdfintech.mdcp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.JSONArray;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by wangmeigong on 2020/5/11.
 */
public class AppRequirement {
    private int id;
    private String appKey;
    private String name;
    private Integer milestone;
    private Integer owner;
    private JSONArray client;
    private JSONArray resource;
    private JSONArray service;
    private Integer state;
    private String descriptor;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMilestone() {
        return milestone;
    }

    public void setMilestone(Integer milestone) {
        this.milestone = milestone;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public JSONArray getClient() {
        return client;
    }

    public void setClient(JSONArray client) {
        this.client = client;
    }

    public JSONArray getResource() {
        return resource;
    }

    public void setResource(JSONArray resource) {
        this.resource = resource;
    }

    public JSONArray getService() {
        return service;
    }

    public void setService(JSONArray service) {
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
                ", milestone=" + milestone +
                ", owner=" + owner +
                ", client='" + client + '\'' +
                ", resource=" + resource +
                ", service=" + service +
                ", state=" + state +
                ", descriptor='" + descriptor + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
