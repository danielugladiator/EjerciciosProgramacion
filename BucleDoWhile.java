package Bloque3;

import java.util.Scanner;

public class BucleDoWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;
        
        do {
            System.out.print("Introduce un número mayor a 0: ");
            numero = scanner.nextInt();
        } while (numero <= 0);
        
        System.out.println("Número ingresado correctamente: " + numero);
        scanner.close();
    }
}

