package com.example.ejercicio3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        final String MSG_INTRO = "Introduzca un valor para buscar entre los decimales de pi";
        final String RUTA_PI = "pi.txt";

        File fichero = new File(RUTA_PI);
        String pi = leerFichero(fichero);
        String valor = leer(MSG_INTRO);

        System.out.println(comprobarPi(pi, valor));
    }

    /**
     * Lee un fichero y lo convierte en un String, a partir de un array de bytes.
     * @param fichero el fichero a leer
     * @return el fichero convertido en String
     */
    public static String leerFichero(File fichero) {

        byte[] datos = null;
        String cadena = null;

        try (FileInputStream fis = new FileInputStream(fichero)) {
            datos = fis.readAllBytes();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        cadena = new String(datos);

        return cadena;

    }

    public static String leer(String msg) {
        Scanner sc = new Scanner(System.in);
        String cadena = "";

        System.out.println(msg);
        cadena = sc.nextLine();

        return cadena;
    }

    public static String comprobarPi(String pi, String valor) {

        final String ENCONTRADO = "\n\u001B[32mEl valor %s está entre los decimales del número pi\u001B[0m\n";
        final String NO_ENCONTRADO = "\n\u001B[31mEl valor %s no está entre los decimales del número pi\u001B[0m\n";

        String bloque = "";
        boolean encontrado = false;
        String msg = NO_ENCONTRADO;

        for (int i = 2; i < (pi.length()-valor.length()) && !encontrado; i++) {
            bloque = pi.substring(i, i+valor.length());
            if (bloque.equals(valor)) {
                msg = ENCONTRADO;
                encontrado = true;
            }
        }

        return String.format(msg, valor);
    }

}
