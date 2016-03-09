/******************************************************
Cours:  LOG121
Projet: Framework.TP3
Nom du fichier: BuncoTest.java
Date créé: 2016-03-07
*******************************************************
Historique des modifications
*******************************************************
*@author Vincent Leclerc(LECV07069406)
*@author Gabriel Déry(DERG30049401)
2016-03-07 Version initiale
*******************************************************/ 
package Test;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import Bunco.*;
import Framework.Des.De;
import Framework.Des.Fabrique;
import Framework.Des.IStrategie;
import Framework.Des.Jeu;

public class BuncoTest {

	 Fabrique baseJeu;
	 Jeu j;
	 IStrategie b = new Bunco();
	 int score = 0;

	@Test
	public void obtenirBunco() {
		
		baseJeu = new FabriqueBunco(2);
	    j = baseJeu.getJeu();
		
		int tabDe[] = {2,2,2};
		int i = 0;
		
		j.setDes(3, 6);
		j.setNbTour(2);
		
		Iterator<De> itDe = j.getCollectionDes().creerIterateur();
		   
	    while(itDe.hasNext())
	    {
	        itDe.next().setFace(tabDe[i]);
	        i++;
	    }
	    
	     score = b.calculerScoreTour(j);
	
	    assertTrue(score == 21);
	    assertTrue(j.getFinTour() == true);
	}
	
	@Test
	public void obtenirMiniBunco()
	{
		
		baseJeu = new FabriqueBunco(2);
	    j = baseJeu.getJeu();
		
		int tabDe[] = {2,2,2};
		int i = 0;
		
		j.setDes(3, 6);
		j.setNbTour(3);
		
		Iterator<De> itDe = j.getCollectionDes().creerIterateur();
		   
	    while(itDe.hasNext())
	    {
	        itDe.next().setFace(tabDe[i]);
	        i++;
	    }
	    
	     score = b.calculerScoreTour(j);
	
	    assertTrue(score == 5);
	    assertTrue(j.getFinTour() == false);
		
	}
	
	
	@Test
	public void obtenir1DePareilTour()
	{
		baseJeu = new FabriqueBunco(2);
	    j = baseJeu.getJeu();
		
		int tabDe[] = {3,2,2};
		int i = 0;
		
		j.setDes(3, 6);
		j.setNbTour(3);
		
		Iterator<De> itDe = j.getCollectionDes().creerIterateur();
		   
	    while(itDe.hasNext())
	    {
	        itDe.next().setFace(tabDe[i]);
	        i++;
	    }
	    
	     score = b.calculerScoreTour(j);
	
	    assertTrue(score == 1);
	    assertTrue(j.getFinTour() == false);
	}
	
	@Test
	public void obtenir2DePareilTour()
	{
		baseJeu = new FabriqueBunco(2);
	    j = baseJeu.getJeu();
		
		int tabDe[] = {3,3,2};
		int i = 0;
		
		j.setDes(3, 6);
		j.setNbTour(3);
		
		Iterator<De> itDe = j.getCollectionDes().creerIterateur();
		   
	    while(itDe.hasNext())
	    {
	        itDe.next().setFace(tabDe[i]);
	        i++;
	    }
	    
	     score = b.calculerScoreTour(j);
	
	    assertTrue(score == 2);
	    assertTrue(j.getFinTour() == false);
	}
	
	@Test
	public void obtenirAuncunDePareilTour()
	{
		baseJeu = new FabriqueBunco(2);
	    j = baseJeu.getJeu();
		
		int tabDe[] = {3,3,2};
		int i = 0;
		
		j.setDes(3, 6);
		j.setNbTour(1);
		
		Iterator<De> itDe = j.getCollectionDes().creerIterateur();
		   
	    while(itDe.hasNext())
	    {
	        itDe.next().setFace(tabDe[i]);
	        i++;
	    }
	    
	     score = b.calculerScoreTour(j);
	
	    assertTrue(score == 0);
	    assertTrue(j.getFinTour() == true);
	}

}
