# RA3. Programa mecanismos de comunicación en red empleando sockets y analizando el escenario de ejecución.

| CE | Calificación |
| :--- | :--- |
| **h)** Se han utilizado hilos para posibilitar la comunicación simultánea de varios clientes con el servidor | |
| **i)** Se han caracterizado los modelos de comunicación más usuales en las arquitecturas de aplicaciones distribuidas | |
| **j)** Se han depurado y documentado las aplicaciones desarrolladas | |
| **k)** Se ha realizado control de versiones en el código generado | |
| **l)** Se ha utilizado una metodología para la planificación, asignación y desarrollo de las funcionalidades generadas | |
| **m)** Desarrolla aplicaciones que ofrecen servicios en red, utilizando librerías de clases y aplicando criterios de eficiencia y disponibilidad | |

"Chat Asíncrono":

* Desarrolla un programa Java para crear un chat asíncrono utilizando sockets con TCP. 
* Constará de un servidor que espera conexiones de un cliente.
* Para realizar el intercambio de información en vez de emplear sentencias que dicten el orden en el que ambos extremos, servidor y cliente, tengan que elaborar los mensajes y enviarlos lo que se utilizará desde cada extremo son dos hilos: uno para el envío de datos y otro para la recepción de datos. 
* El hilo encargado de la recepción de datos estará permanentemente esperando datos del otro equipo y mostrándolos por pantalla y el hilo encargado del envío de datos estará permanentemente leyendo datos de la entrada estándar y enviándolas al otro extremo.
* Tanto servidor como cliente tienen el mismo funcionamiento respecto al intercambio de datos, la diferencia está en que primero hay que configurar el servidor y ponerlo a la escucha y después el cliente debe realizar la conexión al servidor.

