package com.lyzdfintech.mdcp.mapper;

import com.lyzdfintech.mdcp.model.AppEnvironment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wangmeigong on 2020/5/12.
 */
public interface AppEnvironmentMapper {

    List<AppEnvironment> selectByAppKey(String appKey);

    int insert(AppEnvironment appEnvironment);

    int updateEnvDescById(@Param("envDesc") String envDesc, @Param("id") int id, @Param("appKey") String appKey);

    int deleteById(@Param("id") int id, @Param("appKey") String appKey);

}