package com.example.memoriadistribuida;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class DSMServer extends UnicastRemoteObject implements DSMInterface {

    private HashMap<String, Integer> memoria;
    private HashMap<String, ReentrantLock> locks;

    public DSMServer() throws RemoteException {
        memoria = new HashMap<>();
        locks = new HashMap<>();
    }

    @Override
    public synchronized int leer(String key) throws RemoteException {
        return memoria.getOrDefault(key, 0);
    }

    @Override
    public synchronized void escribir(String key, int value) throws RemoteException {
        memoria.put(key, value);
    }

    @Override
    public synchronized void lock(String key) throws RemoteException {
        locks.putIfAbsent(key, new ReentrantLock());
        locks.get(key).lock();
    }

    @Override
    public synchronized void unlock(String key) throws RemoteException {
        if (locks.containsKey(key)) {
            locks.get(key).unlock();
        }
    }
}
