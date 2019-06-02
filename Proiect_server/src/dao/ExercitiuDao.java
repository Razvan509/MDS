/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Exercitiu;
import db.Material;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * 
 */
public class ExercitiuDao {
    private EntityManager em;
    
    public ExercitiuDao(EntityManager em){
        this.em = em;
    }
    
    public void adaugaExercitiu(Exercitiu e){
        em.persist(e);
    }
    
    public List<Exercitiu> getExercitiiMaterial(Material m){
        Query q = em.createQuery("SELECT e FROM Exercitiu e WHERE e.material = :material");
        q.setParameter("material",m);
        List<Exercitiu> exercitii = (List<Exercitiu>) q.getResultList();
        return exercitii;
    }
}
