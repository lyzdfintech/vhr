package com.lyzdfintech.mdcp.controller.um;

import com.lyzdfintech.mdcp.model.AppDeveloper;
import com.lyzdfintech.mdcp.model.AppRequirement;
import com.lyzdfintech.mdcp.model.AppRequirementVo;
import com.lyzdfintech.mdcp.service.AppDeveloperService;
import com.lyzdfintech.mdcp.service.AppRequirementService;
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
@RequestMapping("/pm/requirement")
public class RequirementController {
    private static final Logger logger = LoggerFactory.getLogger(RequirementController.class);

    @Autowired
    AppRequirementService appRequirementService;

    @GetMapping("/")
    public RespPageBean getRequirementByPage(HttpSession session, @RequestParam(defaultValue = "1") Integer page,
                                             @RequestParam(defaultValue = "10") Integer size, String name,
                                             Integer milestone) {
        String appKey = (String)session.getAttribute("APP_KEY");
        return appRequirementService.getRequirementByPage(appKey, page, size, name, milestone);
    }

    @PostMapping("/")
    public RespBean addRequirement(HttpSession session, @RequestBody AppRequirement appRequirement) {
        String appKey = (String)session.getAttribute("APP_KEY");
        appRequirement.setAppKey(appKey);
        if (appRequirementService.addRequirement(appRequirement) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteRequirement(HttpSession session, @PathVariable Integer id) {
        String appKey = (String)session.getAttribute("APP_KEY");
        if (appRequirementService.deleteRequirementById(id, appKey) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PutMapping("/")
    public RespBean updateRequirement(HttpSession session, @RequestBody AppRequirement appRequirement) {
        String appKey = (String)session.getAttribute("APP_KEY");
        appRequirement.setAppKey(appKey);
        if (appRequirementService.updateRequirement(appRequirement) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
}
