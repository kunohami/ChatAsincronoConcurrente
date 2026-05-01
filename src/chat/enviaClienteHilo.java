package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hilo encargado de leer la entrada del teclado del cliente y enviarla al servidor.
 */
public class enviaClienteHilo extends Thread {
    private Socket socket;

    public enviaClienteHilo(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             Scanner teclado = new Scanner(System.in)) {
            
            String mensaje;
            while (true) {
                mensaje = teclado.nextLine();
                salida.println(mensaje);
            }
        } catch (IOException e) {
            System.err.println("Error en el hilo de envío del cliente: " + e.getMessage());
        }
    }
}