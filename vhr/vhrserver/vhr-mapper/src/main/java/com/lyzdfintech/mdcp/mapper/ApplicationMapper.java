package com.lyzdfintech.mdcp.mapper;

import com.lyzdfintech.mdcp.model.AppDeveloper;
import com.lyzdfintech.mdcp.model.Application;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wangmeigong on 2020/5/12.
 */
public interface ApplicationMapper {

    List<Application> selectByAppKey(String appKey);

    int insert(Application application);
}