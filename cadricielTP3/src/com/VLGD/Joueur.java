package com.VLGD;

/**
 * Created by Utilisateur on 2016-02-18.
 */
public class Joueur implements Comparable<Joueur>
{
    private int numeroJoueur;
    private int scoreJoueur;

    Joueur(int numJoueur,int score)
    {
        numeroJoueur = numJoueur;
        scoreJoueur = score;
    }

    public int getScoreJoueur()
    {
        return scoreJoueur;
    }

    public int getNumeroJoueur(){return numeroJoueur;}

    public void setScoreJoueur(int score)
    {
        scoreJoueur = scoreJoueur + score;
        System.out.println("score joueur "+numeroJoueur+" : "+ scoreJoueur+"\n");
    }

    @Override
    public int compareTo(Joueur j)

    {
        if(j.getScoreJoueur() < this.scoreJoueur)
        {
            return 1;
        }
        else if(j.getScoreJoueur() > this.scoreJoueur)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}
