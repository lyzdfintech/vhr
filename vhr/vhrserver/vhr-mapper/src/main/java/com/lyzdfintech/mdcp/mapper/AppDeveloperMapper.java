package com.lyzdfintech.mdcp.mapper;

import com.lyzdfintech.mdcp.model.AppDeveloper;
import com.lyzdfintech.mdcp.model.AppEnvironment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wangmeigong on 2020/5/12.
 */
public interface AppDeveloperMapper {

    List<AppDeveloper> selectByAppKey(@Param("appKey") String appKey, @Param("page") Integer page, @Param("size") Integer size, @Param("name") String name);

    Long countByAppKey(@Param("appKey") String appKey, @Param("name") String name);

    int insert(AppDeveloper appDeveloper);

    int updateById(AppDeveloper appDeveloper);

    int deleteById(@Param("id") int id, @Param("appKey") String appKey);

}