/******************************************************
Cours:  LOG121
Projet: Framework.TP3
Nom du fichier: IStrategie.java
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
public interface IStrategie
{
    /**
     * Calcule le score du joueur
     * @return le score du joueur.
     */
    int calculerScoreTour(Jeu j);   //Il faut ajouter la liste de dés en paramètre ou y accéder d'une quelquonque manière.

    /**
     * Définir le vainqueur de la partie selon les règles inscrites.
     */
    void calculerLeVainqueur(Jeu j); //Il faut accéder a la liste de joueur pour avoir leur score.
}
