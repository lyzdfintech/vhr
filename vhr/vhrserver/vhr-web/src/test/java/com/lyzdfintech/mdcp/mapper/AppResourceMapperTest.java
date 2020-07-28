package com.lyzdfintech.mdcp.mapper;

import com.lyzdfintech.mdcp.model.AppEnvironment;
import com.lyzdfintech.mdcp.model.AppResource;
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
public class AppResourceMapperTest {
    private static final Logger logger = LoggerFactory.getLogger(AppResourceMapperTest.class);

    @Autowired
    private AppResourceMapper appResourceMapper;

    @Test
    public void insert() throws Exception {
        AppResource appResource = new AppResource();
        appResource.setAppKey("12345678901234567890123456789012");
        appResource.setResourceId("20180000");
        appResource.setResourceDesc("理财");

        appResourceMapper.insert(appResource);
    }

    @Test
    public void selectByAppKey() throws Exception {
        String appKey = "12345678901234567890123456789012";
        logger.info(Arrays.toString(appResourceMapper.selectByAppKey(appKey).toArray()));
    }

    @Test
    public void updateResourceDescById() throws Exception {
        appResourceMapper.updateResourceDescById("理财产品", 2, "12345678901234567890123456789012");
    }

    @Test
    public void deleteById() throws Exception {
        appResourceMapper.deleteById(2, "12345678901234567890123456789012");
    }

}