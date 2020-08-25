package com.lyzdfintech.mdcp.service;

import com.lyzdfintech.mdcp.mapper.AppRequirementMapper;
import com.lyzdfintech.mdcp.model.AppRequirement;
import org.javaboy.vhr.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangmeigong on 2020/5/12.
 */
@Service
public class AppRequirementService {
    @Autowired
    AppRequirementMapper appRequirementMapper;

    public RespPageBean getRequirementByPage(String appKey, Integer page, Integer size, String name, Integer milestone) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<AppRequirement> data = appRequirementMapper.selectByAppKey(appKey, page, size, name, milestone);
        //List<AppRequirementVo> appRequirementVoList = new ArrayList();
        //data.forEach(element -> appRequirementVoList.add(new AppRequirementVo(element)));
        Long total = appRequirementMapper.countByAppKey(appKey, name, milestone);
        RespPageBean bean = new RespPageBean();
        //bean.setData(appRequirementVoList);
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public int addRequirement(AppRequirement appRequirement) {
        return appRequirementMapper.insert(appRequirement);
    }

    public int deleteRequirementById(int id, String appKey) {
        return appRequirementMapper.deleteById(id, appKey);
    }

    public int updateRequirement(AppRequirement appRequirement) {
        return appRequirementMapper.updateById(appRequirement);
    }
}
