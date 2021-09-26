
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Servlet implementation class UserDetails
 */
@WebServlet("/UserDetails")
public class UserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<b>Session open </b><br>");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Transaction t = session.beginTransaction();
		out.println("<b>transaction open </b><br>");
		Account acct = new Account("Uname", "Upass");
		Address add = new Address("Street", "city", "State", 0000);
		User u = new User("name", "family", acct, add);
		
		//session.saveOrUpdate(u);

		session.save(u);

		t.commit();

		List<User> list = session.createQuery("from User").list();
		out.println("<b>user Listing</b><br>");
		
		
		
		for (User p : list) {

			out.println("Family : " + String.valueOf(p.getFamily()) + ",Name: " + p.getName() + ",Address : "
					+ String.valueOf(p.getAdd().getState()) + ",Account " + p.getAcct().getUsername() + "<br>");

		}
		session.close();

		out.println("<b>Session Closed save done</b><br>");
		out.println("</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
