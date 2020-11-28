
package Servidor;

/*
 * @author Wicho
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ComunicacionClientes extends Thread { //Creamos proceso

    Socket socket;
    String mensaje;
    ArrayList<Socket> listaCliente;
    Servidor servidor;
    int cliente;

    ComunicacionClientes(ArrayList<Socket> lista, Socket socket, Servidor server) // Recibe el ArrayList de Sockets Cliente que actualmente se están atendiendo
    {
        this.listaCliente = lista;
        this.socket = socket;
        servidor = server;
        start();
    }

    public void run() {
        while (true) {   // Bucle infinito para lectura y escritura
            try {
                InputStream is = socket.getInputStream(); // Se abre flujo de lectura
                DataInputStream flujo = new DataInputStream(is);
                mensaje = flujo.readUTF();  // Permanece escuchando hasta que alguno de los clientes le envía un mensaje
                if ("$Salir#".equals(mensaje)) {
                    servidor.TerminarConexioncliente(socket);
                    listaCliente.remove(socket);
                } else {
                    for (int cont = 0; cont < listaCliente.size(); cont++) //Cuando recibe un mensaje, lo replica a todos los Clientes recorriendo el ArrayList de Sockets y escribe al flujo de cada uno de ellos
                    {
                        OutputStream os = listaCliente.get(cont).getOutputStream();
                        DataOutputStream flujoDOS = new DataOutputStream(os);
                        //flujoDOS.writeUTF(mensaje);
                        if (!listaCliente.get(cont).equals(socket)) {                            
                            flujoDOS.writeUTF(mensaje);
                        }else{
                            flujoDOS.writeUTF("/$_" + mensaje);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Error de comunicacion" + e);                
            }
        }
    }
}