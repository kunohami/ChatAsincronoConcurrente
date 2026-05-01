package chat;

import java.io.IOException;
import java.net.Socket;

/**
 * Punto de entrada para el cliente de chat.
 * <p>
 * Establece una conexión TCP con el servidor y arranca dos hilos: uno para
 * enviar (lectura de teclado) y otro para recibir mensajes.
 *
 * @param args argumentos de la línea de comandos (no usados)
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