package com.lyzdfintech.mdcp.mapper;

import com.lyzdfintech.mdcp.model.AppResource;
import com.lyzdfintech.mdcp.model.AppService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wangmeigong on 2020/5/12.
 */
public interface AppServiceMapper {

    List<AppService> selectByAppKey(String appKey);

    int insert(AppService appService);

    int updateById(AppService appService);

    int deleteById(@Param("id") int id, @Param("appKey") String appKey);

}