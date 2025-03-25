package H18;

import java.beans.Statement;
import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MotorsServlet
 */
@WebServlet("/MotorsServlet")
public class MotorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MotorsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		String username = "your_username";
        String password = "your_password";

        
        try {
            Class.forName("com.cj.mysql.jdbc.Driver");
           
            Connection conn = DriverManager.getConnection("jdbc:mysql:locolhost//3306/bike","root","tiger");

            
            Statement stmt = (Statement) conn.createStatement();
            ResultSet rs = ((java.sql.Statement) stmt).executeQuery("SELECT * FROM vehicle");

            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            out.println(username);
            out.println(password);

           
           
            
            
            
            rs.close();
            ((Closeable) stmt).close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
