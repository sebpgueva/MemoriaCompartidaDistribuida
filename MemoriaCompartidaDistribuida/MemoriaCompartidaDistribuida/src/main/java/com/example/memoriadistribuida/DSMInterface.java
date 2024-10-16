package com.example.memoriadistribuida;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DSMInterface extends Remote {
    int leer(String key) throws RemoteException;
    void escribir(String key, int value) throws RemoteException;
    void lock(String key) throws RemoteException;
    void unlock(String key) throws RemoteException;
}
