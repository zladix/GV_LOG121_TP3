/******************************************************
Cours:  LOG121
Projet: Framework.TP3
Nom du fichier: JeuTest.java
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
import Framework.Des.Jeu;
import Framework.Des.De;
import Framework.Des.Fabrique;
import Framework.Des.Joueur;
import Framework.Des.IStrategie;

public class JeuTest {
	Fabrique baseJeu;
	 Jeu partie;
	 IStrategie b = new Bunco();
	 
	 @Test
	 public void TestGetNbTour()
	 {
		 int tour;
		 baseJeu = new FabriqueBunco(2);
		 partie = baseJeu.getJeu();
		 
		 tour = partie.getNbTour();
		 assertTrue(tour == 1);
	 }
	 
	 @Test
	 public void TestSetNbTour()
	 {
		 int tour;
		 baseJeu = new FabriqueBunco(2);
		 partie = baseJeu.getJeu();
		 partie.setNbTour(8);
		 
		 tour = partie.getNbTour();
		 assertTrue(tour == 8);
	 }
	 
	 @Test
	 public void TestGetNbTourMax()
	 {
		 int tour;
		 baseJeu = new FabriqueBunco(2);
		 partie = baseJeu.getJeu();
		 
		 tour = partie.getNbTourPartieMax();
		 assertTrue(tour == 6);
	 }
	 
	 @Test
	 public void TestSetNbTourMax()
	 {
		 int tour;
		 baseJeu = new FabriqueBunco(2);
		 partie = baseJeu.getJeu();
		 partie.setNbTourPartieMax(8);
		 
		 tour = partie.getNbTourPartieMax();
		 assertTrue(tour == 8);
	 }
	 
	 @Test
	 public void TestGetJoueurActuel()
	 {
		 int joueur;
		 baseJeu = new FabriqueBunco(2);
		 partie = baseJeu.getJeu();
		 joueur = partie.getNumeroJoueurActuel();
		 
		 assertTrue(joueur == 1);
	 }
	 
	 @Test
	 public void TestGetFinTour()
	 {
		 boolean tour;
		 baseJeu = new FabriqueBunco(2);
		 partie = baseJeu.getJeu();
		 
		 tour = partie.getFinTour();
		 assertTrue(tour == false);
	 }
	 
	 @Test
	 public void TestSetFinTour()
	 {
		 boolean tour;
		 baseJeu = new FabriqueBunco(2);
		 partie = baseJeu.getJeu();
		 partie.setFinTour(true);
		 
		 tour = partie.getFinTour();
		 assertTrue(tour == true);
	 }
	 
	 @Test
	 public void TestGetScoreJoueur()
	 {
		 int score;
		 baseJeu = new FabriqueBunco(2);
		 partie = baseJeu.getJeu();
		 score = partie.getScoreJoueurActuel(1);
		 assertTrue(score == 0);
	 }
	 
	 @Test
	 public void TestGetVainqueurPartieNonFini()
	 {
		 int retour;
		 baseJeu = new FabriqueBunco(2);
		 partie = baseJeu.getJeu();
		 
		 retour = partie.getVainqueur();
		 assertTrue(retour == -1);
	 }
	 
	 @Test
	 public void TestGetVainqueurPartieFini()
	 {
		 int retour;
		 baseJeu = new FabriqueBunco(2);
		 partie = baseJeu.getJeu();
		 partie.setNbTour(7);
		 
		 retour = partie.getVainqueur();
		 assertTrue(retour == 2);
	 }
	 
	 @Test
	 public void TestGetScoreVainqueurPartieNonFini()
	 {
		 int retour;
		 baseJeu = new FabriqueBunco(2);
		 partie = baseJeu.getJeu();
		 
		 retour = partie.getScoreVainqueur();
		 assertTrue(retour == -1);
	 }
	 
	 @Test
	 public void TestGetScoreVainqueurPartieFini()
	 {
		 int retour;
		 baseJeu = new FabriqueBunco(2);
		 partie = baseJeu.getJeu();
		 
		 partie.setNbTour(7);
		 
		 retour = partie.getScoreVainqueur();
		 assertTrue(retour == 0);
	 }
	 
	 @Test
	 public void TestCollectionDes()
	 {
		 int nombreDes = 0;
		 baseJeu = new FabriqueBunco(2);
		 partie = baseJeu.getJeu();
		 
		 Iterator<De> itDe = partie.getCollectionDes().creerIterateur();
		 while(itDe.hasNext())
		    {
		        nombreDes++;
		        
		        itDe.next();
		    }
		 assertTrue(nombreDes == 3);
	 }
	 
	 @Test
	 public void TestCollectionJoueur()
	 {
		 int nombreJoueur = 0;
		 baseJeu = new FabriqueBunco(2);
		 partie = baseJeu.getJeu();
		 
		 Iterator<Joueur> itJoueur = partie.getCollectionJoueur().creerIterateur();
		 while(itJoueur.hasNext())
		    {
		        nombreJoueur++;
		        itJoueur.next();
		    }
		 assertTrue(nombreJoueur == 2);
	 }
	 
	 @Test
	 public void TestGetFace()
	 {
		 int face = 0;
		 baseJeu = new FabriqueBunco(2);
		 partie = baseJeu.getJeu();
		 face = partie.getNombreFace();
		 assertTrue(face == 6);
	 }
	 @Test
	 public void TestSetDes()
	 {
		 int nombreDes = 0;
		 partie = new Jeu(new Bunco());
		 partie.setDes(2, 6);
		 
		 Iterator<De> itDe = partie.getCollectionDes().creerIterateur();
		 while(itDe.hasNext())
		 {
		        nombreDes++;
		        itDe.next();
		  }
		 assertTrue(nombreDes == 2);
	 }
	 
	 @Test
	 public void TestSetJoueur()
	 {
		 int nombreJoueur = 0;
		 partie = new Jeu(new Bunco());
		 partie.setNbJoueur(3, 0);
		 
		 Iterator<Joueur> itJoueur = partie.getCollectionJoueur().creerIterateur();
		 while(itJoueur.hasNext())
		 {
			 nombreJoueur++;
			 itJoueur.next();
		 }
		assertTrue(nombreJoueur == 3);
	 }
	 
	 @Test
	 public void TestGenererDe()
	 {
		 boolean validation = true;
		 int faceActuelle = 0;
		 baseJeu = new FabriqueBunco(2);
		 partie = baseJeu.getJeu();
		 partie.genererDe();
		 
		 Iterator<De> itDe = partie.getCollectionDes().creerIterateur();
		 while(itDe.hasNext())
		    {
		        faceActuelle = itDe.next().getFace();
		        if(faceActuelle >= 1 && faceActuelle <= partie.getNombreFace())
		        {
		        	validation = true;
		        }
		        else
		        {
		        	validation = false;
		        }
		    }
		 assertTrue(validation == true);
	 }
	 
	 @Test
	 public void TestJouerTourFinal()
	 {
		 int retour = 0;
		 baseJeu = new FabriqueBunco(2);
		 partie = baseJeu.getJeu();
		 partie.setNbTour(7);
		 retour = partie.jouerTour();
		 assertTrue(retour == 3);
	 }
	 
	 @Test
	 public void TestJoueurJoueurSuivant()
	 {
		 int retour = 0;
		 baseJeu = new FabriqueBunco(2);
		 partie = baseJeu.getJeu();
		 retour = partie.jouerTour();
		 while(retour == 0)
		 {
			 retour = partie.jouerTour();
		 }
		 assertTrue(retour == 1);
	 }
	 
	 @Test
	 public void TestJoueurTourSuivant()
	 {
		 int retour = 0;
		 baseJeu = new FabriqueBunco(2);
		 partie = baseJeu.getJeu();
		 
		 partie.setNbJoueur(2, 0);
		 retour = partie.jouerTour();
		 while(retour == 0 || retour == 1)
		 {
			 retour = partie.jouerTour();
		 }
		 assertTrue(retour == 2);
	 }
}