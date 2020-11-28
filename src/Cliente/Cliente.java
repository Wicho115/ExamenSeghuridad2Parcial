
package Cliente;



import Servidor.Servidor;
import exameninterfaz.ClienteInterfaz;
import java.net.*;
import java.io.*;
import java.util.*;

public class Cliente {

    Scanner entrada;
    Escribir hilo1;
    static int cantidadClientes;

    public Cliente(String nombre, ClienteInterfaz cl) {
        entrada = new Scanner(System.in);
        try {
            Socket skCliente = new Socket("10.129.199.45", 81);
            System.out.println("Tu nombre es: " + nombre);                                    
            hilo1 = new Escribir(skCliente, nombre, this);  //hilo que escribe se envía el nombre ingresado por el cliente y el socket 
            Leer hilo2 = new Leer(skCliente, cl);    //hilo que lee, se envía como parámetro el Socket				   skCliente.close();    
            
            /*System.out.println(Cliente.cantidadClientes);
            if(Cliente.cantidadClientes > 1){
                System.out.println("Se creo sa ya hecho");
                cl.CrearRSA(1);
            }else{
                System.out.println("Se creo rsa");
                cl.CrearRSA();
            }*/
            cl.CrearRSA();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void CerrarCliente() throws IOException{
        hilo1.TerminarConexion();
    }
    
    public void Escribir(String mensaje) throws IOException{
        hilo1.EnviarMensaje(mensaje);
    }

    
}