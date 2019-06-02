/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.User;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * 
 */
public class UserDao {
    private EntityManager em;
    
    public UserDao(EntityManager em){
        this.em = em;
    }
    
    public void adaugaUser(User u){
        em.persist(u);
    }
    
    public User findByUserPass(String user,String pass){
        Query q = em.createQuery("SELECT u FROM User u WHERE u.user = :user AND u.password = :pass");
        q.setParameter("user", user);
        q.setParameter("pass", pass);
        User u = (User)q.getSingleResult();
        return u;
    }
}
