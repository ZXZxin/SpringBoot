package com.zxin.springboot.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.zxin.springboot.entities.Department;
import com.zxin.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

	private static Map<Integer, Employee> employees = null;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	static{
		employees = new HashMap<>();
		employees.put(1001, new Employee(1001, "张三", "aa@163.com", 1, new Department(101, "百度")));
		employees.put(1002, new Employee(1002, "李四", "bb@163.com", 1, new Department(102, "阿里")));
		employees.put(1003, new Employee(1003, "王五", "cc@163.com", 0, new Department(103, "华为")));
		employees.put(1004, new Employee(1004, "zxzxin", "dd@163.com", 0, new Department(104, "腾讯")));
		employees.put(1005, new Employee(1005, "赵六", "ee@163.com", 1, new Department(105, "网易")));
	}
	
	private static Integer initId = 1006;
	
	public void save(Employee employee){
		if(employee.getId() == null){
			employee.setId(initId++);
		}
		
		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}

	// 查询所有员工
	public Collection<Employee> getAll(){
		return employees.values();
	}
	
	public Employee get(Integer id){
		return employees.get(id);
	}
	
	public void delete(Integer id){
		employees.remove(id);
	}
}
