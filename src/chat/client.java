package chat;

import java.io.IOException;
import java.net.Socket;

/**
 * Clase principal del cliente.
 * Conecta con el servidor y arranca sus propios hilos asíncronos.
 */
public class client {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 5000;
        
        try {
            Socket socket = new Socket(host, puerto);
            System.out.println("Conectado al servidor en " + host + ":" + puerto);
            
            // El cliente arranca sus hilos directamente
            enviaClienteHilo hiloEnvio = new enviaClienteHilo(socket);
            recibeClienteHilo hiloRecepcion = new recibeClienteHilo(socket);
            
            hiloEnvio.start();
            hiloRecepcion.start();
            
        } catch (IOException e) {
            System.err.println("No se pudo conectar al servidor: " + e.getMessage());
        }
    }
}