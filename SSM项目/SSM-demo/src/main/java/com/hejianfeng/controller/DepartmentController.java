package com.hejianfeng.controller;

import com.hejianfeng.pojo.Department;
import com.hejianfeng.pojo.Msg;
import com.hejianfeng.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author HJF
 * @create 2021/10/6
 */
@Controller
public class DepartmentController {

    @Autowired
    public DepartmentService departmentService;

    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
        List<Department> allDeptInfo = departmentService.getAllDeptInfo();
        return Msg.success().add("depts", allDeptInfo);
    }
}
