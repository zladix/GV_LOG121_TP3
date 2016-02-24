package com.VLGD;

/**
 * Created by Utilisateur on 2016-02-18.
 */
public abstract class Fabrique
{
    Jeu manche;
    public final void genererPartie(int nbJoueur)
    {
        genererJeu();
        genererDe();
        genererJoueur(nbJoueur);
    }

    protected void genererJeu()
    {
        manche = new Jeu();
    }

    protected void genererDe()
    {

    }

    protected void genererJoueur(int nbJoueur)
    {
        if(nbJoueur < 2){
            System.out.println("Le nombre de joueur minimum pour une partie de dé est de 2.");
            nbJoueur = 2;
        }
    }
}
