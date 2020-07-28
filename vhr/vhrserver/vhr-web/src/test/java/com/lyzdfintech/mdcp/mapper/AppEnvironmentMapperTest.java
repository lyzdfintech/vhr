package com.lyzdfintech.mdcp.mapper;

import com.lyzdfintech.mdcp.model.AppEnvironment;
import org.javaboy.vhr.VhrApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * Created by wangmeigong on 2020/6/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = VhrApplication.class)
public class AppEnvironmentMapperTest {
    private static final Logger logger = LoggerFactory.getLogger(AppEnvironmentMapperTest.class);

    @Autowired
    private AppEnvironmentMapper appEnvironmentMapper;

    @Test
    public void insert() throws Exception {
        AppEnvironment appEnvironment = new AppEnvironment();
        appEnvironment.setAppKey("12345678901234567890123456789012");
        appEnvironment.setEnvName("uat");
        appEnvironment.setEnvDesc("用户验收测试环境");

        appEnvironmentMapper.insert(appEnvironment);
    }

    @Test
    public void selectByAppKey() throws Exception {
        String appKey = "12345678901234567890123456789012";
        logger.info(Arrays.toString(appEnvironmentMapper.selectByAppKey(appKey).toArray()));
    }

    @Test
    public void updateEnvDescById() throws Exception {
        appEnvironmentMapper.updateEnvDescById("*用户验收测试环境*", 2, "12345678901234567890123456789012");
    }

    @Test
    public void deleteById() throws Exception {
        appEnvironmentMapper.deleteById(2, "12345678901234567890123456789012");
    }

}