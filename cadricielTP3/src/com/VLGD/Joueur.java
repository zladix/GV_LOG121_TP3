package com.VLGD;

/**
 * Created by Utilisateur on 2016-02-18.
 */
public class Joueur implements Comparable<Joueur>
{
    private int scoreJoueur;

    Joueur(int score)
    {
        scoreJoueur = score;
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
    public int compareTo(Joueur j)
    {
        if(j.getScoreJoueur() > this.scoreJoueur)
        {
            return 1;
        }
        else if(j.getScoreJoueur() < this.scoreJoueur)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}
