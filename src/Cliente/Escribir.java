package Cliente;

/*
 * @author Wicho
 */

import exameninterfaz.ClienteInterfaz;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

class Escribir {

    Socket socket;
    String name;
    Scanner entrada;
    Cliente cliente;

    Escribir(Socket socket, String name, Cliente cliente) {      //Recibe objeto de tipo Socket para identificar el Socket que está ejecutando el proceso y
        // en el parámetro name recibirá como el cliente desea ser nombrado
        entrada = new Scanner(System.in);  //Objeto para recibir datos desde teclado
        this.socket = socket;
        this.name = name;
        this.cliente = cliente;
    }
    
    //Metodo par cerrar la conexion por fuera de la clase
    protected void TerminarConexion() throws IOException{
        EnviarMensaje("$Salir#");
    }
    
    //Metodo para enviar mensaje
    protected void EnviarMensaje(String mensaje) throws IOException{
        OutputStream os = socket.getOutputStream();
        DataOutputStream flujoDOS = new DataOutputStream(os);
        if(!"$Salir#".equals(mensaje)){
            flujoDOS.writeUTF(mensaje);
        }else{
            flujoDOS.writeUTF(mensaje);
        }
    }
}


