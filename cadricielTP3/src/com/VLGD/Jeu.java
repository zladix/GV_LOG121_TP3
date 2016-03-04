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
    int joueurActuel = 1;
    private int nbTour;
    private int nbTourPartieMax;
    boolean finTour = false;

    CollectionDes collectionDes;
    CollectionJoueur collectionJoueur;

    Iterator<De> itDe;
    Iterator<Joueur> itJoueur;
    private IStrategie strategie;

    Jeu(){}
    public Jeu(IStrategie strategie){
        this.strategie = strategie;
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
        collectionDes = new CollectionDes();

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
        collectionJoueur = new CollectionJoueur();
        for(int i = 1; i<= nbJoueur;i++)
        {
            collectionJoueur.ajouterJoueur(new Joueur(i,scoreBase));
        }
       itJoueur =  collectionJoueur.creerIterateur();
    }

    /**
     * Valide le pointage du joueur pour ce tour(ou cette partie de tour si il ne respecte pas les conditions de changement de tour.
     * Retourne le gagnant si le nombre de tour maximum du jeu a été atteint.
     * Le int recu en return représente quelque chose selon le chiffre recu
     * return 0: le tour n'est pas terminé le joueur peut relancer les dés.
     * return 1: le tour du joueur est terminé , passe au prochain joueur.
     * return 2: tout les joueurs ont joué leur tour , passage au tour suivant.
     * return 3: la partie est terminé.
     */
    public int jouerTour()
    {
        int scoreTemp  = 0;
            genererDe();
            scoreTemp = strategie.calculerScoreTour(this);
            scoreTourJoueur = scoreTourJoueur + scoreTemp;
            if(finTour == false) {
                return 0;
            }
            else {
                //sinon le joueur a fini son tour , on passe la main.
                if (itJoueur.hasNext()){
                    itJoueur.next().setScoreJoueur(scoreTourJoueur);
                    joueurActuel = joueurActuel +1;
                    scoreTourJoueur = 0;

                    return 1;
                } else {
                    //fin de tour
                    itJoueur.next().setScoreJoueur(scoreTourJoueur);
                    scoreTourJoueur = 0;
                    nbTour = nbTour + 1;
                    joueurActuel = 1;
                    itJoueur = collectionJoueur.creerIterateur();
                    if(nbTour == nbTourPartieMax+1){
                        strategie.calculerLeVainqueur(this);
                        //La liste est trié , le vainqueur pourra être récupéré avec getVainqueur.
                        return 3;
                    }
                    else {
                        return 2;
                    }
                }
            }
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

    /**
     * @return: numéro du joueur vainqueur.
     * Return -1: La partie n'est pas terminée , donc pas de gagnant.
     */
    public int getVainqueur(){
        int joueurGagnant = 0;
        if(nbTour == nbTourPartieMax+1)
        {
            itJoueur = collectionJoueur.creerIterateur();
            while(itJoueur.hasNext()){
                joueurGagnant = itJoueur.next().getNumeroJoueur();
                System.out.println("GetVainqueur: Joueur : "+joueurGagnant+"\n");
            }
            return joueurGagnant;

        }
        else
        {
            return -1;
        }
    }

    /**
     * @return : score du vainqueur
     * Return -1: La partie n'est pas terminée , donc pas de score gagnant.
     */
    public int getScoreVainqueur(){
        int scoreGagnant = 0;
        int nbjoueurTest = 0;
        if(nbTour == nbTourPartieMax+1)
        {
            itJoueur = collectionJoueur.creerIterateur();
            while(itJoueur.hasNext()){
                scoreGagnant = itJoueur.next().getScoreJoueur();
                System.out.println("GetScoreVainqueur: Joueur : "+ collectionJoueur.get(nbjoueurTest).getNumeroJoueur()+ " score : "+scoreGagnant+"\n");
                nbjoueurTest++;
            }
            return scoreGagnant;
        }
        else
        {
            return -1;
        }
    }

    public int getNumeroJoueurActuel(){
        return joueurActuel;
    }
}