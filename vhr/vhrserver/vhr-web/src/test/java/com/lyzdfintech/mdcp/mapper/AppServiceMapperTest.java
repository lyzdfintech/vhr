package com.lyzdfintech.mdcp.mapper;

import com.lyzdfintech.mdcp.model.AppResource;
import com.lyzdfintech.mdcp.model.AppService;
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
public class AppServiceMapperTest {
    private static final Logger logger = LoggerFactory.getLogger(AppServiceMapperTest.class);

    @Autowired
    private AppServiceMapper appServiceMapper;

    @Test
    public void insert() throws Exception {
        AppService appService = new AppService();
        appService.setAppKey("12345678901234567890123456789012");
        appService.setServiceId("ucf");
        appService.setServiceDesc("用户微服务");

        appServiceMapper.insert(appService);
    }

    @Test
    public void selectByAppKey() throws Exception {
        String appKey = "12345678901234567890123456789012";
        logger.info(Arrays.toString(appServiceMapper.selectByAppKey(appKey).toArray()));
    }

    @Test
    public void updateServiceDescById() throws Exception {
        AppService appService = new AppService();
        appService.setId(2);
        appService.setAppKey("12345678901234567890123456789012");
        appService.setServiceId("ucf");
        appService.setServiceDesc("*用户微服务*");
        appServiceMapper.updateById(appService);
    }

    @Test
    public void deleteById() throws Exception {
        appServiceMapper.deleteById(2, "12345678901234567890123456789012");
    }

}