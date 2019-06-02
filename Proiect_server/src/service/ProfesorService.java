/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ProfesorDao;
import db.Profesor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rmi.IProfesorService;

/**
 *
 * 
 */
public class ProfesorService extends UnicastRemoteObject implements IProfesorService{
    private EntityManagerFactory emf;
    
    public ProfesorService()throws RemoteException{
        emf = Persistence.createEntityManagerFactory("Proiect_serverPU");
    }

    @Override
    public void adaugaProfesor(Profesor p) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        ProfesorDao profesorDao = new ProfesorDao(em);
        
        em.getTransaction().begin();
        profesorDao.adaugaProfesor(p);
        em.getTransaction().commit();
        
        em.close();
    }

    @Override
    public Profesor findById(long id) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        ProfesorDao profesorDao = new ProfesorDao(em);
        
        Profesor p = profesorDao.findById(id);
        
        em.close();
        return p;
    }

    @Override
    public Profesor findByNumePrenume(String nume, String prenume) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        ProfesorDao profesorDao = new ProfesorDao(em);
        
        Profesor p = profesorDao.findByNumePrenume(nume,prenume);
        
        em.close();
        return p;
    }

    @Override
    public List<Profesor> getAll() throws RemoteException {
        EntityManager em = emf.createEntityManager();
        ProfesorDao profesorDao = new ProfesorDao(em);
        
        List<Profesor> p = profesorDao.getAll();
        
        em.close();
        return p;
    }
}

