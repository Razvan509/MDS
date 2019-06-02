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
import javax.swing.JOptionPane;
import rmi.IElevService;

/**
 *
 * @author Razvan
 */
public class ElevController {
    private IElevService elevService;
    private static ElevController instance;
    
    public ElevController(){
        
        try{
            Registry registry = LocateRegistry.getRegistry("localhost",4444);
            elevService = (IElevService) registry.lookup("elevService");
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
}
