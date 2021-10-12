package com.hejianfeng.service;

import com.hejianfeng.dao.EmployeeMapper;
import com.hejianfeng.pojo.Employee;
import com.hejianfeng.pojo.EmployeeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HJF
 * @create 2021/10/5
 */
@Service
public class EmployeeService {

    @Autowired
    public EmployeeMapper employeeMapper;

    public List<Employee> getAll(){
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.setOrderByClause("e.id");
        return employeeMapper.selectByExampleWithDept(employeeExample);
    }

    public Employee getOneById(Integer id){
        return employeeMapper.selectByPrimaryKey(id);
    }

    public Integer insertEmp(Employee employee){
        int i = employeeMapper.insertSelective(employee);
        return i;
    }

    public boolean checkUser(String empName){
        //创建EmployeeExample对象，用于条件查询
        EmployeeExample employeeExample = new EmployeeExample();
        //创建Criteria对象
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        //向Criteria对象中添加条件要求，即用户名必须等于指定的参数
        criteria.andLastNameEqualTo(empName);
        //调用带有EmployeeExample对象的sql语句，会按照Criteria对象中设定好的条件执行sql语句
        long l = employeeMapper.countByExample(employeeExample);
        if(l > 0){
            return true;
        }else{
            return false;
        }
    }

    public void updateEmp(Employee employee){
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public void deletEmpById(String id){
        employeeMapper.deleteByPrimaryKey(Integer.parseInt(id));
    }

    public void deleteEmpBatch(List<Integer> ids){
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andIdIn(ids);
        employeeMapper.deleteByExample(employeeExample);
    }

}
