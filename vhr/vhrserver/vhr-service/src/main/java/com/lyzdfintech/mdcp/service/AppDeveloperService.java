package com.lyzdfintech.mdcp.service;

import com.lyzdfintech.mdcp.mapper.AppDeveloperMapper;
import com.lyzdfintech.mdcp.model.AppDeveloper;
import org.javaboy.vhr.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangmeigong on 2020/5/12.
 */
@Service
public class AppDeveloperService {
    @Autowired
    AppDeveloperMapper appDeveloperMapper;

    public RespPageBean getDeveloperByPage(String appKey, Integer page, Integer size, String name) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<AppDeveloper> data = appDeveloperMapper.selectByAppKey(appKey, page, size, name);
        Long total = appDeveloperMapper.countByAppKey(appKey, name);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public int addDeveloper(AppDeveloper appDeveloper) {
        appDeveloper.setLoginPassword("123456");

        return appDeveloperMapper.insert(appDeveloper);
    }

    public int deleteDeveloperById(int id, String appKey) {
        return appDeveloperMapper.deleteById(id, appKey);
    }

    public int updateDeveloper(AppDeveloper appDeveloper) {
        return appDeveloperMapper.updateById(appDeveloper);
    }

    public int resetPassword(AppDeveloper appDeveloper) {
        appDeveloper.setLoginPassword("123456");
        return appDeveloperMapper.updateById(appDeveloper);
    }
}
