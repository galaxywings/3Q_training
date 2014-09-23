package shopping;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

public class UpdateCart extends HttpServlet  {
	private final static String JDriver = "com.mysql.jdbc.Driver"; // MySQL提供的JDBC驱动，要保证它在CLASSPATH里可见
	private final static String conURL = "jdbc:mysql://192.168.1.7:3306/3Q_training"; // 本地计算机上的MySQL数据库Company的URL
	private final static String updateCart ="delete from t_map where goods_id = ? and cart_ id = ?"; 
	   public void init()throws ServletException{      
	        
	    }    
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        doPost(request, response);
		    }
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
    	
    	String[] proIds = request.getParameterValues("proId");
    	
    	Connection con = null;
		try {
		    Class.forName(JDriver);
			con = DriverManager.getConnection(conURL, "root","123456"); // 连接数据库
			Statement s = con.createStatement(); 
			
			
	        String cart =request.getParameter("cart");
	        if(!StringUtils.isEmpty(cart)){
	        	proIds= cart.split(",");
		        for(int i= proIds.length-1;i>=0;i--){
		        	cartIds.add(proIds[i]);
		        }
	        }
	        
	          if(cartIds.size()>0){
	            for(int i=cartIds.size()-1;i>=0;i--){
		                Product product = (Product)products.get(cartIds.get(i));             
		                if(shopCart.get(cartIds.get(i))==null){//the product isn't in shopCart
		                	shopCart.put(cartIds.get(i), product);
		                }  
	            }
	          }
	          
	          PreparedStatement prest = con.prepareStatement(updateCart);
	          Iterator it = shopCart.keySet().iterator(); 
	          while (it.hasNext()) { 
	        	Product product  = (Product)shopCart.get(it.next().toString());
    	        prest.setString(1,UUID.randomUUID().toString());   
    	        prest.setString(2,cartId);   
    	        prest.setString(3,product.getProductId());   
    	        prest.addBatch();   
	          }
	          prest.executeBatch();   
	          
				rs.close();
				rsCart.close();
				s.close();
				ss.close();
		} catch (SQLException sql_e) { 
			System.out.println(sql_e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
        
        ServletContext context = getServletContext();
        request.setAttribute("shopCart", shopCart);
        RequestDispatcher dispatcher = context.getRequestDispatcher("/shoppingCart.jsp");
        dispatcher.forward(request, response); 
        
	    }
}
