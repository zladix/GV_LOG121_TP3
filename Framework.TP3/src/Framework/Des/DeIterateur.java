/******************************************************
Cours:  LOG121
Projet: Framework.TP3
Nom du fichier: DeIterateur.java
Date créé: 2016-03-03
*******************************************************
Historique des modifications
*******************************************************
*@author Vincent Leclerc(LECV07069406)
*@author Gabriel Déry(DERG30049401)
2016-03-03 Version initiale
*******************************************************/  
package Framework.Des;

import java.util.Iterator;

/**
 * Classe qui va gérer l'itérateur de dés
 */
public class DeIterateur  implements Iterator<De> {

    private CollectionDes cDe;
    private int position = 0;

    /**
     * Constructeur de l'itérateur
     * @param cDe Collection de dés qui va être itéré
     */
    public DeIterateur(CollectionDes cDe)
    {
        this.cDe = cDe;
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#hasNext()
     */
    @Override
    public boolean hasNext() {

        if(position < cDe.getLength())
        {
            return true;
        }
        else {
            return false;
        }
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#next()
     */
    @Override
    public De next() {
        De unDe = cDe.get(position);
        position++;
        return unDe;
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#remove()
     */
    @Override
    public void remove(){}
}
