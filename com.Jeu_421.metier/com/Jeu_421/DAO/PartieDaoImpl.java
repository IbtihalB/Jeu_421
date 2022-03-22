package com.Jeu_421.DAO;

public class PartieDaoImpl extends JpaDaoImpl <model.Partie , Float> implements PartieDAO{

	private static PartieDaoImpl JDao;

	public PartieDaoImpl () {
		// TODO Auto-generated constructor stub
	}



    public static PartieDAO  getInstance() {
        if(JDao == null) {
            JDao = new PartieDaoImpl();
        }

        return JDao;
    }
}
