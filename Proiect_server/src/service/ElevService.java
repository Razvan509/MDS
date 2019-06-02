/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ElevDao;
import db.Elev;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rmi.IElevService;

/**
 *
 * 
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

    @Override
    public List<Elev> getAll() throws RemoteException {
        EntityManager em = emf.createEntityManager();
        ElevDao elevDao = new ElevDao(em);
        
        List<Elev> elevi = elevDao.getAll();
        em.close();
        return elevi;
    }

    @Override
    public Elev findByNumePrenume(String nume, String prenume) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        ElevDao elevDao = new ElevDao(em);
        
        Elev e = elevDao.findByNumePrenume(nume,prenume);
        em.close();
        return e;
    }

    

    
}
