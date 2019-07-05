package com.nsoft.csj.test.department.repository;

import com.nsoft.csj.test.department.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 接口，并继承于JpaRepository接口，使用注解@Repository将这个接口定义为一个资源库，使它能被其他程序引用，并为其他程序提供存储数据库功能
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
