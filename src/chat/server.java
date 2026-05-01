package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Punto de entrada para el servidor de chat.
 * <p>
 * Abre un {@link java.net.ServerSocket} en el puerto configurado y espera
 * conexiones entrantes. Para cada conexión aceptada lanza un hilo
 * (`serverHilo`) que gestiona la comunicación con ese cliente.
 *
 * Nota: la versión actual del `main` acepta sólo una conexión, pero el objetivo
 * no era hacer un chat concurrente para varios clientes, sino concurrente para
 * el envío de mensajes.
 *
 * @param args argumentos de la línea de comandos (no usados)
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