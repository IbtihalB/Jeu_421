package com.Jeu_421.servlet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AccesDiceJPA {
	// le gestionnaire d'entit� qu'on utilisera pour acc�der � la base � sports �
	 private EntityManager em = null;
	 // retourne le gestionnaire d'entit� en l'instanciant au besoin
	 public EntityManager getEntityManager() {
	 if (em == null) {
	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("Dice");
	 em = emf.createEntityManager();
	 }
	 return em;
	 }
	 // ferme le gestionnaire d'entit�
	 public void closeEntityManager() {
	 if (em != null) { em.close(); em = null; }
	 }

}
