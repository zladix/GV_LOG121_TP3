package Framework.Des;

/**
 * Classe qui va gérer le joueur avec son score
 * Created by Utilisateur on 2016-02-18.
 */
public class Joueur implements Comparable<Joueur>
{
    private int numeroJoueur;
    private int scoreJoueur;

    /**
     * Constructeur du joueur
     * @param numJoueur numéro du joueur dans la partie
     * @param score score obtenu par le joueur
     */
    Joueur(int numJoueur,int score)
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
     * @return le numéro du joueur
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
