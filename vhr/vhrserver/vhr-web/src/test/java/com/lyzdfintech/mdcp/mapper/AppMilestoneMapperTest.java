package com.lyzdfintech.mdcp.mapper;

import com.lyzdfintech.mdcp.model.AppMilestone;
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
public class AppMilestoneMapperTest {
    private static final Logger logger = LoggerFactory.getLogger(AppMilestoneMapperTest.class);

    @Autowired
    private AppMilestoneMapper appMilestoneMapper;

    @Test
    public void insert() throws Exception {
        AppMilestone appMilestone = new AppMilestone();
        appMilestone.setAppKey("12345678901234567890123456789012");
        Date productReleaseDate = new Date(System.currentTimeMillis());
        appMilestone.setProductReleaseDate(productReleaseDate);
        appMilestone.setName("三阶段7月16日版本");

        appMilestoneMapper.insert(appMilestone);
    }

    @Test
    public void selectByAppKey() throws Exception {
        String appKey = "12345678901234567890123456789012";
        logger.info(Arrays.toString(appMilestoneMapper.selectByAppKey(appKey).toArray()));
    }

    @Test
    public void updateNameById() throws Exception {
        AppMilestone appMilestone = new AppMilestone();
        appMilestone.setAppKey("12345678901234567890123456789012");
        Date productReleaseDate = new Date(System.currentTimeMillis());
        appMilestone.setProductReleaseDate(productReleaseDate);
        appMilestone.setName("7月16日版本");
        appMilestoneMapper.updateById(appMilestone);
    }

    @Test
    public void deleteById() throws Exception {
        appMilestoneMapper.deleteById(3, "12345678901234567890123456789012");
    }

}