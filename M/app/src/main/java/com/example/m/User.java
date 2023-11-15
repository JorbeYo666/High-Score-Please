package com.example.m;

public class User {
    private  int id;
    private  String idnum;
    private  String password;

    private String tel;
    public User(String idnum,String password, String tel){
        super();
        this.idnum = idnum;
        this.password = password;
        this.tel = tel;
    }
    public  int getId() {
        return  id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getIdnum() {
        return idnum;
    }
    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }




}
