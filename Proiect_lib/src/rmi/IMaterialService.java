/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import db.Elev;
import db.Material;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * 
 */
public interface IMaterialService extends Remote{
    public void adaugaMaterial(Material m) throws RemoteException;
    public List<Material> getAll() throws RemoteException;
    public List<Material> getAllForElev(Elev e) throws RemoteException;
    public Material findById(int id) throws RemoteException;
}
