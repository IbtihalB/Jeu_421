package com.Jeu_421.DAO;

public class PartieJoueurDaoImpl extends JpaDaoImpl <model.PartieJoueur , Float> implements PartieJoueurDAO{

	private static PartieJoueurDaoImpl JDao;

	public PartieJoueurDaoImpl () {
		// TODO Auto-generated constructor stub
	}



    public static PartieJoueurDAO  getInstance() {
        if(JDao == null) {
            JDao = new PartieJoueurDaoImpl();
        }

        return JDao;
    }
}