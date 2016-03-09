package Framework.Des;

/**
 * Created by Utilisateur on 2016-02-18.
 * Classe qui contient un d�
 */
public class De implements  Comparable<De>
{
    private int face;

    De() {
    }

    /**
     * @return la face du d�
     */
    public int getFace(){
        return face;
    }

    /**
     * initialise la face du d�
     * @param face face du d� � initialiser
     */
    public void setFace(int face){
        this.face = face;
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(De d)
    {
        if(d.getFace() > this.face){
            return 1;
        }
        else if(d.getFace() < this.face) {
            return -1;
        }
        else return 0;
    }
}
