package com.lyzdfintech.mdcp.mapper;

import com.lyzdfintech.mdcp.model.Application;
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
public class ApplicationTest {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationTest.class);

    @Autowired
    private ApplicationMapper applicationMapper;

    @Test
    public void insert() throws Exception {
        Application application = new Application();
        application.setAppKey("12345678901234567890123456789012");
        application.setAppName("手机银行");

        applicationMapper.insert(application);
    }

    @Test
    public void selectByAppKey() throws Exception {
        String appKey = "12345678901234567890123456789012";
        logger.info(Arrays.toString(applicationMapper.selectByAppKey(appKey).toArray()));
    }

}