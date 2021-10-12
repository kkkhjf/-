package com.hejianfeng.test;

import com.github.pagehelper.PageInfo;
import com.hejianfeng.pojo.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import javax.xml.transform.Source;
import java.util.List;

/**
 * @author HJF
 * @create 2021/10/5
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:Spring.xml", "classpath:SpringMVC.xml"})
public class MvcTest {

    /**
     * 传入SpringMVC的IOC
     */
    @Autowired
    public WebApplicationContext webApplicationContext;

    /**
     * 虚拟的Mvc请求，并获取请求结果
     */
    public MockMvc mockMvc;

    @Before
    public void initMockMvc(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testPage() throws Exception {
        //模拟请求拿到返回值
        MvcResult pn = this.mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1")).andReturn();
        //请求成功后，请求域中的pageInfo，从Model获取PageInfo进行验证
        MockHttpServletRequest request = pn.getRequest();
        PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码：" + pageInfo.getPageNum());
        System.out.println("总页码：" + pageInfo.getPages());
        System.out.println("总记录数：" + pageInfo.getTotal());
        int[] nums = pageInfo.getNavigatepageNums();
        System.out.println("在页面需要连续显示的页码");
        for(int i : nums){
            System.out.println(" " + i);
        }
        List<Employee> list = pageInfo.getList();
        for(Employee emp : list){
            System.out.println(emp.toString());
        }
    }

    @Test
    public void testSaveEmp() throws Exception {
        MvcResult pn = this.mockMvc.perform(MockMvcRequestBuilders.get("/emp", RequestMethod.POST).param("employee", "new Employee(null, \"Lebro\", \"1\", \"lebrolaker@gmail.com\", 3)")).andReturn();
        MockHttpServletRequest request = pn.getRequest();
    }
    @Test
    public void testEmp() throws Exception {
        MvcResult pn = this.mockMvc.perform(MockMvcRequestBuilders.get("/emp/3", RequestMethod.POST).param("id", "3")).andReturn();
        MockHttpServletRequest request = pn.getRequest();
    }

}
