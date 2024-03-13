package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        final String COMANDO_SALIR = "exit";

        String comando = "";

        //ejecutarJava();

        do{
            comando = leer();
            ejecutarComando(comando);
        }while(comando != COMANDO_SALIR);
        
    }

    public static String leer() {
        Scanner sc = new Scanner(System.in);
        String cadena = "";

        cadena = sc.nextLine();

        return cadena;
    }

    public static void ejecutarComando(String comando) {
        try {
            Process process = Runtime.getRuntime().exec(comando);
            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

        //Dejamos el programa bloqueado hasta que termine el otro.
            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
                System.out.println(output);
            } else {
                System.out.println("Ha habido un error");
                System.out.printf("El proceso de obtener un directorio termino %d", exitVal);
            }

        } catch (IOException | InterruptedException e) {
            //e.printStackTrace();
            System.exit(34);
        }
    }

    /**
     * Convierte un String en un Array de Strings, separando el String por espacios.
     * @param cadena String que convertiremos a Array 
     * @return Devuelve un Array de Strings 
     */
    public static String[] stringToArray(String cadena) {

        StringTokenizer st = new StringTokenizer(cadena, " ");
        String[] comandoArray = new String[st.countTokens()];

        for (int i = 0; i < comandoArray.length; i++) {
            comandoArray[i] = st.nextToken();
        }

        return comandoArray;

    }

    public static void ejecutarJava() {
        ejecutarComando("cd ..");
        ejecutarComando("cd holamundo/src/main/java/com/example");
        ejecutarComando("javac Main.java");
        ejecutarComando("java Main");
    }
}