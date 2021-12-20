//package com.ee.user.model;
//
//import jakarta.persistence.*;
//
//@Table(name = "guestsAddress")
//@Entity
//public class GuestAddress {
//    @Id @GeneratedValue
//    long id;
//
//    String city;
//    String street;
//    @OneToOne(mappedBy = "address")
//    private Guest guest;
//
//    public GuestAddress(Guest guest, String street, String city) {
//        this.guest = guest;
//
////    public GuestAddress(String street, String city) {
//        this.street = street;
//        this.city = city;
//    }
//
//    public GuestAddress() {}
//}
