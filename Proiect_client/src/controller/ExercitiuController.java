/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.Exercitiu;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
import rmi.IExercitiuService;

/**
 *
 * 
 */
public class ExercitiuController {
    private IExercitiuService exercitiuService;
    
    public ExercitiuController(){
        
        try{
            Registry registry = LocateRegistry.getRegistry("localhost",4444);
            exercitiuService = (IExercitiuService) registry.lookup("ExercitiuService");
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Eroare la conectare");
        }
    }
    
    public void adaugaExercitiu(Exercitiu e) throws RemoteException{
        exercitiuService.adaugaExercitiu(e);
    }
}
