package com.zxin.springboot.mapper;

import com.zxin.springboot.bean.Employee;

// @Mapper
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);


}
