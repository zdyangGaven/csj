package com.nsoft.csj.test.department.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 部门表
 */
@Entity
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //@ID定义一条记录的唯一标识  结合注解@GeneratedValue将其设置为自动生成
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
