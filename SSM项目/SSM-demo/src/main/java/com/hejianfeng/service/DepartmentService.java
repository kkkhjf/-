package com.hejianfeng.service;

import com.hejianfeng.dao.DepartmentMapper;
import com.hejianfeng.pojo.Department;
import com.hejianfeng.pojo.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HJF
 * @create 2021/10/6
 */
@Service
public class DepartmentService {

    @Autowired
    public DepartmentMapper departmentMapper;

    public List<Department> getAllDeptInfo(){
        return departmentMapper.selectByExample(null);
    }
}
