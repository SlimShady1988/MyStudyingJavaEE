package com.ee.user.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Objects;
@Entity
//@NamedStoredProcedureQuery(name = "userSelect", procedureName = "userSelect", parameters = {
//        @StoredProcedureParameter(name = "userId", mode = ParameterMode.IN, type = Integer.class),
//        @StoredProcedureParameter(name = "userAge", mode = ParameterMode.IN, type = Integer.class)
//})
@XmlRootElement
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int id;
    private String name;
    private String surname;
    private int age;

//    @Version
//    private int version;

    public User() {}

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }


    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getSurname() {return surname;}

    public void setSurname(String surname) {this.surname = surname;}

    public int getAge() {return age;}

    public void setAge(int age) {this.age = age;}

//    public int getVersion() {return version;}

//    public void setVersion(int version) {this.version = version;}

}