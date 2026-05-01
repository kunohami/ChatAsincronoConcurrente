package chat;

import java.net.Socket;

/**
 * Hilo que gestiona la comunicación con un único cliente.
 * <p>
 * Al ejecutarse crea y arranca los hilos de envío y recepción para el socket de
 * cliente asociado: {@link enviaServerHilo} y {@link recibeServerHilo}. Estos
 * sub-hilos permiten I/O asíncrono (full-duplex) con ese cliente.
 *
 * <p><b>Nota de implementación:</b> Esta clase delega la lectura del teclado al hilo de envío del
 *           servidor.
 */

public class serverHilo extends Thread {
	private Socket socket;

	/**
	 * Constructor que recibe el socket del cliente.
	 * 
	 * @param socket Socket conectado al cliente.
	 */
	public serverHilo(Socket socket) {
		this.socket = socket;
	}

	/**
	 * Hilo que gestiona la comunicación con un único cliente.
	 * <p>
	 * Al ejecutarse crea y arranca los hilos de envío y recepción para el socket de
	 * cliente asociado: {@link enviaServerHilo} y {@link recibeServerHilo}. Estos
	 * sub-hilos permiten I/O asíncrono (full-duplex) con ese cliente.
	 *
	 * <p><b>Nota de implementación:</b> Esta clase delega la lectura del teclado al hilo de envío del
	 *           servidor.
	 */

	@Override
	public void run() {
		// Instanciamos y arrancamos los hilos de envío y recepción
		enviaServerHilo hiloEnvio = new enviaServerHilo(socket);
		recibeServerHilo hiloRecepcion = new recibeServerHilo(socket);

		hiloEnvio.start();
		hiloRecepcion.start();
	}
}