package controleur;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import environnement.Labyrinthe;

/**
 * File : Combat.java
 * Code source de la classe Combat
 * 
 * @author Alexandre Coulais
 * @version 2021-5-21
 */

public class SystemeSauvegarde {
    /**
     * Nom du dossier des sauvegardes
     * 
     * @see SystemeSauvegarde#verifierDossier()
     */
    private static final String mDirecName = "backup";

    /**
     * Nom du fichier de la sauvegarde
     * 
     * @see SystemeSauvegarde#verifierFichier()
     */
    private static final String mFileName = mDirecName + "/labyrinthe.ser";

    /**
     * Permet de vérifier qu'une partie existe
     * 
     * @see SystemeSauvegarde#verifierFichier()
     * 
     * @return Vrai si une partie existe, faux sinon
     */
    public static boolean exists() {
        return verifierFichier();
    }

    /**
     * Sauvegarde tout le graphe des objets en partant du labyrinthe
     * 
     * @param tLabyrinthe L'origine des objets à sauvegarder
     * @return Vrai si la sauvegarde a réussi, faux sinon
     */
    public static boolean sauvegarderPartie(Labyrinthe tLabyrinthe) {
        ObjectOutputStream oos = null;

        // Vérification de l'existence du dossier
        verifierDossier();

        /**
         * Suppression de l'ancienne sauvegarde
         * pour permettre de savoir si la sauvegarde s'est bien passée
         */
        supprimerPartie();

        try { // Ouverture d'un flux d'écriture
            final FileOutputStream fichier = new FileOutputStream(mFileName);

            oos = new ObjectOutputStream(fichier);

            // Ecriture du graphe
            oos.writeObject(tLabyrinthe);
            oos.flush();
        } catch (final java.io.IOException e) { // Si erreur de flux
            e.printStackTrace();
        } finally { // Si une exception est levée, nettoyage et fermeture des flux
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }

        return verifierFichier();
    }

    /**
     * Récupération d'une partie depuis le fichier de la sauvegarde
     * 
     * @return La référence du labyrinthe de la partie, null si problème
     */
    public static Labyrinthe recupererPartie() {
        Labyrinthe labyrinthe = null;

        // Si le fichier de sauvegarde existe, alors on essaie de récupérer son contenu
        if (verifierFichier()) {
            ObjectInputStream ois = null;

            try { // Ouverture d'un flux de lecture et désérialisation de l'objet
                final FileInputStream fichier = new FileInputStream(mFileName);

                ois = new ObjectInputStream(fichier);

                // Lecture du graphe
                labyrinthe = (Labyrinthe) ois.readObject();
            } catch (final java.io.IOException e) { // Si erreur de flux
                e.printStackTrace();
            } catch (final ClassNotFoundException e) { // Si erreur de classe
                e.printStackTrace();
            } finally { // Si une exception a été levée, on ferme les flux et on remet labyrinthe à null
                try {
                    if (ois != null) {
                        ois.close();
                    }

                    labyrinthe = null;
                } catch (final IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return labyrinthe;
    }

    /**
     * Suppression d'une partie
     * 
     * @return Vrai si pas de problème, faux sinon
     */
    public static boolean supprimerPartie() {
        File file = new File(mFileName);
        return file.delete();
    }

    /**
     * Vérifie la présence du dossier des sauvegarde, le crée dans au cas échéant
     * 
     * @return Vrai si le dossier a été créé, faux si déjà existant ou problème survenu
     */
    private static boolean verifierDossier() {
        File dossier = new File(mDirecName); 
        return dossier.mkdir();
    }

    /**
     * Vérifie la présence d'un fichier de sauvegarde
     * 
     * @return Vrai si existe, faux sinon
     */
    private static boolean verifierFichier() {
        File file = new File(mFileName); 
        return file.exists();
    }
}