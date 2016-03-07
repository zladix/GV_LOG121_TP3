package Framework.Des;
import java.util.Random;
import java.util.Iterator;

/**
 * Created by Utilisateur on 2016-02-18.
 */
public class Jeu
{
    private final int MIN_FACE = 1;
    private int nbFaces = 1;
    private int scoreTourJoueur = 0;
    private int joueurActuel = 1;
    private int nbTour;
    private int nbTourPartieMax;
    private boolean finTour = false;

    private CollectionDes collectionDes;
    private CollectionJoueur collectionJoueur;

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
                nbjoueurTest++;
                scoreGagnant = itJoueur.next().getScoreJoueur();
                System.out.println("GetScoreVainqueur: Joueur : "+nbjoueurTest+ " score : "+scoreGagnant+"\n");
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

    public CollectionDes getCollectionDes()
    {
        return collectionDes;
    }

    public CollectionJoueur getCollectionJoueur()
    {
        return collectionJoueur;
    }

    public void setFinTour(boolean finTour)
    {
        this.finTour = finTour;
    }

    public int getScoreJoueurActuel(int joueur) {
        return collectionJoueur.get(joueur).getScoreJoueur();
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
        if(nbTour == nbTourPartieMax+1){
            strategie.calculerLeVainqueur(this);
            //La liste est trié , le vainqueur pourra être récupéré avec getVainqueur.
            return 3;
        }
        else{
            genererDe();
            scoreTemp = strategie.calculerScoreTour(this);
            scoreTourJoueur = scoreTourJoueur + scoreTemp;
            if(finTour == false) {
                //si le joueur n'a pas fini son tour
                System.out.println("Score avant generation de de suivante dans le même tour: "+scoreTemp+" \n");
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
                    //itJoueur.next().setScoreJoueur(scoreTourJoueur);
                    scoreTourJoueur = 0;
                    nbTour = nbTour + 1;
                    joueurActuel = 1;
                    itJoueur = collectionJoueur.creerIterateur();
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
}