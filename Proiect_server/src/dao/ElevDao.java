/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Elev;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Razvan
 */
public class ElevDao {
    private EntityManager em;
    
    public ElevDao(EntityManager em){
        this.em = em;
    }
    
    public void adaugaElev(Elev e){
        em.persist(e);
    }
    
    public Elev findById(long id){
        Query q = em.createQuery("SELECT e FROM Elev e where e.id = :id");
        q.setParameter("id", id);
        
        Elev e = (Elev)q.getSingleResult();
        return e;
    }
}
