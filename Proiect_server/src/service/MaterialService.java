/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MaterialDao;
import db.Elev;
import db.Material;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rmi.IMaterialService;

/**
 *
 * 
 */
public class MaterialService extends UnicastRemoteObject implements IMaterialService{
    private EntityManagerFactory emf;
    
    public MaterialService()throws RemoteException{
        emf = Persistence.createEntityManagerFactory("Proiect_serverPU");
    }

    @Override
    public void adaugaMaterial(Material m) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        MaterialDao materialDao = new MaterialDao(em);
        
        em.getTransaction().begin();
        materialDao.adaugaMaterial(m);
        em.getTransaction().commit();
        
        em.close();
    }

    @Override
    public List<Material> getAll() throws RemoteException {
        EntityManager em = emf.createEntityManager();
        MaterialDao materialDao = new MaterialDao(em);
        
        List<Material> m = materialDao.getAll();
        em.close();
        return m;
    }

    @Override
    public List<Material> getAllForElev(Elev e) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        MaterialDao materialDao = new MaterialDao(em);
        
        List<Material> m = materialDao.getAllForElev(e);
        em.close();
        return m;
    }

    @Override
    public Material findById(int id) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        MaterialDao materialDao = new MaterialDao(em);
        
        Material m = materialDao.findById(id);
        em.close();
        return m;
    }
}
