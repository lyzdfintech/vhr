package com.lyzdfintech.mdcp.mapper;

import com.alibaba.fastjson.JSONArray;
import com.lyzdfintech.mdcp.model.AppRequirement;
import org.javaboy.vhr.VhrApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.Arrays;

/**
 * Created by wangmeigong on 2020/6/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = VhrApplication.class)
public class AppRequirementMapperTest {
    private static final Logger logger = LoggerFactory.getLogger(AppRequirementMapperTest.class);

    @Autowired
    private AppRequirementMapper appRequirementMapper;

    @Test
    public void insert() throws Exception {
        AppRequirement appRequirement = new AppRequirement();
        appRequirement.setAppKey("12345678901234567890123456789012");
        appRequirement.setName("CR19231_XXXXXXX");
        appRequirement.setMilestone(1);
        appRequirement.setOwner(1);
        JSONArray client = new JSONArray();
        client.add(1);
        client.add(2);
        appRequirement.setClient(client);
        appRequirement.setState(0);

        appRequirementMapper.insert(appRequirement);
    }

    @Test
    public void selectByAppKey() throws Exception {
        String appKey = "12345678901234567890123456789012";
        logger.info(Arrays.toString(appRequirementMapper.selectByAppKey(appKey, null, null, null, null).toArray()));
    }

    @Test
    public void updateById() throws Exception {
        AppRequirement appRequirement = new AppRequirement();
        appRequirement.setId(1);
        appRequirement.setAppKey("12345678901234567890123456789012");
        appRequirement.setName("CR19231_YYYYYYY");
        appRequirement.setMilestone(2);
        appRequirement.setOwner(2);
        appRequirement.setState(1);
        appRequirement.setDescriptor("这里是描述信息");
        appRequirementMapper.updateById(appRequirement);
    }

    @Test
    public void deleteById() throws Exception {
        appRequirementMapper.deleteById(1, "12345678901234567890123456789012");
    }

}