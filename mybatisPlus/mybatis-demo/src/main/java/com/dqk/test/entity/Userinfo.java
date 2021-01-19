package com.dqk.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.dqk.test.typeHandler.MyTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author dqk
 * @since 2021-01-18
 */
public class Userinfo {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄，普通索引列
     */
    private Integer age;

    /**
     * 手机，唯一索引列
     */
    private String phone;

    @TableField(typeHandler = MyTypeHandler.class)
    private String updateDate;

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

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "id=" + id +
                ", name=" + name +
                ", age=" + age +
                ", phone=" + phone +
                ", updateDate=" + updateDate +
                "}";
    }
}
