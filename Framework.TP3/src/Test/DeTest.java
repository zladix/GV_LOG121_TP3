/******************************************************
Cours:  LOG121
Projet: Framework.TP3
Nom du fichier: DeTest.java
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


/**
 * Classe qui permet de tester les méthode de la classe De
 * @author pc
 *
 */
public class DeTest {

	private De de1 = new De();
	private De de2 = new De();
	
	@Test
	public void deSuperieurTest() {
		de1.setFace(2);
		de2.setFace(3);
		
		assertTrue(de1.compareTo(de2)==1);
	}
	
	@Test
	public void deInferieurTest() {
		de1.setFace(3);
		de2.setFace(2);
		
		assertTrue(de1.compareTo(de2)==-1);
	}
	
	@Test
	public void memeDeTest() {
		de1.setFace(3);
		de2.setFace(3);
		
		assertTrue(de1.compareTo(de2)==0);
	}
	
	@Test
	public void getFaceTest() {
		de1.setFace(3);
		int face = de1.getFace();
		
		assertTrue(face == 3);
	}
	
	@Test
	public void setFaceTest() {

		de1.setFace(3);
		assertTrue(de1.getFace() == 3);
	}
	

}
