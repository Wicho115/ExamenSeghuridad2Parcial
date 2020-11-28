package Cliente;

/*
 * @author Wicho
 */

import exameninterfaz.ClienteInterfaz;
import java.net.*;
import java.io.*;

class Leer extends Thread // Creamos Hilo heredando de la clase Thread
{

    Socket socket;
    ClienteInterfaz cl;

    Leer(Socket socket, ClienteInterfaz cl) // Recibe un objeto Socket para indicar qué Socket esta ligado a este proceso
    {
        this.socket = socket;
        this.cl = cl;
        start();   //Iniciar el proceso
    }

    public void run() {
        try {
            while (true) {     //bucle infinito para lectura
                InputStream aux = socket.getInputStream();
                DataInputStream flujo = new DataInputStream(aux);
                String mensaje = flujo.readUTF();
                
                //Intento de operador ternario fallido unu
                /*
                    mensaje = (mensaje.startsWith("/$_")) ? mensaje.replaceFirst("/$_", "") : mensaje;
                */
                
                if(!mensaje.startsWith("/$_")){
                    if(mensaje.startsWith("/*d*/")){
                        mensaje = mensaje.replace("/*d*/", "");
                        cl.AsignarD(mensaje);
                    }else if(mensaje.startsWith("/*N*/")){
                        mensaje = mensaje.replace("/*N*/", "");
                        cl.AsignarN(mensaje);
                    }else{
                        cl.RecibirTexto(mensaje);
                    }                    
                }else{
                    mensaje = mensaje.replace("/$_", "");
                    if(mensaje.startsWith("/*d*/")){
                        mensaje = mensaje.replace("/*d*/", "");
                        cl.AsignarD(mensaje);
                    }else if(mensaje.startsWith("/*N*/")){
                        mensaje = mensaje.replace("/*N*/", "");
                        cl.AsignarN(mensaje);
                    }else{
                        cl.RecibirTexto(mensaje, 1);
                    }                    
                }                                
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}