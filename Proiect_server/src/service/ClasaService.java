/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ClasaDao;
import db.Clasa;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rmi.IClasaService;

/**
 *
 * 
 */
public class ClasaService extends UnicastRemoteObject implements IClasaService{

    private EntityManagerFactory emf;
    
    public ClasaService() throws RemoteException{
        emf = Persistence.createEntityManagerFactory("Proiect_serverPU"); 
    }
    
    @Override
    public void adaugaClasa(Clasa c) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        ClasaDao clasaDao = new ClasaDao(em);
        
        em.getTransaction().begin();
        clasaDao.adaugaClasa(c);
        em.getTransaction().commit();
        
        em.close();
    }

    @Override
    public List<Clasa> getAll() throws RemoteException {
        EntityManager em = emf.createEntityManager();
        ClasaDao clasaDao = new ClasaDao(em);
        
        List<Clasa> c = clasaDao.getAll();
        em.close();
        return c;
    }

    
    
}
