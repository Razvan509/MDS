/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Clasa;
import javax.persistence.EntityManager;

/**
 *
 * @author Razvan
 */
public class ClasaDao {
    private EntityManager em;
    
    public ClasaDao(EntityManager em){
        this.em = em;
    }
    
    public void adaugaClasa(Clasa c){
        em.persist(c);
    }
    
    
}
