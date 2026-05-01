package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hilo encargado de leer la entrada del teclado del servidor y enviarla al
 * cliente.
 */
public class enviaServerHilo extends Thread {
	private Socket socket;

	/**
	 * Constructor del hilo de envío del servidor para un cliente concreto.
	 *
	 * @param socket socket conectado al cliente; se usará para obtener el flujo de
	 *               salida
	 */

	public enviaServerHilo(Socket socket) {
		this.socket = socket;
	}

	/**
	 * Bucle principal del hilo de envío del servidor.
	 * <p>
	 * Lee líneas desde {@link java.lang.System#in} (teclado del servidor) y las
	 * envía al cliente asociado mediante {@link java.io.PrintWriter} ligado al
	 * socket.
	 *
	 * <p><b>Nota de implementación:</b> No está preparado para un servidor con múltiples clientes
	 */

	@Override
	public void run() {
		try (PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
				Scanner teclado = new Scanner(System.in)) {

			String mensaje;
			while (true) {
				mensaje = teclado.nextLine(); // Lee del teclado
				salida.println(mensaje); // Envía por el socket
			}
		} catch (IOException e) {
			System.err.println("Error en el hilo de envío del servidor: " + e.getMessage());
		}
	}
}