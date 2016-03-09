/******************************************************
Cours:  LOG121
Projet: Framework.TP3
Nom du fichier: Fabrique.java
Date cr��: 2016-02-18
*******************************************************
Historique des modifications
*******************************************************
*@author Vincent Leclerc(LECV07069406)
*@author Gabriel D�ry(DERG30049401)
2016-02-18 Version initiale
*******************************************************/  
package Framework.Des;

/**
 * Created by Utilisateur on 2016-02-18.
 */
public abstract class Fabrique
{
    protected Jeu manche;
    protected int nbJoueur = 0;
    public Fabrique(int nbJoueur){
        this.nbJoueur = nbJoueur;
        genererPartie();
    }

    /**
     *  Fonction Template
     */
    public final void genererPartie()
    {
        genererJeu();
        genererDe();
        genererJoueur();
    }

    /**
     * Initialise la classe jeu(nom de la strat�gie du jeu).
     * Initialise le nombre de tour max � l'aide de jeu.setNbTourPartieMax.
     * Initialise le premier tour � l'aide de jeu.setNbTour.
     */
    protected void genererJeu() {}

    /**
     * Initialise le nombre de d�s et le nombre de faces de chaque d�s avec jeu.setDes(nbDes,NbFace).
     */
    protected void genererDe() {}

    /**
     * Initialise le nombre de joueur participant à la partie avec jeu.setNbJoueur(nbJoueur).
     */
    protected void genererJoueur() {}

    /**
     * @return Le jeu qui est jou�
     */
    public final Jeu getJeu()
    {
        return manche;
    }
}
