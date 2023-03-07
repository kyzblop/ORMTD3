package com.inti.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.inti.Article;
import com.inti.Commande;
import com.inti.Utilisateur;
import com.inti.util.HibernateUtil;

/**
 * Servlet implementation class CommandeServlet
 */
@WebServlet("/Commande")
public class CommandeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	private Logger log = LogManager.getLogger(CommandeServlet.class);
	private Session s;
	
    public CommandeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		s = HibernateUtil.getSessionFactory().openSession();
		log.info("Connection à la base de données");
		this.getServletContext().getRequestDispatcher("/WEB-INF/commande.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			s.beginTransaction();
			
			int idClient = Integer.valueOf(request.getParameter("idClient"));
			
			Utilisateur user1 = s.get(Utilisateur.class, idClient);
			
			//Commande com = new Commande(request.getParameter("description"), LocalDate.parse(request.getParameter("dateCom")));
			
			List<Article> listeArticle = new ArrayList<>();
			listeArticle.add(new Article(request.getParameter("article"),Integer.valueOf(request.getParameter("prix"))));
			Commande com = new Commande(LocalDate.parse(request.getParameter("dateCom")), user1, listeArticle);
			
			com.setUtilisateur(user1);
			
			s.save(com);
			log.info("Commande enregistrée");
			
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Commande annulée");
			s.getTransaction().rollback();
		}
		
		// Vers la servlet Paiement
		
		
	}

}
