package com.example.memoriadistribuida;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            DSMServer server = new DSMServer();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("DSM", server);
            System.out.println("Servidor listo...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
