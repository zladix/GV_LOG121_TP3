package com.VLGD;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Utilisateur on 2016-02-18.
 */
public class CollectionDes
{
    private ArrayList<De> listeDe = new ArrayList<De>();

    public void ajouterDe(De d){
        listeDe.add(d);
    }

    public void CollectionDe(ArrayList<De> des)
    {
        this.listeDe = des;
    }

    public int getLength()
    {
        return listeDe.size();
    }

    public De get(int index){
        return listeDe.get(index);
    }

    public Iterator<De> creerIterateur(){
        return new DeIterateur(this);
    }

}
