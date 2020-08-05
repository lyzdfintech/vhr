package com.lyzdfintech.mdcp.controller.um;

import com.lyzdfintech.mdcp.model.AppDeveloper;
import com.lyzdfintech.mdcp.service.AppDeveloperService;
import org.javaboy.vhr.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by wangmeigong on 2020/8/3.
 */
@RestController
@RequestMapping("/um/developer")
public class DeveloperController {
    private static final Logger logger = LoggerFactory.getLogger(DeveloperController.class);

    @Autowired
    AppDeveloperService appDeveloperService;

    @GetMapping("/")
    public RespPageBean getDeveloperByPage(HttpSession session, @RequestParam(defaultValue = "1") Integer page,
                                           @RequestParam(defaultValue = "10") Integer size, String name) {
        String appKey = (String)session.getAttribute("APP_KEY");
        return appDeveloperService.getDeveloperByPage(appKey, page, size, name);
    }

    @PostMapping("/")
    public RespBean addDeveloper(HttpSession session, @RequestBody AppDeveloper appDeveloper) {
        String appKey = (String)session.getAttribute("APP_KEY");
        appDeveloper.setAppKey(appKey);
        if (appDeveloperService.addDeveloper(appDeveloper) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteDeveloper(HttpSession session, @PathVariable Integer id) {
        String appKey = (String)session.getAttribute("APP_KEY");
        if (appDeveloperService.deleteDeveloperById(id, appKey) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PutMapping("/attribute")
    public RespBean updateDeveloperAttribute(HttpSession session, @RequestBody AppDeveloper appDeveloper) {
        String appKey = (String)session.getAttribute("APP_KEY");
        appDeveloper.setAppKey(appKey);
        if (appDeveloperService.updateDeveloper(appDeveloper) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PutMapping("/password")
    public RespBean resetDeveloperPassword(HttpSession session, @RequestBody AppDeveloper appDeveloper) {
        String appKey = (String)session.getAttribute("APP_KEY");
        appDeveloper.setAppKey(appKey);
        if (appDeveloperService.resetPassword(appDeveloper) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
}
