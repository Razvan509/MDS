/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import db.Exercitiu;
import db.Material;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * 
 */
public interface IExercitiuService extends Remote{
    public void adaugaExercitiu(Exercitiu e) throws RemoteException;
    public List<Exercitiu> getExercitiiMaterial(Material m) throws RemoteException;
}
