package com.VLGD;

/**
 * Created by Utilisateur on 2016-02-18.
 */
public class Bunco implements IStrategie{
    @Override
    public int calculerScoreTour() {
    //Règle
        //3 dés si les 3 dés ont le même chiffre que le chiffre du tour , +21 points
                    //Passe le tour.
                //Sinon , +1 point ou +2 point selon le nombre de dés ayant le même chiffre que le tour.
                    //continue le tour.
                //Sinon , on vérifie si les 3 dés ont la même face mais qui est différent de celui du tour, si c'est le cas + 5 points
                    //continue le tour
                //Sinon + 0 points
                    //Passe le tour.
        return 0;
    }

    @Override
    public int calculerLeVainqueur()
    {
        //Compare le score de chaque joueur , retourne le numéro du joueur ayant le plus haut score.
            //Probablement avec le compareTo présent dans joueur.
        return 1;
    }
}
