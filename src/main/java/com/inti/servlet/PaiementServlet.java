package com.inti.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.inti.CB;
import com.inti.Paiement;
import com.inti.Paypal;
import com.inti.util.HibernateUtil;

/**
 * Servlet implementation class PaiementServlet
 */
@WebServlet("/PaiementServlet")
public class PaiementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private Logger log = LogManager.getLogger(PrincipaleServlet.class);
	private Session s;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaiementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		s = HibernateUtil.getSessionFactory().openSession();
		
		try {
			s.beginTransaction();
			
//			Paypal p1 = new Paypal(15, LocalDate.of(2022, 06, 15), 123456);
			CB p1 = new CB(20, LocalDate.of(2017,  12, 6), 456789, LocalDate.of(2025,  1, 14));
			
			s.save(p1);
			log.info("Transaction effectuée");
			
			s.getTransaction().commit();
			
		} catch (Exception e) {
			log.info("Transaction annulée");
			s.getTransaction().rollback();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
