package com.lyzdfintech.mdcp.mapper;

import com.lyzdfintech.mdcp.model.AppEnvironment;
import com.lyzdfintech.mdcp.model.AppResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wangmeigong on 2020/5/12.
 */
public interface AppResourceMapper {

    List<AppResource> selectByAppKey(String appKey);

    int insert(AppResource appResource);

    int updateById(AppResource appResource);

    int deleteById(@Param("id") int id, @Param("appKey") String appKey);

}