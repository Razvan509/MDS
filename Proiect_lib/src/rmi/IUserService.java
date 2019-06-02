/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import db.User;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * 
 */
public interface IUserService extends Remote{
    public void adaugaUser(User u) throws RemoteException;
    public User findByUserPass(String user,String pass) throws RemoteException;
}
