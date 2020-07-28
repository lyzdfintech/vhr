package com.lyzdfintech.mdcp.mapper;

import com.lyzdfintech.mdcp.model.AppDeveloper;
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
public class AppDeveloperMapperTest {
    private static final Logger logger = LoggerFactory.getLogger(AppDeveloperMapperTest.class);

    @Autowired
    private AppDeveloperMapper appDeveloperMapper;

    @Test
    public void insert() throws Exception {
        AppDeveloper appDeveloper = new AppDeveloper();
        appDeveloper.setAppKey("12345678901234567890123456789012");
        appDeveloper.setName("wmg");
        appDeveloper.setLoginPassword("123456");
        appDeveloper.setPermission(2);

        appDeveloperMapper.insert(appDeveloper);
    }

    @Test
    public void selectByAppKey() throws Exception {
        String appKey = "12345678901234567890123456789012";
        logger.info(Arrays.toString(appDeveloperMapper.selectByAppKey(appKey).toArray()));
    }

    @Test
    public void updateById() throws Exception {
        AppDeveloper appDeveloper = new AppDeveloper();
        appDeveloper.setId(1);
        appDeveloper.setAppKey("12345678901234567890123456789012");
        appDeveloper.setName("wangmeigong");
        appDeveloper.setLoginPassword("12345678");
        appDeveloper.setPermission(1);
        appDeveloperMapper.updateById(appDeveloper);
    }

    @Test
    public void deleteById() throws Exception {
        appDeveloperMapper.deleteById(1, "12345678901234567890123456789012");
    }

}