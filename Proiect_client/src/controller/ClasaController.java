/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.Clasa;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
import rmi.IClasaService;

/**
 *
 * @author Razvan
 */
public class ClasaController {
    private IClasaService clasaService;
    private static ClasaController instance;
    
    private ClasaController(){
        
        try{
            Registry registry = LocateRegistry.getRegistry("localhost",4444);
            clasaService = (IClasaService) registry.lookup("ClasaService");
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Eroare la conectare");
        }
    }
    
    public static ClasaController getInstance(){
        if (instance==null){
            instance = new ClasaController();
        }
        return instance;
    }
    
    public void adaugaClasa(Clasa c) throws RemoteException{
        clasaService.adaugaClasa(c);
    }
}
