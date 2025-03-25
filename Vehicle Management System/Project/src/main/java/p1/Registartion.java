package p1;
import java.sql.*;
import java.sql.Statement;
import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registartion
 */
@WebServlet("/Registartion")
public class Registartion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registartion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();

        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            pw.println("Driver Loaded");
           
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bikes","root","tiger");

            pw.println("Connection Established");
            
            
            String insertQuery = "INSERT INTO user (user_email,user_name,user_pass) VALUES (?,?,?)";
            
            PreparedStatement ps=conn.prepareStatement(insertQuery);
            	ps.setString(1,request.getParameter("t1"));
            	ps.setString(2,request.getParameter("t2"));
            	ps.setString(3,request.getParameter("t3 "));
            	ps.executeUpdate();
            	pw.println("Inserted");
            	
            
            
             conn.close();
        } catch (Exception e) {
        	pw.println(e);
        }
	}

}
