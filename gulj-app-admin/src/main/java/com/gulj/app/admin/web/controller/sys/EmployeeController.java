package com.gulj.admin.web.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("sys/sys/employee")
@Controller
public class EmployeeController {


    @RequestMapping("list")
    public String list() {
        return "sys/sys/employee/list";
    }


}
