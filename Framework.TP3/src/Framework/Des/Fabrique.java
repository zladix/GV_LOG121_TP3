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
     * Initialise la classe jeu(nom de la stratégie du jeu).
     * Initialise le nombre de tour max à l'aide de jeu.setNbTourPartieMax.
     * Initialise le premier tour à l'aide de jeu.setNbTour.
     */
    protected void genererJeu() {}

    /**
     * Initialise le nombre de dés et le nombre de faces de chaque dés avec jeu.setDes(nbDes,NbFace).
     */
    protected void genererDe() {}

    /**
     * Initialise le nombre de joueur participant à la partie avec jeu.setNbJoueur(nbJoueur).
     */
    protected void genererJoueur() {}

    public final Jeu getJeu()
    {
        return manche;
    }
}
