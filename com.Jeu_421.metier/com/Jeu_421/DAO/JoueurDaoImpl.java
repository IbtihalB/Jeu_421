package com.Jeu_421.DAO;

import model.Joueur;

public class JoueurDaoImpl extends JpaDaoImpl <model.Joueur , String> implements JoueurDAO{
	private static JoueurDaoImpl JDao;

	public JoueurDaoImpl () {
		// TODO Auto-generated constructor stub
	}



    public static JoueurDAO  getInstance() {
        if(JDao == null) {
            JDao = new JoueurDaoImpl();
        }

        return JDao;
    }
}
