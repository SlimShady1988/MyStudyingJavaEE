package com.ee.user;

//import com.ee.user.model.Guest;
//import com.ee.user.model.GuestAddress;

import com.ee.user.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UserDeploy {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("bnv");
        EntityManager em = managerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

//        Guest guest = new Guest("Lex","Luter", 55);
//        Guest guest2 = new Guest("Lex2","Luter2", 22);
//        Guest guest3 = new Guest("Lex3","Luter3", 33);
//        GuestAddress guestAddress = new GuestAddress(guest,"McManamana", "NY");
//        GuestAddress guestAddress2 = new GuestAddress(guest2,"McZeppelina", "NJ");
//        GuestAddress guestAddress3 = new GuestAddress(guest3,"McZeppelina", "NJ");
//        list.add(guestAddress);
//        list.add(guestAddress2);
//        list.add(guestAddress3);
//        guest.setAge(20);
//        guest.setName("Lex");
//        guest.setSurname("Luter");
//        guest.setAddress(list);
//        guest2.setAddress(list);
//        guest3.setAddress(list);
        //        em.persist(guest);
//        em.persist(guest2);
//        em.persist(guest3);
//        em.persist(guestAddress);
        User user = new User("Kane", "Kabal", 18);

        tx.begin();
        em.persist(user);
        tx.commit();
        System.out.println(em.contains(user));

        em.clear();
        user.setAge(33);
        System.out.println(em.contains(user));

        tx.begin();
        em.merge(user);
        tx.commit();


        em.close();
        managerFactory.close();
    }
}
