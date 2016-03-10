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
import Framework.Des.Joueur;

/**
 * Classe qui permet de tester les méthode de la classe Bunco
 * @author pc
 *
 */
public class BuncoTest {

	 Fabrique baseJeu;
	 Jeu j;
	 IStrategie b = new Bunco();
	 int score = 0;

	@Test
	public void obtenirBuncoTest() {
		
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
	public void obtenirMiniBuncoTest()
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
	public void obtenir1DePareilTourTest()
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
	public void obtenir2DePareilTourTest()
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
	public void obtenirAuncunDePareilTourTest()
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
	
	@Test
	public void calculerScoreFinPartieTest()
	{
		baseJeu = new FabriqueBunco(2);
	    j = baseJeu.getJeu();
	    
	    int tabScore[] = {20,10,50,3};
	    int tabScoreTrie[] = {50,20,10,3};
	    int i = 0;
		
	    j.setNbJoueur(4, 0);
	    
		Iterator<Joueur> itJoueur = j.getCollectionJoueur().creerIterateur();
		
		while(itJoueur.hasNext())
	    {
	        itJoueur.next().setScoreJoueur(tabScore[i]);
	        i++;
	    }
		
		b.calculerLeVainqueur(j);
		
		itJoueur = j.getCollectionJoueur().creerIterateur();
		i = 0;
		
		while(itJoueur.hasNext())
	    {
	        assertTrue(itJoueur.next().getScoreJoueur() == tabScoreTrie[i]);
	        i++;
	    }
		
		
	}
	
	

}
