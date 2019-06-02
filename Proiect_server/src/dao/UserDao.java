/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.User;
import javax.persistence.EntityManager;

/**
 *
 * @author Razvan
 */
public class UserDao {
    private EntityManager em;
    
    public UserDao(EntityManager em){
        this.em = em;
    }
    
    public void adaugaUser(User u){
        em.persist(u);
    }
}
