# Chat Asíncrono Cliente-Servidor en Java 💬

Este repositorio contiene la implementación de un chat asíncrono utilizando **Sockets TCP** en Java. 

[![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?style=flat&logo=openjdk&logoColor=white)](https://dev.java/)
[![Eclipse](https://img.shields.io/badge/Eclipse-%232C2255.svg?style=flat&logo=eclipseide&logoColor=white)](https://www.eclipse.org/)
[![Git](https://img.shields.io/badge/Git-%23F05033.svg?style=flat&logo=git&logoColor=white)](https://git-scm.com/)
[![GitHub](https://img.shields.io/badge/GitHub-%23181717.svg?style=flat&logo=github&logoColor=white)](https://github.com/)

## ✨ Sobre este proyecto

El programa permite la comunicación bidireccional en tiempo real entre dos terminales: un **Servidor** (que abre un puerto y espera conexiones) y un **Cliente** (que se conecta a dicho servidor). Ambos extremos funcionan de manera idéntica en cuanto al intercambio de datos.

## ⚡ ¿Por qué es un programa concurrente?

Este chat resuelve el problema de la comunicación bidireccional mediante el uso de la **programación concurrente** (multihilo). 

En un programa secuencial tradicional, las operaciones de entrada/salida son *bloqueantes*. Esto significa que si el programa está esperando a que el usuario escriba un mensaje por teclado, no puede recibir ni mostrar los mensajes que le envíe la otra persona al mismo tiempo (habría que comunicarse por turnos estrictos).

Para lograr una experiencia asíncrona real, tanto el Cliente como el Servidor delegan el trabajo en dos **hilos (Threads)** independientes que se ejecutan de forma simultánea:

- **Hilo de Envío (`enviaHilo`)**: Se dedica en exclusiva a leer la entrada del teclado del usuario y enviarla a través de la red de forma continua.
- **Hilo de Recepción (`recibeHilo`)**: Se dedica en exclusiva a escuchar el socket de red, esperando recibir mensajes del otro extremo para imprimirlos por pantalla inmediatamente.

Al usar estos hilos de manera separada, los usuarios pueden escribir y recibir múltiples mensajes al mismo tiempo sin que la aplicación se congele o pierda información.

## 📂 Estructura del Código

El proyecto respeta la siguiente separación de clases para mantener la lógica aislada:

-  **`server.java`**: Clase principal que inicia el servidor en el puerto 5000.
-  **`serverHilo.java`**: Gestiona la conexión de un cliente e instancia sus hilos.
-  **`recibeServerHilo.java` / `enviaServerHilo.java`**: Hilos de lectura y escritura del servidor.
-  **`client.java`**: Clase principal que conecta con el localhost:5000.
-  **`recibeClienteHilo.java` / `enviaClienteHilo.java`**: Hilos de lectura y escritura del cliente.

## 🚀 Cómo ejecutarlo

Para probar el chat localmente:

1. Compila los archivos `.java`.
2. Ejecuta primero la clase `server.java`. 
3. Ejecuta la clase `client.java`. 

### 💡 Para ver ambas consolas a la vez en Eclipse:
Ya que Eclipse agrupa las consolas, es difícil chatear cambiando de pestaña. Para solucionarlo:
1. Con una consola abierta, haz clic en el botón **Pin Console** (icono de chincheta verde).
2. Haz clic en **Open Console** (icono de monitor con un `+`) y selecciona **New Console View**.
3. En la nueva consola, usa el botón **Display Selected Console** para mostrar el programa que falta (servidor o cliente).
4. Haz clic en la pestaña de esta nueva consola y **arrástrala hacia la derecha o hacia abajo** para dividir la pantalla. 

---

## 🎯 Criterios de Evaluación y Tarea

### RA3. Programa mecanismos de comunicación en red empleando sockets y analizando el escenario de ejecución.
- [x] Utilizar hilos (threads) para permitir la comunicación simultánea y asíncrona entre cliente y servidor.
- [x] Comprender y aplicar los modelos de comunicación en arquitecturas distribuidas.
- [x] Depurar y documentar correctamente el código desarrollado utilizando Javadoc.
- [x] Realizar el control de versiones del código generado mediante Git.
- [x] Utilizar metodologías de planificación ágil (tableros Kanban) para la asignación y desarrollo de tareas.
- [x] Desarrollar servicios en red eficientes usando las librerías estándar de Java.

### 📝 Descripción de la tarea "Chat Asíncrono":
- Desarrolla un programa Java para crear un chat asíncrono utilizando sockets con TCP. 
- Constará de un servidor que espera conexiones de un cliente.
- Para realizar el intercambio de información en vez de emplear sentencias que dicten el orden en el que ambos extremos, servidor y cliente, tengan que elaborar los mensajes y enviarlos lo que se utilizará desde cada extremo son dos hilos: uno para el envío de datos y otro para la recepción de datos. 
- El hilo encargado de la recepción de datos estará permanentemente esperando datos del otro equipo y mostrándolos por pantalla y el hilo encargado del envío de datos estará permanentemente leyendo datos de la entrada estándar y enviándolas al otro extremo.
- Tanto servidor como cliente tienen el mismo funcionamiento respecto al intercambio de datos, la diferencia está en que primero hay que configurar el servidor y ponerlo a la escucha y después el cliente debe realizar la conexión al servidor.
