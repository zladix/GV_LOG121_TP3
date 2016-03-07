package Framework.Des;

import java.util.Iterator;

/**
 * Created by pc on 2016-03-03.
 */
public class JoueurIterateur implements Iterator<Joueur> {

    private CollectionJoueur cJoueur;
    public int position = 0;

    public JoueurIterateur(CollectionJoueur cJoueur)
    {
        this.cJoueur = cJoueur;
    }

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

    @Override
    public Joueur next() {
        Joueur unJoueur = cJoueur.get(position);
        position++;
        return unJoueur;
    }

    @Override
    public void remove(){
    }
}
