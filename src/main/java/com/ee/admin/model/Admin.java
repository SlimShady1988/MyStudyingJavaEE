package com.ee.admin.model;

public class Admin {
    private int age;
    private String name;
    private String surname;

    public Admin(int age, String name, String surname) {
        this.age = age;
        this.name = name;
        this.surname = surname;
    }
    public Admin() { }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
