package com.VLGD;

/**
 * Created by Utilisateur on 2016-02-18.
 */
public class Joueur implements Comparable
{
    private int scoreJoueur;

    Joueur()
    {
        scoreJoueur = 0;
    }

    public int getScoreJoueur()
    {
        return scoreJoueur;
    }

    public void setScoreJoueur(int score)
    {
        scoreJoueur = score;
    }

    @Override
    public int compareTo(Object o)
    {
        return 0;
    }
}
