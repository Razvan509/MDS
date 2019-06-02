/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import db.Material;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rmi.IMaterialService;

/**
 *
 * @author Razvan
 */
public class MaterialService extends UnicastRemoteObject implements IMaterialService{
    private EntityManagerFactory emf;
    
    public MaterialService()throws RemoteException{
        emf = Persistence.createEntityManagerFactory("Proiect_serverPU");
    }

    @Override
    public void adaugaMaterial(Material m) throws RemoteException {
    
    }
}
