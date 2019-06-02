/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDao;
import db.User;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rmi.IUserService;

/**
 *
 * 
 */
public class UserService extends UnicastRemoteObject implements IUserService{

    
    private EntityManagerFactory emf;
    
    public UserService() throws RemoteException{
        emf = Persistence.createEntityManagerFactory("Proiect_serverPU"); 
    }
    
    
    @Override
    public void adaugaUser(User u) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        UserDao userDao = new UserDao(em);
        
        em.getTransaction().begin();
        userDao.adaugaUser(u);
        em.getTransaction().commit();
        
        em.close();
    }

    @Override
    public User findByUserPass(String user, String pass) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        UserDao userDao = new UserDao(em);
        
        User u = userDao.findByUserPass(user, pass);
        em.close();
        return u;
    }
    
    
    
}
