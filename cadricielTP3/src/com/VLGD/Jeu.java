package com.VLGD;

/**
 * Created by Utilisateur on 2016-02-18.
 */
public class Jeu
{
    private int nbTours;

    Jeu(int tour)
    {
        nbTours = tour;
    }

    public int getNbTours()
    {
        return nbTours;
    }

    public void setNbTours(int tour)
    {
        nbTours = tour;
    }
}
