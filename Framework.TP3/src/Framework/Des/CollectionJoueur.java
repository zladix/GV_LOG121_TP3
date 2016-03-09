package Framework.Des;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe qui g�re la collection de joueur
 * Created by Utilisateur on 2016-02-18.
 */
public class CollectionJoueur
{
    ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();

    CollectionJoueur(){}
    
    /**
     * Constructeur qui va initialiser la collection
     * @param des listes de joueurs
     */
    public CollectionJoueur(ArrayList<Joueur> listeJoueur)
    {
        this.listeJoueur = listeJoueur;
    }
    
    /**
     * Permet d'ajouter un joueur dans la collection
     * @param d D� � ajouter
     */
    public void ajouterJoueur(Joueur j){
        listeJoueur.add(j);
    }
    
    /**
     * @return retourne la longeur de la collection
     */
    public int getLength()
    {
        return listeJoueur.size();
    }

    /**
     * @param index position du joueur dans la collection
     * @return le joueur � la position de l'index
     */
    public Joueur get(int index){
        return listeJoueur.get(index);
    }

    /**
     * Permet de cr�er un it�rateur � partir de la collection
     * @return l'it�rateur de joueur
     */
    public Iterator<Joueur> creerIterateur(){
        return new JoueurIterateur(this);
    }
    
    /**
     * m�thode qui va trier la collection en ordre croissant
     */
    public void TrierCollection(){Collections.sort(listeJoueur);}
}
