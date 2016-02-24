package com.VLGD;

/**
 * Created by Utilisateur on 2016-02-18.
 */
public class Jeu
{
    private int nbTour;
    private int nbTourPartieMax;

    CollectionDes Des;
    CollectionJoueur Joueur;

    Jeu()
    {
    }

    public int getNbTour()
    {

        return nbTour;
    }

    /**
     * Initialise la valeur du tour actuel pour le jeu.
     * @param tour
     */
    public void setNbTour(int tour)
    {
        nbTour = tour;
    }

    /**
     * Initialise le nombre de tour maximum du jeu en question.
     * @param maxTour
     */
    public void setNbTourPartieMax(int maxTour){
        nbTourPartieMax = maxTour;
    }

    /**
     * Génère la liste de dés pour le jeu.
     * @param nbDes : nombre de dés nécessaire.
     * @param nbFaces : nombre de face pour les dés.
     */
    public void setNbDes(int nbDes,int nbFaces){
        //génère la liste contenant les dés
    }

    /**
     * Génère la liste de joueur pour le jeu.
     * @param nbJoueur : nombre de joueur.
     * @param scoreBase : score de base lors du début du jeu pour chaque joueur.
     */
    public void setNbJoueur(int nbJoueur,int scoreBase){
    }

    /**
     * Valide le pointage du joueur pour ce tour(ou cette partie de tour si il ne respecte pas les conditions de changement de tour.
     * Retourne le gagnant si le nombre de tour maximum du jeu a été atteint.
     */
    public void validerTour()
    {
        if(nbTour == nbTourPartieMax+1){
            //Calculer le vainqueur
        }
        else{
            //Calculer le pointage du joueur selon la stratégie
        }
    }
}
