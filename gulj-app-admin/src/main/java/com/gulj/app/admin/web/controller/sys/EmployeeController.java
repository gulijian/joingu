package com.gulj.app.admin.web.controller.sys;

import com.gulj.app.admin.web.constant.AdminConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("sys/sys/employee")
@Controller
public class EmployeeController {


    @RequestMapping("list")
    public String list() {
        return AdminConstant.VIEW_ROOT+"sys/sys/employee/list";
    }


}
