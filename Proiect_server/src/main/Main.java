/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ClasaService;
import service.ElevService;
import service.ExercitiuService;
import service.MaterialService;
import service.ProfesorService;
import service.UserService;

/**
 *
 * 
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(4444);
            registry.rebind("ClasaService",new ClasaService());
            registry.rebind("ElevService",new ElevService());
            registry.rebind("ExercitiuService",new ExercitiuService());
            registry.rebind("MaterialService",new MaterialService());
            registry.rebind("ProfesorService",new ProfesorService());
            registry.rebind("UserService",new UserService());
        } catch (RemoteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        } catch(Exception e){
            System.exit(0);
        }
    }
    
}
