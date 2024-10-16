package com.example.memoriadistribuida;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            DSMInterface dsm = (DSMInterface) registry.lookup("DSM");

            dsm.lock("recurso1");

            int valor = dsm.leer("recurso1");
            System.out.println("Valor inicial: " + valor);

            dsm.escribir("recurso1", valor + 1);

            valor = dsm.leer("recurso1");
            System.out.println("Nuevo valor: " + valor);

            dsm.unlock("recurso1");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
