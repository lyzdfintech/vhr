package com.lyzdfintech.mdcp.mapper;

import com.lyzdfintech.mdcp.model.AppRequirement;
import com.lyzdfintech.mdcp.model.AppService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wangmeigong on 2020/5/12.
 */
public interface AppRequirementMapper {

    List<AppRequirement> selectByAppKey(String appKey);

    int insert(AppRequirement appRequirement);

    int updateById(AppRequirement appRequirement);

    int deleteById(@Param("id") int id, @Param("appKey") String appKey);

}