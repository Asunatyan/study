package com.example.designpatterns.part01.vo;

public class UserVo {

    private Integer id;
    private String name;
    private String telephone;
    private String password;

    public UserVo() {
    }

    public UserVo(Integer id, String name, String telephone, String password) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.password = password;
    }

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
