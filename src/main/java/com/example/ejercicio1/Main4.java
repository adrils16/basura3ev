package com.example.ejercicio1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main4 {
    public static void main(String[] args) {

        final String RUTA_NUMEROS = "Numeros.txt";
        final String IMPRESION = "El numero mayor es %s y el menor es %s ";

        File fichero = new File(RUTA_NUMEROS);
        String cadena = leerFichero(fichero);
        int[] numeros = separarTexto(cadena);
        int numMayor = calcularMayor(numeros);
        int numMenor = calcularMenor(numeros);
        
        System.out.printf(IMPRESION, numMayor, numMenor);
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

    /**
     * Convierte un String, que contiene numeros, en un array de int.
     * @param cadena
     * @return array de int
     */
    public static int[] separarTexto(String cadena) {

        StringTokenizer st = new StringTokenizer(cadena, "\n");
        int[] numeros = new int[st.countTokens()];
        
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Integer.parseInt(st.nextToken());
        }

        return numeros;
    }

    /**
     * Dado un array de int, devuelve el numero mayor
     * @param numeros
     * @return
     */
    public static int calcularMayor(int[] numeros){
        int numMayor = 0;

        for (int i : numeros) {
            if(i > numMayor){
                numMayor = i;
            }
        }

        return numMayor;
    }

    /**
     * Dado un array de int, devuelve el numero menor
     * @param numeros
     * @return
     */
    public static int calcularMenor(int[] numeros){
        int numMenor = calcularMayor(numeros);

        for (int i : numeros) {
            if(i < numMenor){
                numMenor = i;
            }
        }

        return numMenor;
    }
}
