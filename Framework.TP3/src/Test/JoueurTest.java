/******************************************************
Cours:  LOG121
Projet: Framework.TP3
Nom du fichier: Joueur.java
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

import org.junit.Test;

import Framework.Des.De;
import Framework.Des.Joueur;

/**
 * Classe qui permet de tester les méthode de la classe joueur
 * @author pc
 *
 */
public class JoueurTest {

	private Joueur j1 = new Joueur(0,0);
	private Joueur j2 = new Joueur(0,0);
	
	@Test
	public void ScoreSuperieurTest() {
		j1.setScoreJoueur(2);
		j2.setScoreJoueur(3);
		
		assertTrue(j1.compareTo(j2)==1);
	}
	
	@Test
	public void ScoreInferieurTest() {
		j1.setScoreJoueur(3);
		j2.setScoreJoueur(2);
		
		assertTrue(j1.compareTo(j2)==-1);
	}
	
	@Test
	public void memeScoreTest() {
		j1.setScoreJoueur(3);
		j2.setScoreJoueur(3);
		
		assertTrue(j1.compareTo(j2)==0);
	}
	
	@Test
	public void getScoreTest() {
		j1.setScoreJoueur(3);
		int score = j1.getScoreJoueur();
		
		assertTrue(score == 3);
	}
	
	@Test
	public void setScoreTest() {

		j1.setScoreJoueur(3);
		assertTrue(j1.getScoreJoueur() == 3);
	}
	
	@Test
	public void getNumeroJoueurTest() {

		j1 = new Joueur(1,1);
		assertTrue(j1.getNumeroJoueur() == 1);
	}
	
	

}
