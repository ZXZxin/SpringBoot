package com.zxin.springboot.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.zxin.springboot.entities.Department;
import org.springframework.stereotype.Repository;


@Repository
public class DepartmentDao {

	private static Map<Integer, Department> departments = null;
	
	static{
		departments = new HashMap<Integer, Department>();
		
		departments.put(101, new Department(101, "百度"));
		departments.put(102, new Department(102, "阿里"));
		departments.put(103, new Department(103, "华为"));
		departments.put(104, new Department(104, "腾讯"));
		departments.put(105, new Department(105, "网易"));
	}
	
	public Collection<Department> getDepartments(){
		return departments.values();
	}
	
	public Department getDepartment(Integer id){
		return departments.get(id);
	}
	
}
