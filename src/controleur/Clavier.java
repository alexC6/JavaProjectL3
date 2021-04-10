package controleur;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Clavier {
    private static Scanner scanner = new Scanner(System.in);

    public static int entrerClavierInt() {
        int temp;

        try {
            temp = scanner.nextInt();
        } catch (InputMismatchException e) {
            String aux = scanner.next();

            System.out.println("Vous avez saisi : " + aux);
            System.out.println("Vous devez entrer un entier");

            temp = entrerClavierInt();
        }

        return temp;
    }

    public static String entrerClavierString() {
        return scanner.next();
    }


}
