//package com.ee.user.model;
//
//import jakarta.persistence.*;
//
//@Entity
//public class Guest  extends Person {
////    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id", nullable = false)
//    private Long id;
//
//    private String name;
//    private String surname;
//    private int age;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinTable(name = "guestTable", joinColumns = @JoinColumn(name = "guestId"), inverseJoinColumns = @JoinColumn(name = "addressId"))
//    private GuestAddress address;
//
//    public Guest() {}
//
//    public Guest(String name, String surname, int age) {
//        this.name = name;
//        this.surname = surname;
//        this.age = age;
//    }
//
////    @JoinColumn(name = "addressId")
////    private GuestAddress address;
////    public GuestAddress getAddress() {return address;}
////    public void setAddress(GuestAddress address) {this.address = address;}
//
//
//    public GuestAddress getAddress() {return address;}
//    public void setAddress(GuestAddress address) {this.address = address;}
//
//    public String getName() {return name;}
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public Long getId() {
//        return id;
//    }
//}
