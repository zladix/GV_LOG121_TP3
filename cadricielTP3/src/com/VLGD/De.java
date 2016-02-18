package com.VLGD;

/**
 * Created by Utilisateur on 2016-02-18.
 */
public class De implements Comparable
{
    private int face;

    De(int face)
    {
        this.face = face;
    }

    public int getFace(){
        return face;
    }

    public void setFace(int face){
        this.face = face;
    }

    @Override
    public int compareTo(Object o)
    {
        return 0;
    }
}
