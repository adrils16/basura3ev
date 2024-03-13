package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main2 {
    public static void main(String[] args) throws Exception {
        
        final String NOMBRE_DIRECTORIO = "pruebas";
        final String NOMBRE_FICHERO_1 = "test.txt";
        final String DATOS_FICHERO_1 = "Hola! Soy Adrian";
        final String NOMBRE_FICHERO_2 = "testCopiado.txt";
        final String NOMBRE_FICHERO_2_RENOMBRADO = "testMod.txt";

        File directorio = crear(NOMBRE_DIRECTORIO); 
        File fichero1 = crear(directorio, NOMBRE_FICHERO_1, DATOS_FICHERO_1.getBytes());
        File fichero2 = copiar(directorio, fichero1, NOMBRE_FICHERO_2);
        borrar(fichero1);
        renombrar(fichero2, NOMBRE_FICHERO_2_RENOMBRADO);
        listar(directorio);
    }

    public static File crear(String nombreDirectorio) {

        File directorio = new File(nombreDirectorio); 

        directorio.mkdir();

        return directorio;
    }

    public static File crear(File directorio, String nombreFichero, byte[] datos) throws IOException{

        String ruta = directorio.getAbsolutePath()+File.separator+nombreFichero;
        File fichero = new File(ruta);

        try (FileOutputStream fos = new FileOutputStream(fichero)) {

            //fichero.createNewFile(); no es necesario, al escribir le da valor automaticamente
            fos.write(datos);

        }catch(IOException e){
            throw e;
        }

        return fichero;
    }

    public static File copiar(File directorio, File fichero, String nombreNuevo) throws FileNotFoundException, IOException{

        byte[] datos = null;

        try (FileInputStream fis = new FileInputStream(fichero)) {
            datos = fis.readAllBytes();
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        }

        return crear(directorio, nombreNuevo, datos);
    }

    public static void borrar(File fichero){
        fichero.delete();
    }

    public static void renombrar(File fichero, String nombreNuevo){
        File ficheroRenombrado = new File(fichero.getParentFile().getPath()+File.separator+nombreNuevo);

        fichero.renameTo(ficheroRenombrado);
    }

    public static void listar(File directorio){

        String[] listaArchivos = directorio.list();

        for(int i=0; i<listaArchivos.length; i++){
            System.out.println(listaArchivos[i]);
        }
    }
}
