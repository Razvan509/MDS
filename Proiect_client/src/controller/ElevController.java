/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.Elev;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import javax.swing.JOptionPane;
import rmi.IElevService;

/**
 *
 * 
 */
public class ElevController {
    private IElevService elevService;
    private static ElevController instance;
    
    public ElevController(){
        
        try{
            Registry registry = LocateRegistry.getRegistry("localhost",4444);
            elevService = (IElevService) registry.lookup("ElevService");
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Eroare la conectare");
        }
    }
    
    public static ElevController getInstance(){
        if (instance==null){
            instance = new ElevController();
        }
        return instance;
    }
    
    public void adaugaElev(Elev e) throws RemoteException{
        elevService.adaugaElev(e);
    }
    
    public Elev findById(long id) throws RemoteException{
        return elevService.findById(id);
    }
    
    public List<Elev> getAll() throws RemoteException{
        return elevService.getAll();
    }
    
    public Elev findByNumePrenume(String nume, String prenume) throws RemoteException{
        return elevService.findByNumePrenume(nume, prenume);
    }
}
