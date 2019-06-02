/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Clasa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * 
 */
public class ClasaDao {
    private EntityManager em;
    
    public ClasaDao(EntityManager em){
        this.em = em;
    }
    
    public void adaugaClasa(Clasa c){
        em.persist(c);
    }
    
    public List<Clasa> getAll(){
        Query q = em.createQuery("SELECT c FROM Clasa c");
        List<Clasa> clase = (List<Clasa>) q.getResultList();
        return clase;
    }
    
    
}
