/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import db.Profesor;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Razvan
 */
public interface IProfesorService extends Remote{
    public void adaugaProfesor(Profesor p) throws RemoteException;
    public Profesor findById(long id) throws RemoteException;
    public Profesor findByNumePrenume(String nume, String prenume) throws RemoteException;
}
