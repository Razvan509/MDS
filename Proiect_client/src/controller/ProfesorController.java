/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.Profesor;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
import rmi.IProfesorService;

/**
 *
 * @author Razvan
 */
public class ProfesorController {
    private IProfesorService profesorService;
    private static ProfesorController instance;
    
    public ProfesorController(){
        
        try{
            Registry registry = LocateRegistry.getRegistry("localhost",4444);
            profesorService = (IProfesorService) registry.lookup("ProfesorService");
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Eroare la conectare");
        }
    }
    
    public static ProfesorController getInstance(){
        if (instance==null){
            instance = new ProfesorController();
        }
        return instance;
    }
    
    public void adaugaProfesor(Profesor c) throws RemoteException{
        profesorService.adaugaProfesor(c);
    }
    
    public Profesor findById(long id) throws RemoteException{
        return profesorService.findById(id);
    }
    
    public Profesor findByNumePrenume(String nume, String prenume) throws RemoteException{
        return profesorService.findByNumePrenume(nume, prenume);
    }
}
