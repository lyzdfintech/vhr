package com.lyzdfintech.mdcp.service;

import com.lyzdfintech.mdcp.mapper.AppEnvironmentMapper;
import com.lyzdfintech.mdcp.mapper.AppResourceMapper;
import com.lyzdfintech.mdcp.model.AppEnvironment;
import com.lyzdfintech.mdcp.model.AppResource;
import org.javaboy.vhr.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangmeigong on 2020/5/12.
 */
@Service
public class AppResourceService {
    @Autowired
    AppResourceMapper appResourceMapper;

    public RespPageBean getResource(String appKey) {
        List<AppResource> data = appResourceMapper.selectByAppKey(appKey);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal((long)data.size());
        return bean;
    }

    public int addResource(AppResource appResource) {
        return appResourceMapper.insert(appResource);
    }

    public int deleteResourceById(int id, String appKey) {
        return appResourceMapper.deleteById(id, appKey);
    }

    public int updateResource(AppResource appResource) {
        return appResourceMapper.updateById(appResource);
    }
}
