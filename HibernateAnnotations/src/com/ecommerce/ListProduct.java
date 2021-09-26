package com.ecommerce;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import org.apache.logging.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Servlet implementation class ListProduct
 */
@WebServlet("/ListProduct")
public class ListProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
        
		List <EProduct> list = session.createQuery("from EProduct").list();

		
		
		session.close();
		
		
		Logger logger
        = Logger.getLogger(
        		ListProduct.class.getName());

		

		    
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<b>Product Listing</b><br>");
		for(EProduct p:list) {
			
			logger.info("ID:"+String.valueOf(p.getId()));
			out.println("ID:"+String.valueOf(p.getId())+",Name: "+p.getName()+",Price : "+String.valueOf(p.getPrice()) +",Date Added "+p.getDateAdded().toString()+"<br>");
			
		
		}
		out.println("</body></html>");
		} catch(Exception e) {
			throw e;
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
