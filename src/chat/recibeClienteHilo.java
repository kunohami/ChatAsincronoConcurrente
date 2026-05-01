package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Hilo encargado de recibir mensajes del servidor y mostrarlos por pantalla.
 */
public class recibeClienteHilo extends Thread {
    private Socket socket;

    public recibeClienteHilo(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String mensaje;
            while ((mensaje = entrada.readLine()) != null) {
                System.out.println("Servidor dice: " + mensaje);
            }
        } catch (IOException e) {
            System.out.println("Conexión finalizada con el servidor.");
        }
    }
}