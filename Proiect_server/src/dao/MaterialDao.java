/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Elev;
import db.Material;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * 
 */
public class MaterialDao {
    private EntityManager em;
    
    public MaterialDao(EntityManager em){
        this.em = em;
    }
    
    public void adaugaMaterial(Material m){
        em.persist(m);
    }
    
    public List<Material> getAll(){
        Query q = em.createQuery("SELECT m FROM Material m");
        List<Material> m = (List<Material>)q.getResultList();
        return m;
    }
    
    public List<Material> getAllForElev(Elev e){ // iau toate materialele globale plus cele pe care le are din clasa de unde face parte
        Query tot = em.createQuery("SELECT m FROM Material m");
        Query clasa = em.createQuery("SELECT m FROM Material m WHERE m.idClasa = :clasa");
        clasa.setParameter("clasa",e.getClasa());
        List<Material> toate = (List<Material>)tot.getResultList();
        List<Material> cls = (List<Material>)clasa.getResultList();
        toate.addAll(cls);
        return toate;
    }
    
    public Material findById(int id){
        Query q = em.createQuery("SELECT m FROM Material m WHERE m.id = :id");
        q.setParameter("id",id);
        Material m = (Material) q.getSingleResult();
        return m;
    }
}
