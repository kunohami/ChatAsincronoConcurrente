import java.net.Socket;

/**
 * Hilo principal del servidor para un cliente específico.
 * Su responsabilidad es arrancar los hilos asíncronos de envío y recepción.
 */
public class serverHilo extends Thread {
    private Socket socket;

    /**
     * Constructor que recibe el socket del cliente.
     * @param socket Socket conectado al cliente.
     */
    public serverHilo(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Instanciamos y arrancamos los hilos de envío y recepción
        enviaServerHilo hiloEnvio = new enviaServerHilo(socket);
        recibeServerHilo hiloRecepcion = new recibeServerHilo(socket);
        
        hiloEnvio.start();
        hiloRecepcion.start();
    }
}