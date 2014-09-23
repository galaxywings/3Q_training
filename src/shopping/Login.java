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

import org.springframework.util.StringUtils;


public class Login  extends HttpServlet {
	
	private final static String JDriver = "com.mysql.jdbc.Driver"; // MySQL提供的JDBC驱动，要保证它在CLASSPATH里可见
	private final static String conURL = "jdbc:mysql://192.168.1.7:3306/3Q_training"; // 本地计算机上的MySQL数据库Company的URL
	public void init()throws ServletException{      
	    }    
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        doPost(request, response);
		    }
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
    	
    	String userid = request.getParameter("userid");
    	String password   = request.getParameter("password");
    	
		try {
			Class.forName(JDriver);
			Connection con = DriverManager.getConnection(conURL, "root","123456"); // 连接数据库
			Statement s = con.createStatement(); // Statement类用来提交SQL语句
			
			
			ResultSet rs = s.executeQuery("select * from t_user where user_id ='"+userid+"' and password='"+password+"';");
			
			if(rs.next()){
				rs.absolute(1);
				request.getSession().setAttribute("type", rs.getString("type"));
				request.getSession().setAttribute("userid", userid);
				request.setAttribute("result", "success");
			}else{
				request.getSession().setAttribute("result", "fail");
				
			}
			
			rs.close();
			s.close();
			con.close(); 
		} catch (ClassNotFoundException cnf_e) { 
			System.out.println("Driver Not Found: " + cnf_e);
		} catch (SQLException sql_e) { 
			System.out.println(sql_e);
		}
        
		ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/production.jsp");
        dispatcher.forward(request, response);      
	    }
	
}
