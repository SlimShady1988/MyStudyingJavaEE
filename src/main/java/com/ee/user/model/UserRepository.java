package com.ee.user.model;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class UserRepository {
    @PersistenceContext(unitName = "bnvJTA")
    EntityManager entityManager;

    public void createUser(User user) {
        entityManager.persist(user);
    }

    public User readUser(int id) {return entityManager.find(User.class, id, LockModeType.PESSIMISTIC_WRITE);}

    public void updateUser(int id, String name, String surname, int age) {
        User user = this.readUser(id);
        user.setName(name);
        user.setSurname(surname);
        user.setAge(age);
    }

    public void removeUser(int id) {
        User user = this.readUser(id);
        entityManager.remove(user);
    }
    public List jpqlSelect() {
        Query query = entityManager.createQuery("select users from User users");
        List <User> list =query.getResultList();
        return list;
    }
    public List jpqlcreate() {
        Query query = entityManager.createQuery("select new User(users.name,users.surname, users.age) from User users where users.id = 11");
        List <User> list =query.getResultList();
        return list;
    }
//    public String namedStoredEx(int id, int age) {
//        Query query = entityManager.createNamedStoredProcedureQuery("userSelect").setParameter("userId", id).setParameter("userAge", age);
//
//        return (String)query.getSingleResult();
//    }
    public void clearUserTable () {
        Query query = entityManager.createQuery("DELETE FROM User");
        query.executeUpdate();
    }

}
