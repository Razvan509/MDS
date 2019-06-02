/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Elev;
import db.Profesor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * 
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
    
    public List<Elev> getAll(){
        Query q = em.createQuery("SELECT e FROM Elev e");
        List<Elev> elevi = (List<Elev>)q.getResultList();
        return elevi;
    }
    
    public Elev findByNumePrenume(String nume, String prenume){
        Query q = em.createQuery("SELECT e FROM Elev e WHERE e.nume = :nume AND e.prenume = :prenume");
        q.setParameter("nume",nume);
        q.setParameter("prenume",prenume);
        Elev e = (Elev) q.getSingleResult();
        return e;
    }
}
