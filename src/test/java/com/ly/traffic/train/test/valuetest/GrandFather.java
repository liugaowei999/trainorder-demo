package com.ly.traffic.train.test.valuetest;

public class GrandFather {

    //姓名
    private String name;
    //性别
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    //干农活
    public void doFarmWork(){
        System.out.println("do do do ...simple life!");
    }
}
