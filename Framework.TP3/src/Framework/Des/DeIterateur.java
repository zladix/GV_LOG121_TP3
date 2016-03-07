package Framework.Des;

import java.util.Iterator;

/**
 * Created by pc on 2016-03-03.
 */
public class DeIterateur  implements Iterator<De> {

    private CollectionDes cDe;
    private int position = 0;

    public DeIterateur(CollectionDes cDe)
    {
        this.cDe = cDe;

    }

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

    @Override
    public De next() {
        De unDe = cDe.get(position);
        position++;
        return unDe;
    }

    @Override
    public void remove(){}
}
