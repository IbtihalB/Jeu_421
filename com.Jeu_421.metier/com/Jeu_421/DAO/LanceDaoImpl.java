package com.Jeu_421.DAO;

public class LanceDaoImpl extends JpaDaoImpl <model.Lance , Float> implements LanceDAO{

	private static LanceDaoImpl JDao;

	public LanceDaoImpl () {
		// TODO Auto-generated constructor stub
	}



    public static LanceDAO  getInstance() {
        if(JDao == null) {
            JDao = new LanceDaoImpl();
        }

        return JDao;
    }
}
