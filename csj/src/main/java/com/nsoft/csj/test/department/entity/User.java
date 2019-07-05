package com.nsoft.csj.test.department.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.io.Serializable;
import java.util.List;


/**
 * 员工表
 */

@Entity
@Table(name = "user")   //指定关联的数据库的表名
public class User implements Serializable {

    @Id                       //定义表的主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //将其设置为自动生成
    private Long id ;
    private String name;
    @DateTimeFormat(pattern = "yyyy-mm-dd  hh:mm:ss") //进行日期格式化
    private Date createdate;

    @ManyToOne                  //定义它与部门表是多对一的关系
    @JoinColumn(name = "did")  //并且在数据库中用字的did来表示部门ID，以表示它们的对应关系
    @JsonBackReference         //用来防止关系对象的递归访问
    private Department deparment;

    /*
    CascadeType.REFRESH：级联刷新，当多个用户同时作操作一个实体，为了用户取到的数据是实时的，在用实体中的数据之前就可以调用一下refresh()方法！
    CascadeType.REMOVE：级联删除，当调用remove()方法删除Order实体时会先级联删除OrderItem的相关数据！
    CascadeType.MERGE：级联更新，当调用了Merge()方法，如果Order中的数据改变了会相应的更新OrderItem中的数据，
    CascadeType.ALL：包含以上所有级联属性。
    （注：以上几种级联操作，只能实在满足数据库的约束时才能生效，比如上边的Order和OrderItem存在主外键关联所以执行REMOVE()方法时是不能实现级联删除的）
    CascadeType.PERSIST：级联保存，当调用了Persist() 方法，会级联保存相应的数据
    */


       /*
    JPA定义实体之间的关系有如下几种：
    @OneToOne
    @ManyToOne
    @OneToMany
    @ManyToMany
    在定义它们的时候可以通过fetch属性指定加载方式，有两个值:
    FetchType.LAZY：延迟加载
    FetchType.EAGER：急加载

    其中定义是急加载的的属性(property)和字段(field)会立即从数据库中加载
     */

    /*
        https://www.jianshu.com/p/2d045b7a08b8
     */
    @ManyToMany(cascade = {},fetch = FetchType.EAGER) //定义用户和角色是多对多关系，并且用下面的中间表user_role来存储他们各自的ID，以表示他们的对应关系
    @JoinTable( name = "user_role",    //@JoinTable  两张表通过中间的关联表做联系时使用,即多对多关系,eg:权限分配 ()
            joinColumns  = {@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name="roles_id")})
    private List<Role> roles;


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

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Department getDeparment() {
        return deparment;
    }

    public void setDeparment(Department deparment) {
        this.deparment = deparment;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
