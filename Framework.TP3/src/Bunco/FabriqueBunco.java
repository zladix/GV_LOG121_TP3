package Bunco;

import Bunco.Bunco;
import Framework.Des.Fabrique;
import Framework.Des.Jeu;

/**
 * Created by Utilisateur on 2016-02-18.
 */
public class FabriqueBunco extends Fabrique
{
    FabriqueBunco(int nbJoueur){super(nbJoueur);}
    @Override
    public void genererJeu() {
        super.genererJeu();
        manche = new Jeu(new Bunco());
        //Contient le nombre de tour maximum du jeu. 6 dans ce cas si
        manche.setNbTourPartieMax(6);
        manche.setNbTour(1);
    }

    @Override
    public void genererDe() {
        super.genererDe();
        // 3 Dé de 6 faces;
        //utiliser le set dans jeu pour générer le nombre de dés nécessaire
        manche.setDes(3,6);
    }

    @Override
    public void genererJoueur() {
        super.genererJoueur();
        if(super.nbJoueur < 2){
            System.out.println("Le nombre de joueur minimum pour une partie de dé est de 2.");
            super.nbJoueur = 2;
        }
        //utiliser le set dans jeu pour générer le nombre de joueur nécessaire
        manche.setNbJoueur(super.nbJoueur,0);
    }
}
