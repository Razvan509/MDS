/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ExercitiuDao;
import db.Exercitiu;
import db.Material;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rmi.IExercitiuService;

/**
 *
 * 
 */
public class ExercitiuService extends UnicastRemoteObject implements IExercitiuService{
    private EntityManagerFactory emf;
    
    public ExercitiuService()throws RemoteException{
        emf = Persistence.createEntityManagerFactory("Proiect_serverPU");
    }

    @Override
    public void adaugaExercitiu(Exercitiu e) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        ExercitiuDao exercitiuDao = new ExercitiuDao(em);
        
        em.getTransaction().begin();
        exercitiuDao.adaugaExercitiu(e);
        em.getTransaction().commit();
        
        em.close();
    }

    @Override
    public List<Exercitiu> getExercitiiMaterial(Material m) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        ExercitiuDao exercitiuDao = new ExercitiuDao(em);
        
        List<Exercitiu> exercitii = exercitiuDao.getExercitiiMaterial(m);
        em.close();
        return exercitii;
    }
}
