import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hilo encargado de leer la entrada del teclado del servidor y enviarla al cliente.
 */
public class enviaServerHilo extends Thread {
    private Socket socket;

    public enviaServerHilo(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             Scanner teclado = new Scanner(System.in)) {
            
            String mensaje;
            while (true) {
                mensaje = teclado.nextLine(); // Lee del teclado
                salida.println(mensaje);      // Envía por el socket
            }
        } catch (IOException e) {
            System.err.println("Error en el hilo de envío del servidor: " + e.getMessage());
        }
    }
}