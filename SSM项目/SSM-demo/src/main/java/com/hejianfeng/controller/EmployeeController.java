package com.hejianfeng.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hejianfeng.pojo.Employee;
import com.hejianfeng.pojo.Msg;
import com.hejianfeng.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.MaskFormatter;
import javax.validation.Valid;
import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author HJF
 * @create 2021/10/5
 */
@Controller
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    /**
     * 不使用json的传输方式
     */
    //@RequestMapping("/emps")
    //public String getAllEmp(@RequestParam(value = "pn",defaultValue = "1") Integer pn, HttpServletRequest request, Model model){
    //    //引入分页插件，在查询前只需要调用，传入页码以及每页的大小
    //    PageHelper.startPage(pn, 5);
    //    //将查询出的数据放入一个集合
    //    List<Employee> all = employeeService.getAll();
    //    //使用PageInfo将查询到的结果包装，并通过Model将PageInfo返回至前台
    //    //参数1：被封装的集合；参数2：连续现实的页数
    //    PageInfo pageInfo = new PageInfo(all, 5);
    //    model.addAttribute("pageInfo", pageInfo);
    //    return "list";
    //}

    /**
     * 使用json进行数据传输
     */
    @RequestMapping("/emps")
    @ResponseBody
    public Msg getAllEmp(@RequestParam(value = "pn",defaultValue = "1") Integer pn, HttpServletRequest request, Model model){
            //引入分页插件，在查询前只需要调用，传入页码以及每页的大小
            PageHelper.startPage(pn, 5);
            //将查询出的数据放入一个集合
            List<Employee> all = employeeService.getAll();
            //使用PageInfo将查询到的结果包装，并通过Model将PageInfo返回至前台
            //参数1：被封装的集合；参数2：连续现实的页数
            PageInfo pageInfo = new PageInfo(all, 5);
            //将信息封装进自定义的Msg对象中
            return Msg.success().add("pageInfo", pageInfo);
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(@Valid Employee employee, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //校验失败
            HashMap<String, Object> map = new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for(FieldError fieldError : fieldErrors){
                //错误的字段名：fieldError.getField()
                //错误信息：fieldError.getDefaultMessage()
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);
        }else{
            //校验成功
            //Integer integer = employeeService.insertEmp(employee);
            return Msg.success().add("status", "s");
        }
    }

    /**
     * 检查用户名是否可用，可用返回success的状态码，不可用返回fail的状态码
     * @param empName
     * @return
     */
    @RequestMapping("/checkUser")
    @ResponseBody
    public Msg checkUser(@RequestParam("empName") String empName){
        //为了校验规则的统一，在后端也进行一次输入格式的校验
        //声明一个正则表达式
        String regx = "(^[a-zA-Z0-9]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
        if(!empName.matches(regx)){
            return Msg.fail().add("va_msg", "用户名必须是2-5位的汉字或6-16位的数字");
        }
        //数据库用户名重复校验
        boolean b = employeeService.checkUser(empName);
        if(b){
            return Msg.fail().add("va_msg", "用户名重复");
        }else{
            return Msg.success();
        }
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getEmp(@PathVariable(value = "id") Integer id){
        Employee oneById = employeeService.getOneById(id);
        return Msg.success().add("emp", oneById);
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Msg updateEmp(Employee employee){
        System.out.println("进入更新方法！");
        System.out.println(employee);
        employeeService.updateEmp(employee);
        return Msg.success();
    }

    /**
     * ids包含有-表示批量删除，否则就是单个删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "/emp/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteEmpById(@PathVariable(value = "ids") String ids){
        //批量删除
        if(ids.contains("-")){
            String[] split = ids.split("-");
            List<Integer> list = new ArrayList<>();
            for(String id : split){
                list.add(Integer.parseInt(id));
            }
            System.out.println(list);
            //employeeService.deleteEmpBatch(list);
            System.out.println("进入批量删除delete方法" + ids);
            //return Msg.success();
            return null;
        }else{
            //单个删除
            System.out.println("进入单个删除delete方法" + ids);
            //employeeService.deletEmpById(id);
            return "abc";
            //return Msg.success();
        }
    }

}
