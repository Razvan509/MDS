/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Exercitiu;
import javax.persistence.EntityManager;

/**
 *
 * @author Razvan
 */
public class ExercitiuDao {
    private EntityManager em;
    
    public ExercitiuDao(EntityManager em){
        this.em = em;
    }
    
    public void adaugaExercitiu(Exercitiu e){
        em.persist(e);
    }
}
