package com.lyzdfintech.mdcp.service;

import com.lyzdfintech.mdcp.mapper.AppServiceMapper;
import com.lyzdfintech.mdcp.model.AppService;
import org.javaboy.vhr.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangmeigong on 2020/5/12.
 */
@Service
public class AppServiceService {
    @Autowired
    AppServiceMapper appServiceMapper;

    public RespPageBean getService(String appKey) {
        List<AppService> data = appServiceMapper.selectByAppKey(appKey);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal((long)data.size());
        return bean;
    }

    public int addService(AppService appService) {
        return appServiceMapper.insert(appService);
    }

    public int deleteServiceById(int id, String appKey) {
        return appServiceMapper.deleteById(id, appKey);
    }

    public int updateService(AppService appService) {
        return appServiceMapper.updateById(appService);
    }
}