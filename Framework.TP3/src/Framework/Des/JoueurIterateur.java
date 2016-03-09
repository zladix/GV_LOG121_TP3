package Framework.Des;

import java.util.Iterator;

/**
 *  Classe qui va gérer l'itérateur de joueurs
 */
public class JoueurIterateur implements Iterator<Joueur> {

    private CollectionJoueur cJoueur;
    public int position = 0;

    public JoueurIterateur(CollectionJoueur cJoueur)
    {
        this.cJoueur = cJoueur;
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#hasNext()
     */
    @Override
    public boolean hasNext() {

        if(position < cJoueur.getLength())
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
    public Joueur next() {
        Joueur unJoueur = cJoueur.get(position);
        position++;
        return unJoueur;
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#remove()
     */
    @Override
    public void remove(){
    }
}
