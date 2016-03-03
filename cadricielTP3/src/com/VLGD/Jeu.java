package com.VLGD;
import java.util.Random;
import java.util.Iterator;

/**
 * Created by Utilisateur on 2016-02-18.
 */
public class Jeu
{
    final int MIN_FACE = 1;
    int nbFaces = 1;
    int scoreTourJoueur = 0;
    private int nbTour;
    private int nbTourPartieMax;

    CollectionDes collectionDes;
    CollectionJoueur collectionJoueur;

    Iterator<De> itDe;
    Iterator<Joueur> itJoueur;

    Jeu() {
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
    public void setDes(int nbDes,int nbFaces){
        this.nbFaces = nbFaces;

        //génère la liste contenant les dés
        for (int i = 1 ; i <= nbDes;i++)
        {
            collectionDes.ajouterDe(new De());
        }
        itDe = collectionDes.creerIterateur();
    }

    /**
     * Génère la liste de joueur pour le jeu.
     * @param nbJoueur : nombre de joueur.
     * @param scoreBase : score de base lors du début du jeu pour chaque joueur.
     */
    public void setNbJoueur(int nbJoueur,int scoreBase)
    {
        for(int i = 1; i<= nbJoueur;i++)
        {
            collectionJoueur.ajouterJoueur(new Joueur(i,scoreBase));
        }
       itJoueur =  collectionJoueur.creerIterateur();
    }

    /**
     * Valide le pointage du joueur pour ce tour(ou cette partie de tour si il ne respecte pas les conditions de changement de tour.
     * Retourne le gagnant si le nombre de tour maximum du jeu a été atteint.
     */
    public int jouer()
    {
        boolean tourSuivant = false;
        if(nbTour == nbTourPartieMax+1){
            //Calculer le vainqueur.
        }
        else{
            genererDe();
            //Fonction de Des Statégie
            if(tourSuivant == false) {
                //si le joueur n'a pas fini son tour
                // scoreTourJoueur = scoreTourJoueur + //Ce que je recois
                jouer();
            }
            else {
                //sinon le joueur a fini son tour , on passe la main.
                if (itJoueur.hasNext()) {
                    itJoueur.next().setScoreJoueur(scoreTourJoueur);
                    scoreTourJoueur = 0;
                    jouer();
                } else {
                    //fin de tour
                    itJoueur.next().setScoreJoueur(scoreTourJoueur);
                    scoreTourJoueur = 0;
                    nbTour = nbTour + 1;
                    itJoueur = collectionJoueur.creerIterateur();
                    jouer();
                }
            }
        }
        return 0;
    }

    /**
     * Génère des faces aléatoires pour les dés.
     */
    public void genererDe()
    {
        Random valeur = new Random();
        int random = 0;
        itDe = collectionDes.creerIterateur();
        while(itDe.hasNext())
        {
            random = valeur.nextInt((nbFaces-MIN_FACE)+1)+MIN_FACE;
            itDe.next().setFace(random);
        }
    }
}