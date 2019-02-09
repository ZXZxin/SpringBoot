package com.zxin.springboot.controller;


import com.zxin.springboot.dao.DepartmentDao;
import com.zxin.springboot.dao.EmployeeDao;
import com.zxin.springboot.entities.Department;
import com.zxin.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    // 查询员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){

        Collection<Employee> employees = employeeDao.getAll();// 查出所有员工

        // 放在请求域中(数据)
        model.addAttribute("emps", employees);

        // thymeleaf会拼凑串， 会拼凑到类路径下 prefix
        // private String prefix = "classpath:/templates/";
        // 后缀 suffix = ".html"
        return "emp/list";
    }


    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){

        //来到添加页面, 需要所有的部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        return "emp/add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定，要求了请求参数的名字和javaBean入参的属性名一样
    @PostMapping("/emp")
    public String addEmp(Employee employee){ // 直接放在参数中，这样需要在表单中的名字和javabean

        //保存在数据库 (调用service -> dao 的save方法)(这样省略了service)
        employeeDao.save(employee);

        // 需要来到员工页面
        // redirect: 表示重定向一个地址, /代表当前项目根路径
        // forward: 表示转发到一个地址
        return "redirect:/emps"; //　添加完之后回到查询员工返回列表页面
    }


    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        //页面要显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "emp/add";
    }

    //员工修改；需要提交员工id；
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改的员工数据："+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
