package com.VLGD;

import java.util.Iterator;

/**
 * Created by Utilisateur on 2016-02-18.
 */
public class Bunco implements IStrategie{


    @Override
    public int calculerScoreTour(Jeu j) {

        int score = 0;
        int position = 0;

        j.collectionDes.TrierCollection();

        Iterator<De> it =  j.collectionDes.creerIterateur();

        System.out.println(j.collectionDes.get(0).getFace() + " " + j.collectionDes.get(1).getFace() + " " +j.collectionDes.get(2).getFace());

        //boucle qui calcule le nombre de dés ayant la même face que le tour
        while(it.hasNext())
        {
            if(j.collectionDes.get(position).getFace() == j.getNbTour())
            {
               score++;
            }

            position = position + 1;

            it.next();
        }

        //si les 3 dées sont pareil(doit être trié en ordre croissant)
        if(j.collectionDes.get(0).getFace() == j.collectionDes.get(2).getFace())
        {
            //si le score est de 3 ça veut dire que c'est un bonco à cause du point gagné par dé pareil au tour
            if(score == 3)
            {
                score = 21;
            }
            //sinon c'est 3 dés différents du tour donc 3 points
            else
            {
                score = 5;
            }
        }

        //si le joueur a eu un bonco ou 0 points, son tour est fini.
        if(score == 21 || score == 0){
            j.finTour = true;
        }
        else{
            j.finTour = false;
        }

        return score;
    }

    @Override
    public void calculerLeVainqueur(Jeu j)
    {

        j.collectionJoueur.TrierCollection();
        System.out.println(j.collectionJoueur.get(0).getScoreJoueur() + " " + j.collectionJoueur.get(1).getScoreJoueur() + " " +j.collectionJoueur.get(2).getScoreJoueur() + " " + j.collectionJoueur.get(3).getScoreJoueur());

    }
}
