package examples.Apartado2Apuntes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.ProcessBuilder.Redirect;

public class IntervalAditionLauncher {
    public static void main(String[] args) {
        try {
//Nuevo objeto lanzador
            IntervalAditionLauncher launcher = new IntervalAditionLauncher();
//Lanzamos un par de intervalos para su suma
            launcher.launch(1, 3);
            launcher.launch(1, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void launch(Integer n1, Integer n2) {
//Muestra por consola el inicio del proceso
        System.out.println("Start " + n1 + " to " + n2);
//Obtenemos la ruta dónde se encuentra la clase
        String classPath = System.getProperty("java.class.path");
//Nombre completo incluyendo el paquete de la clase que realiza la suma
        String className = "ud1.ejercicios.IntervalAddition";
//Creamos un nuevo proceso que ejecutará la clase de la suma
//Redirigimos la salida del proceso hijo al proceso padre
        java.lang.ProcessBuilder pb = new java.lang.ProcessBuilder("java", "-cp",
                classPath, className, n1.toString(), n2.toString()).redirectOutput(Redirect.INHERIT);
        try {
//Iniciamos el proceso
            pb.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}