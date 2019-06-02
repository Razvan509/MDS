/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ElevDao;
import dao.ProfesorDao;
import db.Elev;
import db.Profesor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rmi.IElevService;

/**
 *
 * @author Razvan
 */
public class ElevService extends UnicastRemoteObject implements IElevService{

    private EntityManagerFactory emf;
    
    public ElevService() throws RemoteException{
        emf = Persistence.createEntityManagerFactory("Proiect_serverPU"); 
    }
    
    @Override
    public void adaugaElev(Elev e) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        ElevDao elevDao = new ElevDao(em);
        
        em.getTransaction().begin();
        elevDao.adaugaElev(e);
        em.getTransaction().commit();
        
        em.close();
    }

    @Override
    public Elev findById(long id) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        ElevDao elevDao = new ElevDao(em);
        
        Elev e = elevDao.findById(id);
        em.close();
        return e;
    }

    

    
}
