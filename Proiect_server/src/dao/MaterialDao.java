/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Material;
import javax.persistence.EntityManager;

/**
 *
 * @author Razvan
 */
public class MaterialDao {
    private EntityManager em;
    
    public MaterialDao(EntityManager em){
        this.em = em;
    }
    
    public void adaugaMaterial(Material m){
        em.persist(m);
    }
}
