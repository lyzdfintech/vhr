package com.lyzdfintech.mdcp.service;

import com.lyzdfintech.mdcp.mapper.AppMilestoneMapper;
import com.lyzdfintech.mdcp.model.AppMilestone;
import org.javaboy.vhr.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangmeigong on 2020/5/12.
 */
@Service
public class AppMilestoneService {
    @Autowired
    AppMilestoneMapper appMilestoneMapper;

    public RespPageBean getMilestone(String appKey) {
        List<AppMilestone> data = appMilestoneMapper.selectByAppKey(appKey);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal((long)data.size());
        return bean;
    }

    public int addMilestone(AppMilestone appMilestone) {
        return appMilestoneMapper.insert(appMilestone);
    }

    public int deleteMilestoneById(int id, String appKey) {
        return appMilestoneMapper.deleteById(id, appKey);
    }

    public int updateMilestone(AppMilestone appMilestone) {
        return appMilestoneMapper.updateById(appMilestone);
    }
}
