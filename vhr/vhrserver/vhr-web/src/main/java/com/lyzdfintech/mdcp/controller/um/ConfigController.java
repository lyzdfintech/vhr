package com.lyzdfintech.mdcp.controller.um;

import com.lyzdfintech.mdcp.model.*;
import com.lyzdfintech.mdcp.service.*;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.RespPageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by wangmeigong on 2020/8/3.
 */
@RestController
@RequestMapping("/ac")
public class ConfigController {
    private static final Logger logger = LoggerFactory.getLogger(ConfigController.class);

    @Autowired
    AppMilestoneService appMilestoneService;

    @Autowired
    AppEnvironmentService appEnvironmentService;

    @Autowired
    AppResourceService appResourceService;

    @Autowired
    AppServiceService appServiceService;

    @GetMapping("/milestone")
    public RespPageBean getMilestone(HttpSession session) {
        String appKey = (String)session.getAttribute("APP_KEY");
        return appMilestoneService.getMilestone(appKey);
    }

    @PostMapping("/milestone")
    public RespBean addMilestone(HttpSession session, @RequestBody AppMilestone appMilestone) {
        String appKey = (String)session.getAttribute("APP_KEY");
        appMilestone.setAppKey(appKey);
        if (appMilestoneService.addMilestone(appMilestone) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/milestone/{id}")
    public RespBean deleteMilestone(HttpSession session, @PathVariable Integer id) {
        String appKey = (String)session.getAttribute("APP_KEY");
        if (appMilestoneService.deleteMilestoneById(id, appKey) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PutMapping("/milestone")
    public RespBean updateMilestone(HttpSession session, @RequestBody AppMilestone appMilestone) {
        String appKey = (String)session.getAttribute("APP_KEY");
        appMilestone.setAppKey(appKey);
        if (appMilestoneService.updateMilestone(appMilestone) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @GetMapping("/envrionment")
    public RespPageBean getEnviroment(HttpSession session) {
        String appKey = (String)session.getAttribute("APP_KEY");
        return appEnvironmentService.getEnvironment(appKey);
    }

    @PostMapping("/envrionment")
    public RespBean addEnviroment(HttpSession session, @RequestBody AppEnvironment appEnvironment) {
        String appKey = (String)session.getAttribute("APP_KEY");
        appEnvironment.setAppKey(appKey);
        if (appEnvironmentService.addEnvironment(appEnvironment) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/envrionment/{id}")
    public RespBean deleteEnviroment(HttpSession session, @PathVariable Integer id) {
        String appKey = (String)session.getAttribute("APP_KEY");
        if (appEnvironmentService.deleteEnvironmentById(id, appKey) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PutMapping("/envrionment")
    public RespBean updateEnviroment(HttpSession session, @RequestBody AppEnvironment appEnvironment) {
        String appKey = (String)session.getAttribute("APP_KEY");
        appEnvironment.setAppKey(appKey);
        if (appEnvironmentService.updateEnvironment(appEnvironment) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @GetMapping("/resource")
    public RespPageBean getResource(HttpSession session) {
        String appKey = (String)session.getAttribute("APP_KEY");
        return appResourceService.getResource(appKey);
    }

    @PostMapping("/resource")
    public RespBean addResource(HttpSession session, @RequestBody AppResource appResource) {
        String appKey = (String)session.getAttribute("APP_KEY");
        appResource.setAppKey(appKey);
        if (appResourceService.addResource(appResource) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/resource/{id}")
    public RespBean deleteResource(HttpSession session, @PathVariable Integer id) {
        String appKey = (String)session.getAttribute("APP_KEY");
        if (appResourceService.deleteResourceById(id, appKey) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PutMapping("/resource")
    public RespBean updateResource(HttpSession session, @RequestBody AppResource appResource) {
        String appKey = (String)session.getAttribute("APP_KEY");
        appResource.setAppKey(appKey);
        if (appResourceService.updateResource(appResource) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @GetMapping("/service")
    public RespPageBean getService(HttpSession session) {
        String appKey = (String)session.getAttribute("APP_KEY");
        return appServiceService.getService(appKey);
    }

    @PostMapping("/service")
    public RespBean addService(HttpSession session, @RequestBody AppService appService) {
        String appKey = (String)session.getAttribute("APP_KEY");
        appService.setAppKey(appKey);
        if (appServiceService.addService(appService) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/service/{id}")
    public RespBean deleteService(HttpSession session, @PathVariable Integer id) {
        String appKey = (String)session.getAttribute("APP_KEY");
        if (appServiceService.deleteServiceById(id, appKey) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PutMapping("/service")
    public RespBean updateResource(HttpSession session, @RequestBody AppService appService) {
        String appKey = (String)session.getAttribute("APP_KEY");
        appService.setAppKey(appKey);
        if (appServiceService.updateService(appService) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
}
