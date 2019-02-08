package com.zxin.springboot.controller;


import com.zxin.springboot.dao.DepartmentDao;
import com.zxin.springboot.dao.EmployeeDao;
import com.zxin.springboot.entities.Department;
import com.zxin.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
