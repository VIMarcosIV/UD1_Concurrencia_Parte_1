package examples.Apartado6Apuntes;

public class SleepMessages implements Runnable {
    public void run() {
// mensajes
        String importantInfo[] = {"Programas", "Procesos"

                , "Servicios", "Hilos"};

        for (int i = 0; i < importantInfo.length; i++) {
// Mostrar mensaje
            System.out.println(importantInfo[i]);
            try {
// Pausar 3 segundos
                Thread.sleep(3000);
            } catch (InterruptedException e) {
// Mostrar interrupción
                System.out.println("Hilo interrumpido");
            }
        }
        System.out.println("***Hilo finalizado***");
    }

    public static void main(String[] args) throws InterruptedException {
// Crear nuevo hilo
        Thread t = new Thread(new SleepMessages());
// Arrancar hilo
        t.start();
    }
}