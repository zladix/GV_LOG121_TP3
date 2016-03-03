package com.VLGD;

/**
 * Created by Utilisateur on 2016-02-18.
 */
public class De implements  Comparable<De>
{
    private int face;

    De() {
    }

    public int getFace(){
        return face;
    }

    public void setFace(int face){
        this.face = face;
    }

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
