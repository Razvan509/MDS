/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import db.Clasa;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * 
 */
public interface IClasaService extends Remote{
    public void adaugaClasa(Clasa c) throws RemoteException;
    public List<Clasa> getAll() throws RemoteException;
}
