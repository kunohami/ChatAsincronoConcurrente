package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase principal del servidor.
 * Se encarga de abrir el puerto y esperar la conexión del cliente.
 */
public class server {
    public static void main(String[] args) {
        int puerto = 5000;
        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor a la escucha en el puerto " + puerto + "...");
            
            // Se queda bloqueado hasta que un cliente se conecta
            Socket socketCliente = serverSocket.accept();
            System.out.println("¡Cliente conectado desde " + socketCliente.getInetAddress() + "!");
            
            // Lanzamos el hilo que gestionará a este cliente
            serverHilo gestionCliente = new serverHilo(socketCliente);
            gestionCliente.start();
            
        } catch (IOException e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }
}