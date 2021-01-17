package com.dqk.test.entity;

import com.dqk.test.generator.BaseDto;

/**
 * <p>
 * 
 * </p>
 *
 * @author dqk
 * @since 2021-01-17
 */
public class Userinfo{

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;
    private String remark;

    /**
     * 年龄，普通索引列
     */
    private Integer age;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 手机，唯一索引列
     */
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
            "id=" + id +
            ", name=" + name +
            ", age=" + age +
            ", phone=" + phone +
        "}";
    }
}
