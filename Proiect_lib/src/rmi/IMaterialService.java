/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import db.Material;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Razvan
 */
public interface IMaterialService extends Remote{
    public void adaugaMaterial(Material m) throws RemoteException;
}
