/******************************************************
Cours:  LOG121
Projet: Framework.TP3
Nom du fichier: Bunco.java
Date cr��: 2016-02-18
*******************************************************
Historique des modifications
*******************************************************
*@author Vincent Leclerc(LECV07069406)
*@author Gabriel D�ry(DERG30049401)
2016-02-18 Version initiale
*******************************************************/  
package Bunco;

import Framework.Des.De;
import Framework.Des.IStrategie;
import Framework.Des.Jeu;

import java.util.Iterator;

/**
 * Strat�gie qui impl�mente le jeux de d� du bunco
 *
 */
public class Bunco implements IStrategie {


    /* (non-Javadoc)
     * @see Framework.Des.IStrategie#calculerScoreTour(Framework.Des.Jeu)
     */
    @Override
    public int calculerScoreTour(Jeu j) {

        int score = 0;
        int position = 0;

        j.getCollectionDes().TrierCollection();

        Iterator<De> it =  j.getCollectionDes().creerIterateur();

        //boucle qui calcule le nombre de d�s ayant la m�me face que le tour
        while(it.hasNext())
        {
            if(j.getCollectionDes().get(position).getFace() == j.getNbTour())
            {
               score++;
            }

            position = position + 1;
            it.next();
        }

        //si les 3 d�es sont pareil(doit �tre tri� en ordre croissant)
        if(j.getCollectionDes().get(0).getFace() == j.getCollectionDes().get(2).getFace())
        {
            //si le score est de 3 ça veut dire que c'est un bonco � cause du point gagn� par d� pareil au tour
            if(score == 3)
            {
                score = 21;
            }
            //sinon c'est 3 dés différents du tour donc 3 points
            else
            {
                score = 5;
            }
        }

        //si le joueur a eu un bonco ou 0 points, son tour est fini.
        if(score == 21 || score == 0){
            j.setFinTour(true);
        }
        else{
            j.setFinTour(false);
        }

        return score;
    }

    /* (non-Javadoc)
     * @see Framework.Des.IStrategie#calculerLeVainqueur(Framework.Des.Jeu)
     */
    @Override
    public void calculerLeVainqueur(Jeu j)
    {
        j.getCollectionJoueur().TrierCollection();
    }
}
