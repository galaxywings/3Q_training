package shopping;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Welcome  extends HttpServlet {
	
	private static boolean open = true; 
	public void init()throws ServletException{      
	    }    
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        doPost(request, response);
		    }
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
    	
       
		ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/production.jsp");
        dispatcher.forward(request, response);      
	    }
	
}
