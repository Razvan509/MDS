/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.Material;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
import rmi.IMaterialService;

/**
 *
 * @author Razvan
 */
public class MaterialController {
    private IMaterialService materialService;
    
    public MaterialController(){
        
        try{
            Registry registry = LocateRegistry.getRegistry("localhost",4444);
            materialService = (IMaterialService) registry.lookup("MaterialService");
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Eroare la conectare");
        }
    }
    
    public void adaugaMaterial(Material c) throws RemoteException{
        materialService.adaugaMaterial(c);
    }
}
