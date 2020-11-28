package Servidor;

/*
 * @author Wicho
 */

import exameninterfaz.ClienteInterfaz;
import java.net.*;
import java.io.*;
import java.util.*;

public class Servidor {
    
    //static BigInteger
    ComunicacionClientes com;	// Objeto para hacer uso del proceso de lectura y escritura
    ArrayList<Socket> listaCliente = new ArrayList();

    public Servidor() {
        try {
            ServerSocket ss = new ServerSocket(81);
            Socket cliente;
            while (true) {
                cliente = ss.accept();
                System.out.println("Conexión exitosa");
                listaCliente.add(cliente);                       
                com = new ComunicacionClientes(listaCliente, cliente, this); //Creación de un proceso para intercambio de info con cada Cliente que se conecte
            }
            //ss.close();        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void TerminarConexioncliente(Socket s) {
        listaCliente.remove(s);
    }

    public static void main(String[] args) {
        new Servidor();
    }
}
