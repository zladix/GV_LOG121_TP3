/******************************************************
Cours:  LOG121
Projet: Framework.TP3
Nom du fichier: Joueur.java
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
 * Classe qui va g�rer le joueur avec son score
 * Created by Utilisateur on 2016-02-18.
 */
public class Joueur implements Comparable<Joueur>
{
    private int numeroJoueur;
    private int scoreJoueur;

    /**
     * Constructeur du joueur
     * @param numJoueur num�ro du joueur dans la partie
     * @param score score obtenu par le joueur
     */
    public Joueur(int numJoueur,int score)
    {
        numeroJoueur = numJoueur;
        scoreJoueur = score;
    }

    /**
     * @return le score du joueur
     */
    public int getScoreJoueur()
    {
        return scoreJoueur;
    }

    /**
     * @return le num�ro du joueur
     */
    public int getNumeroJoueur(){return numeroJoueur;}

    public void setScoreJoueur(int score)
    {
        scoreJoueur = scoreJoueur + score;
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
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
