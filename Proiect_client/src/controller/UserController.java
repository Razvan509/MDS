/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.User;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
import rmi.IUserService;

/**
 *
 * @author Razvan
 */
public class UserController {
    private IUserService userService;
    private static UserController instance;
    
    public UserController(){
        
        try{
            Registry registry = LocateRegistry.getRegistry("localhost",4444);
            userService = (IUserService) registry.lookup("UserService");
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Eroare la conectare");
        }
    }
    
    public static UserController getInstance(){
        if (instance==null){
            instance = new UserController();
        }
        return instance;
    }
    
    public void adaugaUser(User u) throws RemoteException{
        userService.adaugaUser(u);
    }
}
