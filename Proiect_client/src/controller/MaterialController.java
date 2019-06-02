/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.Elev;
import db.Material;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import javax.swing.JOptionPane;
import rmi.IMaterialService;

/**
 *
 * 
 */
public class MaterialController {
    private IMaterialService materialService;
    private static MaterialController instance;
    
    private MaterialController(){
        
        try{
            Registry registry = LocateRegistry.getRegistry("localhost",4444);
            materialService = (IMaterialService) registry.lookup("MaterialService");
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Eroare la conectare");
        }
    }
    
    public static MaterialController getInstance(){
        if(instance == null) instance = new MaterialController();
        return instance;
    }
    
    public void adaugaMaterial(Material c) throws RemoteException{
        materialService.adaugaMaterial(c);
    }
    
    public List<Material> getAll() throws RemoteException{
        return materialService.getAll();
    }
    
    public List<Material> getAllForElev(Elev e) throws RemoteException{
        return materialService.getAllForElev(e);
    }
    
    public Material findById(int id)throws RemoteException{
        return materialService.findById(id);
    }
}
