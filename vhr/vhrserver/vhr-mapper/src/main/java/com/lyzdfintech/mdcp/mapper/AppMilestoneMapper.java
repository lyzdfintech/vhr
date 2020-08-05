package com.lyzdfintech.mdcp.mapper;

import com.lyzdfintech.mdcp.model.AppMilestone;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wangmeigong on 2020/5/12.
 */
public interface AppMilestoneMapper {

    List<AppMilestone> selectByAppKey(String appKey);

    int insert(AppMilestone appMilestone);

    int updateById(AppMilestone appMilestone);

    int deleteById(@Param("id") int id, @Param("appKey") String appKey);

}