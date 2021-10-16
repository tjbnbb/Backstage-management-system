package com.tjb.backend.bean;

public class PersonBean {
    private String username;
    private String name;//主键
    private Integer age;
    private String teleno;

    public PersonBean(String username, String name, Integer age, String teleno){
        this.username = username;
        this.name = name;
        this.age = age;
        this.teleno = teleno;
    }

    /*public PersonBean(String username,String name){
        this(username,name,null,"");
    }

    public PersonBean(String username,String name,Integer age){
        this(username,name,age,"");
    }*/

    public String getUsername(){
        return username;
    }

    public String getName(){
        return name;
    }

    public Integer getAge(){
        return age;
    }

    public String getTeleno(){
        return teleno;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setName(String name){ this.name = name; }

    public void setAge(Integer age){
        this.age = age;
    }

    public void setTeleno(String teleno){
        this.teleno = teleno;
    }
}
