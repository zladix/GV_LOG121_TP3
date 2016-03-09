package Framework.Des;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe qui g�re la collection de d�s
 * Created by Utilisateur on 2016-02-18.
 */
public class CollectionDes
{
    private ArrayList<De> listeDe = new ArrayList<De>();

    CollectionDes(){}

    /**
     * Permet d'ajouter un d� dans la collection
     * @param d D� � ajouter
     */
    public void ajouterDe(De d){
        listeDe.add(d);
    }

    /**
     * Constructeur qui va initialiser la collection
     * @param des listes de d�s
     */
    public void CollectionDe(ArrayList<De> des)
    {
        this.listeDe = des;
    }

    /**
     * @return retourne la longeur de la collection
     */
    public int getLength()
    {
        return listeDe.size();
    }

    /**
     * @param index position du d� dans la collection
     * @return le d� � la position de l'index
     */
    public De get(int index){
        return listeDe.get(index);
    }

    /**
     * Permet de cr�er un it�rateur � partir de la collection
     * @return l'it�rateur de d�
     */
    public Iterator<De> creerIterateur(){
        return new DeIterateur(this);
    }

    /**
     * m�thode qui va trier la collection en ordre croissant
     */
    public void TrierCollection(){Collections.sort(listeDe);}

}
