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

	/**
	 * Constructor del hilo de recepción del cliente.
	 *
	 * @param socket socket conectado al servidor; se usará para obtener el flujo de
	 *               entrada
	 */

	public recibeClienteHilo(Socket socket) {
		this.socket = socket;
	}

	/**
	 * Bucle principal del hilo de recepción del cliente.
	 * <p>
	 * Lee continuamente líneas desde el flujo de entrada del socket y las muestra
	 * por consola con prefijo "Servidor dice: ". El bucle termina cuando
	 * {@code readLine()} devuelve {@code null} (cierre remoto) o se lanza una
	 * excepción de E/S.
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
				System.out.println("Servidor dice: " + mensaje);
			}
		} catch (IOException e) {
			System.out.println("Conexión finalizada con el servidor.");
		}
	}
}