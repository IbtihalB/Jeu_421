package com.Jeu_421.DAO;

public class PartieJoueurPKDaoImpl extends JpaDaoImpl <model.PartieJoueurPK , Float> implements PartieJoueurPKDAO{

	private static PartieJoueurPKDaoImpl JDao;

	public PartieJoueurPKDaoImpl () {
		// TODO Auto-generated constructor stub
	}



    public static PartieJoueurPKDAO  getInstance() {
        if(JDao == null) {
            JDao = new PartieJoueurPKDaoImpl();
        }

        return JDao;
    }
}