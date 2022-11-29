package examples.Apartado7Apuntes;

import java.util.concurrent.CountDownLatch;

public class CountDownUsage implements Runnable {
    // mensaje a escribir por el proceso
    private String msg;
    // countDownLatch para controlar la ejecución de cada fase
    private CountDownLatch countDown;

    // constructor
    public CountDownUsage(String msg, CountDownLatch countDown) {
        this.msg = msg;
        this.countDown = countDown;
    }

    public static void main(String[] args) {
        System.out.println("*** the beginning ***");
// creamos nuestro pestillo que se activará tras
// la ejecución de un hilo en la fase 1

// "hello"
        final CountDownLatch countDownPhase1 = new CountDownLatch(1);
// creamos nuestro pestillo que se activará tras
// la ejecución de un hilo en la fase 2

// "world"
        final CountDownLatch countDownPhase2 = new CountDownLatch(1);
// declaramos y lanzamos el proceso P1: hello
        new Thread(new CountDownUsage("Hello ", countDownPhase1)).start();
// declaramos el proceso P2: world
        Thread t2 = new Thread(new CountDownUsage(" world!", countDownPhase2));
        try {
// esperamos a la finalización de la fase 1

// antes de lanzar la segunda
            countDownPhase1.await();
            t2.start();
            countDownPhase2.await();
            System.out.print("\n");
            System.out.println("*** the end ***");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.print(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDown.countDown();
    }
}