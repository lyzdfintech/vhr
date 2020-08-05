package com.lyzdfintech.mdcp.service;

import com.lyzdfintech.mdcp.mapper.AppEnvironmentMapper;
import com.lyzdfintech.mdcp.model.AppEnvironment;
import org.javaboy.vhr.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangmeigong on 2020/5/12.
 */
@Service
public class AppEnvironmentService {
    @Autowired
    AppEnvironmentMapper appEnvironmentMapper;

    public RespPageBean getEnvironment(String appKey) {
        List<AppEnvironment> data = appEnvironmentMapper.selectByAppKey(appKey);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal((long)data.size());
        return bean;
    }

    public int addEnvironment(AppEnvironment appEnvironment) {
        return appEnvironmentMapper.insert(appEnvironment);
    }

    public int deleteEnvironmentById(int id, String appKey) {
        return appEnvironmentMapper.deleteById(id, appKey);
    }

    public int updateEnvironment(AppEnvironment appEnvironment) {
        return appEnvironmentMapper.updateById(appEnvironment);
    }
}
