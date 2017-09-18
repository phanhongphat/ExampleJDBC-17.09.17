package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.DBConnection;

import java.sql.*;


@WebServlet(name = "TestconnectionController", urlPatterns = { "/TestconnectionController" })
public class testConnectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public testConnectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		Connection conn = DBConnection.CreateConecction();
		
		PrintWriter out = response.getWriter();
		
		if (conn != null)
		{
			
			try 
			{
				out.println("<h1>Connection Success</h1>");
				conn.close();
			}
			catch (SQLException e)
			{	
				e.printStackTrace();
			}
		}
		else 
		{
			out.print("<h1>Connection Failed</h1>");
		}
	}
	

}
