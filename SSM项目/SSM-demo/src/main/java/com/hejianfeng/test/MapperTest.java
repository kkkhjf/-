package com.hejianfeng.test;

import com.hejianfeng.dao.DepartmentMapper;
import com.hejianfeng.dao.EmployeeMapper;
import com.hejianfeng.pojo.Department;
import com.hejianfeng.pojo.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author HJF
 * @create 2021/10/4
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:Spring.xml"})
public class MapperTest {

    @Autowired
    public DepartmentMapper departmentMapper;

    @Autowired
    public EmployeeMapper employeeMapper;

    @Test
    public void testCRUD(){
        //departmentMapper.insert(new Department(3, "人事部"));
        List<Employee> employees = employeeMapper.selectByExampleWithDept(null);
        System.out.println(employees.toString());
    }


}
