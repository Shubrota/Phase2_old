

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class InterfaceDemo
 */
@WebServlet("/InterfaceDemo")
public class InterfaceDemo implements Servlet {
	
	ServletConfig config =null;

    /**
     * Default constructor. 
     */
    public InterfaceDemo() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config)  {
		
		this.config=config;
		System.out.println("Initialization complete");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("In destroy() method");
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return config;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "This is a sample servlet info"; 
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pwriter = response.getWriter();
		pwriter.print("<html>");
		pwriter.print("<body>");
		pwriter.print("In the service method <br>");
		pwriter.print("</body>");
		pwriter.print("</html>");
	}

}
