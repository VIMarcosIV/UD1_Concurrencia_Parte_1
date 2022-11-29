package examples.Apartado7Apuntes;

import java.util.concurrent.Semaphore;

public class SemaphoreUsage implements Runnable {
    // Número de procesos disponibles
    private static final int AVAILABLE_THREADS = 4;
    // Semáforo, incluye el número de procesos en paralelo
    private static final Semaphore semafore = new Semaphore(AVAILABLE_THREADS);
    // Nombre del proceso
    private final String name;

    // el constructor recibe el nombre del proceso
    public SemaphoreUsage(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
// pedimos permiso al semáforo para continuar
            semafore.acquire();
            System.out.println("Executing process: " + name);
// código que ejecutaría nuestro proceso
            Thread.sleep(1000);
            System.out.println("End: " + name);
// liberamos el semáforo al terminar
            semafore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
// lanzamos 20 procesos
        for (int i = 0; i < 20; i++) {
            new Thread(new SemaphoreUsage(Integer.toString(i + 1))).start();
        }
    }
}