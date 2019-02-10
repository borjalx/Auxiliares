/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Borja S
 */
public class Auxiliares {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    //Función con la que pedimos una cadena de texto con un mensaje
    public static String pedirCadena(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cadena = "";
        do {
            try {
                System.out.println(mensaje);
                cadena = br.readLine();
                if (cadena.equals("")) {
                    System.out.println("Debes escribir alguna cosa");
                }
            } catch (IOException ex) {
                System.out.println("Error de entrada / salida.");
            }
        } while (cadena.equals(""));
        return cadena;
    }

    //Función para pedir un double (número con decimales)
    public static double pedirDouble(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double num = 0;
        boolean error;
        do {
            try {
                System.out.println(mensaje);
                num = Double.parseDouble(br.readLine());
                error = false;
            } catch (IOException ex) {
                System.out.println("Error de entrada / salida.");
                error = true;
            } catch (NumberFormatException ex) {
                System.out.println("Debes introducir un número con decimales.");
                error = true;
            }
        } while (error);
        return num;
    }

    //Función para pedir un número entero (sin decimales)
    public static int pedirNumero(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        boolean error;
        do {
            try {
                System.out.println(mensaje);
                num = Integer.parseInt(br.readLine());
                error = false;
            } catch (IOException ex) {
                System.out.println("Error de entrada / salida.");
                error = true;
            } catch (NumberFormatException ex) {
                System.out.println("Debes introducir un número entero.");
                error = true;
            }
        } while (error);
        return num;
    }

    // Método que indica si un String es un entero o no
    public static boolean esEntero(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    
    //Función que pide un número en un rango (incluidos)
    public static int pedirNumeroRango(String mensaje, int min, int max){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        boolean error;
        do {
            try {
                System.out.println(mensaje);
                num = Integer.parseInt(br.readLine());
                if(num >= min && num <= max){
                    error = false;
                }else{
                    System.out.println("INFO - Debes introducir un número entre " + min + " y " + max + " (ambos incluídos)");
                    error = true;
                }
            } catch (IOException ex) {
                System.out.println("Error de entrada / salida.");
                error = true;
            } catch (NumberFormatException ex) {
                System.out.println("Debes introducir un número entero.");
                error = true;
            }
        } while (error);
        return num;
    }
    
    //Función que devuelve un número random entre un rango de números (mínimo y máximo) incluidos
    public static int numeroRandom(int min, int max){
        int n = (int) Math.floor(Math.random()*(max-min+1)+min);
        return n;
    }
    
    //Función para solicitar un DNI
    public static String pedirDNI(String mensaje){
        String dni = "";
        boolean isIt = false;
        do {            
            dni = pedirCadena(mensaje);
            
            //comprobamos que tenga 9 dígitos
            //comprobamos que los 8 primeros sean números
            //comprobamos que el último dígito es una letra (min. o may.)
            //Pattern pat = Pattern.compile("\\d{8}[A-HJ-NP-TV-Z]");
            Pattern pat = Pattern.compile("\\d{8}[a-zA-Z]");
            Matcher mat = pat.matcher(dni);
            if (mat.matches()) {
                isIt = true;
            }else{
                System.out.println("DNI 8 primeros dígitos números, último dígito letra.");
            }
        } while (!isIt);
        
        return dni;
    }
    
    //Función para solicitar un número de teléfono (ESPAÑA)
    public static String pedirNTelefono(String mensaje){
        String ntel;
        boolean isIt = false;
        do {            
            ntel = pedirCadena(mensaje);
            
            //comprobamos que tenga 9 dígitos
            //comprobamos que los 8 primeros sean números
            //comprobamos que el último dígito es una letra (min. o may.)
            //BORRAR - 
            Pattern pat = Pattern.compile("/^[9|6|7][0-9]{8}$/");
            Matcher mat = pat.matcher(ntel);
            if (mat.matches()) {
                isIt = true;
            }else{
                System.out.println("Teléfono debe constar de 9 numeros y empezar por 6,9 o 7.");
            }
        } while (!isIt);

        
        return ntel;
    }

}
