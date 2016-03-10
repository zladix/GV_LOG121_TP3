/******************************************************
Cours:  LOG121
Projet: Framework.TP3
Nom du fichier: Partie.java
Date créé: 2016-02-18
*******************************************************
Historique des modifications
*******************************************************
*@author Vincent Leclerc(LECV07069406)
*@author Gabriel Déry(DERG30049401)
2016-02-18 Version initiale
*******************************************************/  
package Bunco;
import Bunco.FabriqueBunco;
import Framework.Des.CollectionDes;
import Framework.Des.De;
import Framework.Des.Fabrique;
import Framework.Des.Jeu;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Utilisateur on 2016-02-18.
 * Classe qui va jouer une partie de bunco
 */
public class Partie
{
    /**
     * main de l'application
     * @param args
     */
    public static void main(String [ ] args)
    {
       Fabrique baseJeu;
        Jeu Partie;
        int tour = 0;
        boolean validation = true;
        baseJeu = new FabriqueBunco(4);
        Partie = baseJeu.getJeu();

        System.out.println("Début de la partie de bunco! \n");
        while(validation)
        {
            if(Partie.getNbTour() < 7 && Partie.getNumeroJoueurActuel() == 1) {
                System.out.println("Tour " + Partie.getNbTour() + "\n");
                System.out.println("--------------------------------------\n");
            }
            if(Partie.getNumeroJoueurActuel() < 5) {
                System.out.println("C'est au tour du joueur " + Partie.getNumeroJoueurActuel() + "\n");
                System.out.println("Veuillez confirmer le début de votre tour");

                Scanner sc = new Scanner(System.in);
                sc.nextLine();
            }
            tour = Partie.jouerTour();
            CollectionDes collectionDes = Partie.getCollectionDes();
            
            switch (tour)
            {
                case 0:System.out.println("Le joueur "+Partie.getNumeroJoueurActuel()+" n'a pas terminé son tour, il doit relancé les dés\n");break;
                case 1: System.out.println("Le joueur "+(Partie.getNumeroJoueurActuel()-1)+" a terminé son tour avec un score total de : "+Partie.getScoreJoueurActuel(Partie.getNumeroJoueurActuel()-2)+"\n");break;
                case 2: System.out.println("Le tour a été complété par tout les joueurs, tour suivant!\n"); break;
                case 3: validation = false; break;
            }
        }
        //Partie terminé
        System.out.println("FÃ©licitation au joueur : "+Partie.getVainqueur()+" avec un score de :"+ Partie.getScoreVainqueur()+"\n");
    }
}
