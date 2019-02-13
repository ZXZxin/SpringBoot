package com.zxin.springboot.repository;

import com.zxin.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//继承JpaRepository来完成对数据库的操作, 第一个参数是要操作的实体，第二个参数是实体的主键的类型
public interface UserRepository extends JpaRepository<User,Integer> {

}
