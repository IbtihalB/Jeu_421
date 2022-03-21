package com.Jeu_421.servlet;

import java.io.Console;
import java.io.IOException;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Jeu_421.DAO.DaoFactory;

import model.Joueur;




@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
   /*private AuteurInterface AuteurI;  */ 
   
   public void init()throws ServletException
   {
	   
	    
  // this.AuteurI=daoFactory.getAuteurInterface();
   }
   
    public Accueil() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		/*response.getWriter().append("Served at: ").append(request.getContextPath());
		String name=request.getParameter("name");
		request.setAttribute("name",name);
		Auteur auteur=new Auteur();
		auteur.setNom("nb,;");
		auteur.setPrenom("hgjhk");
		auteur.setActif(false);
		request.setAttribute("auteur",auteur);*/

		//Joueur joeur1=new Joueur("jnjk","djkndk");
	   // em.persist(joeur1);
	   // Query query = (Query) em.createQuery("select Dice.pseudo from Dice.Joueur ");
	    /*java.util.List noms = ((javax.persistence.Query) query).getResultList();
	   
	    Joueur personne = em.find(Joueur.class,"b1" );
	    if (personne == null) {
	        System.out.println("Personne non trouvée");}
		request.setAttribute("personne",noms);*/
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jeu_421");
	    EntityManager em = emf.createEntityManager();
	   
	    
	   
	    Joueur joeur1=new Joueur("jnjk","djkndk");
		em.persist(joeur1);
		
	    Joueur personne = em.find(Joueur.class,"b1" );
	    request.setAttribute("personne",personne.getMotDePasse());
		request.getRequestDispatcher("./vues/Accueil.jsp").forward(request,response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
