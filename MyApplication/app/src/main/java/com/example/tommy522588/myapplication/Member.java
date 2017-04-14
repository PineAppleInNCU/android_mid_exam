package com.example.tommy522588.myapplication;

import java.io.Serializable;

/**
 * Created by tommy522588 on 2017/4/11.
 */

public class Member  implements Serializable {
    private static final long serialVersionUID = -7060210544600464481L;

    private int id;
    private String name;
    private int age;
    private String gender;
    private String master;

    public Member() {
        super();
    }

    public Member(String name,int age,String gender,String master) {
        super();
        this.name=name;
        this.age = age;
        this.gender = gender;
        this.master = master;
    }

    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAge(){
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getGender(){
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getMaster(){
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }
}
