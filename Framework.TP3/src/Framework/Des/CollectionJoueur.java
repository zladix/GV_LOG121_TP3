package Framework.Des;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Utilisateur on 2016-02-18.
 */
public class CollectionJoueur
{
    ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();

    CollectionJoueur(){}

    public CollectionJoueur(ArrayList<Joueur> listeJoueur)
    {
        this.listeJoueur = listeJoueur;
    }

    public void ajouterJoueur(Joueur j){
        listeJoueur.add(j);
    }

    public int getLength()
    {
        return listeJoueur.size();
    }

    public Joueur get(int index){
        return listeJoueur.get(index);
    }

    public Iterator<Joueur> creerIterateur(){
        return new JoueurIterateur(this);
    }

    public void TrierCollection(){Collections.sort(listeJoueur);}
}
