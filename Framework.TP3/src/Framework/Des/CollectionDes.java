/******************************************************
Cours:  LOG121
Projet: Framework.TP3
Nom du fichier: CollectionDes.java
Date créé: 2016-02-18
*******************************************************
Historique des modifications
*******************************************************
*@author Vincent Leclerc(LECV07069406)
*@author Gabriel Déry(DERG30049401)
2016-02-18 Version initiale
*******************************************************/  
package Framework.Des;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe qui gère la collection de dés
 * Created by Utilisateur on 2016-02-18.
 */
public class CollectionDes
{
    private ArrayList<De> listeDe = new ArrayList<De>();

    CollectionDes(){}

    /**
     * Permet d'ajouter un dé dans la collection
     * @param d Dé à ajouter
     */
    public void ajouterDe(De d){
        listeDe.add(d);
    }

    /**
     * Constructeur qui va initialiser la collection
     * @param des listes de dés
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
     * @param index position du dé dans la collection
     * @return le dé à la position de l'index
     */
    public De get(int index){
        return listeDe.get(index);
    }

    /**
     * Permet de créer un itérateur à partir de la collection
     * @return l'itérateur de dé
     */
    public Iterator<De> creerIterateur(){
        return new DeIterateur(this);
    }

    /**
     * méthode qui va trier la collection en ordre croissant
     */
    public void TrierCollection(){Collections.sort(listeDe);}

}
