package vue;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <p>File : Clavier.java
 * <br>Code source de la classe Clavier
 * <br>Cette classe est tirée du TP Fantaisie de l'enseignement CPO.
 * Elle a été enrichie des fonctions d'affichage de question et de demande
 * de choix à l'utilisateur</p>
 * 
 * @version 2021-5-18
 */

public class Clavier {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * <p>Permet d'afficher une question dans le cas où le tableau en paramètre n'est pas vide
     * <br>Cette fonction facilite la gestion de l'affichage des questions passées en paramètre
     * des fonctions de saisies
     * <br>Seule la première chaîne du tableau sera affichée</p>
     * @author Alexandre Coulais
     * 
     * @param tQuestion Tableau de String
     */
    private static void afficherPrompt(String tQuestion[]) {
        if (tQuestion.length != 0) {
            System.out.println(tQuestion[0]);
        }

        System.out.print("> ");
    }

    public static int entrerClavierInt(final String ... tQuestion) {
        int temp;

        afficherPrompt(tQuestion);

        try {
            temp = scanner.nextInt();
        } catch (InputMismatchException e) {
            String aux = scanner.next();

            System.out.println("Vous avez saisi : " + aux);
            System.out.println("Vous devez entrer un entier");

            temp = entrerClavierInt(tQuestion);
        }

        return temp;
    }

    public static String entrerClavierString(final String ... tQuestion) {
        afficherPrompt(tQuestion);
        return scanner.next();
    }

    /**
     * Fonction pour poser une question au joueur
     * @author Alexandre Coulais
     * 
     * @param tQuestion La question à poser
     * @param tTrue     Le caractère que saisira le joueur pour obtenir True
     * @param tFalse    Le caractère que saisira le joueur pour obtenir False
     * @return True si le joueur saisie le premier caractère, False sinon
     */
    public static boolean demanderChoix(String tQuestion, String tTrue, String tFalse) {
        String answer = "";
        
        do {
            answer = Clavier.entrerClavierString(tQuestion);
        } while (
            !(answer.toUpperCase().equals(tTrue.toUpperCase()))
            && !(answer.toUpperCase().equals(tFalse.toUpperCase()))
        );

        return answer.toUpperCase().equals(tTrue.toUpperCase());
    }
}