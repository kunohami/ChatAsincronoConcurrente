package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Hilo encargado de recibir constantemente mensajes del cliente y mostrarlos
 * por pantalla.
 */
public class recibeServerHilo extends Thread {
	private Socket socket;

	/**
	 * Constructor del hilo de recepción del servidor para un cliente concreto.
	 *
	 * @param socket socket conectado al cliente; se usará para obtener el flujo de
	 *               entrada
	 */

	public recibeServerHilo(Socket socket) {
		this.socket = socket;
	}

	/**
	 * Bucle principal del hilo de recepción del servidor.
	 * <p>
	 * Lee continuamente líneas desde el flujo de entrada del cliente y las muestra
	 * por consola con prefijo "Cliente dice: ". Finaliza cuando el cliente cierra
	 * la conexión o se produce una excepción de E/S.
	 *
	 * Recursos cerrados automáticamente dentro del try-with-resources: -
	 * {@link java.io.BufferedReader} ligado al
	 * {@link java.net.Socket#getInputStream()}
	 */

	@Override
	public void run() {
		try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
			String mensaje;
			while ((mensaje = entrada.readLine()) != null) {
				System.out.println("Cliente dice: " + mensaje);
			}
		} catch (IOException e) {
			System.out.println("Conexión finalizada con el cliente.");
		}
	}
}