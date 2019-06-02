/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import db.Elev;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * 
 */
public interface IElevService extends Remote{
    public void adaugaElev(Elev e) throws RemoteException;
    public Elev findById(long id) throws RemoteException;
    public List<Elev> getAll() throws RemoteException;
    public Elev findByNumePrenume(String nume, String prenume) throws RemoteException;
}
