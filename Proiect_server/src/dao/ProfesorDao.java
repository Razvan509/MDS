/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Profesor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * 
 */
public class ProfesorDao {
    private EntityManager em;
    
    public ProfesorDao(EntityManager em){
        this.em = em;
    }
    
    public void adaugaProfesor(Profesor p){
        em.persist(p);
    }
    
    public Profesor findById(long id){
        Query q = em.createQuery("SELECT p FROM Profesor p where p.id = :id");
        q.setParameter("id", id);
        
        Profesor p = (Profesor)q.getSingleResult();
        return p;
    }
    
    public Profesor findByNumePrenume(String nume, String prenume){
        Query q = em.createQuery("SELECT p FROM Profesor p WHERE p.nume = :nume AND p.prenume = :prenume");
        q.setParameter("nume",nume);
        q.setParameter("prenume",prenume);
        Profesor p = (Profesor) q.getSingleResult();
        return p;
    }
    
    public List<Profesor> getAll(){
        Query q = em.createQuery("SELECT p FROM Profesor p");
        List<Profesor> p = (List<Profesor>) q.getResultList();
        return p;
    }
}
