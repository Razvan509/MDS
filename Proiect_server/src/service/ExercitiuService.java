/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ExercitiuDao;
import db.Exercitiu;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
}
