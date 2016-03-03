package com.VLGD;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Utilisateur on 2016-02-18.
 */
public class CollectionJoueur
{
    ArrayList<Joueur> listeJoueur;

    public CollectionJoueur(ArrayList<Joueur> listeJoueur)
    {
        this.listeJoueur = listeJoueur;
    }

    public void ajouterJoueur(){

    }


    public int getLength()
    {
        return listeJoueur.size();
    }

    public Joueur get(int index){
        return listeJoueur.get(index);
    }

    public Iterator<Joueur> creerIterateur(){
        return new JoueurIterateur(this);
    }
}
