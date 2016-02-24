package com.VLGD;

/**
 * Created by Utilisateur on 2016-02-18.
 */
public interface IStrategie
{
    /**
     * Calcule le score du joueur
     * @return le score du joueur.
     */
    int calculerScoreTour();   //Il faut ajouter la liste de dés en paramètre ou y accéder d'une quelquonque manière.

    /**
     * Définir le vainqueur de la partie selon les règles inscrites.
     * @return le numéro du joueur ayant gagné la partie.
     */
    int calculerLeVainqueur(); //Il faut accéder a la liste de joueur pour avoir leur score.
}
