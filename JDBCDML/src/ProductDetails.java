

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class DemoJDBC
 */
@WebServlet("/ProductDetails")
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
			Properties props = new Properties();
			props.load(in);
			
			DBConnection conn = new DBConnection(props.getProperty("url"),props.getProperty("user"), props.getProperty("password"));
			out.println("DB Connection Initialized <br>");
			
			Statement stmnt = conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rst = stmnt.executeQuery("Select * from eproduct");
			while (rst.next()) {
				out.println(rst.getInt("ID")+", "+ rst.getString("name")+", "+ rst.getBigDecimal("price")+", "+ rst.getDate("date_added")+"<br>");
			}
			out.println("Data Before DML operations <br>");
			
			stmnt.executeUpdate("insert into eproduct (name,price,date_added) values ('New Product1',18800.00,now())");
			out.println("Executed an Insert Statement <br>");
			
			stmnt.executeUpdate("update eproduct set price = 2000 where name = 'New Product'");
			out.println("Executed an Update Statement <br>");
			
			stmnt.executeUpdate("delete from eproduct where ID = 8");
			out.println("Executed a Delete Statement <br>");
			
			out.println("Data After	 DML operations <br>");
			rst = stmnt.executeQuery("Select * from eproduct");
			while (rst.next()) {
				out.println(rst.getInt("ID")+", "+ rst.getString("name")+"<br>");
			}
			
			stmnt.close();
			
			conn.closeConnection();
			out.println("DB Connection Closed <br>");
			out.println("</body></html>");
			conn.closeConnection();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
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
