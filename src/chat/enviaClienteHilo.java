package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hilo encargado de leer la entrada del teclado del cliente y enviarla al
 * servidor.
 */
public class enviaClienteHilo extends Thread {
	private Socket socket;

	/**
	 * Constructor del hilo de envío del cliente.
	 *
	 * @param socket socket conectado al servidor; se usará para obtener el flujo de
	 *               salida
	 */

	public enviaClienteHilo(Socket socket) {
		this.socket = socket;
	}

	/**
	 * Bucle principal del hilo de envío del cliente.
	 * <p>
	 * Lee líneas desde {@link java.lang.System#in} y las envía al servidor
	 * escribiéndolas en el {@link java.io.PrintWriter} ligado al socket. El bucle
	 * es infinito hasta que se produce una excepción de E/S (por ejemplo, cierre
	 * del socket) o se termina el programa.
	 *
	 * Recursos cerrados automáticamente dentro del try-with-resources: -
	 * {@link java.io.PrintWriter} asociado al
	 * {@link java.net.Socket#getOutputStream()} - {@link java.util.Scanner} para la
	 * lectura desde System.in
	 *
	 * <p><b>Nota de implementación:</b> No está preparado para varios clientes compartiendo el mismo
	 *           teclado.
	 */

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