package com.VLGD;

/**
 * Created by Utilisateur on 2016-02-18.
 */
public class FabriqueBunco extends Fabrique
{
    @Override
    protected void genererJeu() {
        super.genererJeu();
        //Contient le nombre de tour maximum du jeu. 6 dans ce cas si
        manche.setNbTourPartieMax(6);
        manche.setNbTour(1);
    }

    @Override
    protected void genererDe() {
        super.genererDe();
        // 3 Dé de 6 faces;
        //utiliser le set dans jeu pour générer le nombre de dés nécessaire
        manche.setDes(3,6);
    }

    @Override
    protected void genererJoueur(int nbJoueur) {
        super.genererJoueur(nbJoueur);
        if(nbJoueur < 2){
            System.out.println("Le nombre de joueur minimum pour une partie de dé est de 2.");
            nbJoueur = 2;
        }
        //utiliser le set dans jeu pour générer le nombre de joueur nécessaire
        manche.setNbJoueur(nbJoueur,0);
    }
}
