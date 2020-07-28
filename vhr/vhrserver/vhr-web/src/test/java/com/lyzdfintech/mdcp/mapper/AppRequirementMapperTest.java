package com.lyzdfintech.mdcp.mapper;

import com.lyzdfintech.mdcp.model.AppRequirement;
import com.lyzdfintech.mdcp.model.AppService;
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
        Date milestone = new Date(System.currentTimeMillis());
        appRequirement.setMilestone(milestone);
        appRequirement.setOwner("王美功");

        appRequirementMapper.insert(appRequirement);
    }

    @Test
    public void selectByAppKey() throws Exception {
        String appKey = "12345678901234567890123456789012";
        logger.info(Arrays.toString(appRequirementMapper.selectByAppKey(appKey).toArray()));
    }

    @Test
    public void updateById() throws Exception {
        AppRequirement appRequirement = new AppRequirement();
        appRequirement.setId(1);
        appRequirement.setAppKey("12345678901234567890123456789012");
        appRequirement.setName("CR19231_YYYYYYY");
        Date milestone = new Date(System.currentTimeMillis());
        appRequirement.setMilestone(milestone);
        appRequirement.setOwner("白雪亮");
        appRequirement.setClient("11");
        appRequirement.setResource("20180000|20180001");
        appRequirement.setService("ucf|acf");
        appRequirement.setState(1);
        appRequirement.setDescriptor("这里是描述信息");
        appRequirementMapper.updateById(appRequirement);
    }

    @Test
    public void deleteById() throws Exception {
        appRequirementMapper.deleteById(1, "12345678901234567890123456789012");
    }

}