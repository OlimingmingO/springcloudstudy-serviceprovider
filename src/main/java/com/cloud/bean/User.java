package com.cloud.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Oliverlee on 2018/3/24.
 */
@Entity
/**
 * 通过这个注解把类映射到数据库表，操作对象就能完成对数据库表的增删改查，不需要写Seql语句
 */
public class User {
    @Id //使用ID指定主键
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    public String name;
    public String mobile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
