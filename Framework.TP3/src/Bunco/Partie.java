package Bunco;
import Bunco.FabriqueBunco;
import Framework.Des.Fabrique;
import Framework.Des.Jeu;

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

        System.out.println("D�but de la partie de bunco! \n");
        while(validation)
        {
            if(Partie.getNbTour() < 7 && Partie.getNumeroJoueurActuel() == 1) {
                System.out.println("Tour " + Partie.getNbTour() + "\n");
                System.out.println("--------------------------------------\n");
            }
            if(Partie.getNumeroJoueurActuel() < 5) {
                System.out.println("C'est au tour du joueur " + Partie.getNumeroJoueurActuel() + "\n");
                System.out.println("Veuillez confirmer le d�but de votre tour");

                Scanner sc = new Scanner(System.in);
                sc.nextLine();
            }
            tour = Partie.jouerTour();
            switch (tour)
            {
                case 0:System.out.println("Le joueur "+Partie.getNumeroJoueurActuel()+" n'a pas termin� son tour, il doit relanc� les d�s\n");break;
                case 1: System.out.println("Le joueur "+(Partie.getNumeroJoueurActuel()-1)+" a termin� son tour avec un score total de : "+Partie.getScoreJoueurActuel(Partie.getNumeroJoueurActuel()-2)+"\n");break;
                case 2: System.out.println("Le tour a �t� compl�t� par tout les joueurs, tour suivant!\n"); break;
                case 3: validation = false; break;
            }
        }
        //Partie termin�
        System.out.println("Félicitation au joueur : "+Partie.getVainqueur()+" avec un score de :"+ Partie.getScoreVainqueur()+"\n");
    }
}
