package org.example.view;

import java.util.Scanner;
import java.util.UUID;

public class Reader {
    public static double lerDouble() {
        return new Scanner(System.in).nextDouble();
    }

    public static double lerDouble(String msg) {
        System.out.println(msg);
        return lerDouble();
    }

    public static int lerInt() {
        return new Scanner(System.in).nextInt();
    }

    public static int lerInt(String msg) {
        System.out.println(msg);
        return lerInt();
    }

    public static UUID lerUUID() {
        String input = new Scanner(System.in).nextLine();
        try {
            return UUID.fromString(input);
        } catch (IllegalArgumentException e) {
            System.out.println("UUID inválido! Tente novamente:");
            return lerUUID();
        }
    }

    public static UUID lerUUID(String msg) {
        System.out.println(msg);
        return lerUUID();
    }

    public static String lerString() {
        return new Scanner(System.in).nextLine();
    }

    public static String lerString(String msg) {
        System.out.println(msg);
        return lerString();
    }

    public static String lerString(String msg, String errorMsg, String majoritaria1, String majoritaria2){
        String a;
        do{
            a = lerString(msg);
            if(!a.equalsIgnoreCase(majoritaria1) && !a.equalsIgnoreCase(majoritaria2)){
                System.out.println(errorMsg);
            }
        }while(!a.equalsIgnoreCase(majoritaria1) && !a.equalsIgnoreCase(majoritaria2));
        return a;
    }

    public static int lerInt(String msg, String errorMsg, int min, int max) {
        int valor;
        do {
            valor = lerInt(msg);
            if (valor > max || valor < min) {
                System.out.println(errorMsg);
            }
        } while (valor < min || valor > max);
        return valor;
    }

    public static int lerInt(String msg, String errorMsg, int min) {
        int valor;
        do {
            valor = lerInt(msg);
            if (valor < min) {
                System.out.println(errorMsg);
            }
        } while (valor < min);
        return valor;
    }

    public static boolean lerContinue(String msg) {
        boolean continuar;
        String mensagem = lerString(msg);
        continuar = mensagem.equalsIgnoreCase("Sim");
        return continuar;
    }
}



