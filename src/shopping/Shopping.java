package shopping;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;



public class Shopping  extends HttpServlet {
	
	private final static String JDriver = "com.mysql.jdbc.Driver"; // MySQL提供的JDBC驱动，要保证它在CLASSPATH里可见
	private final static String conURL = "jdbc:mysql://9.115.93.73:3306/3Q_training"; // 本地计算机上的MySQL数据库Company的URL
	private final static String updateCart ="insert into t_map values (?,?,?)"; 
	   public void init()throws ServletException{      
//	        Map products = new HashMap();       
//	        products.put("1", new Product("1","农夫山泉","",2.0));          
//	        products.put("2", new Product("2","鼠标","",20.0));        
//	        products.put("3", new Product("3","笔记本","",8.0));
//	        ServletContext context = getServletContext();
//	        context.setAttribute("products", products);     
	    }    
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        doPost(request, response);
		    }
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
    	
    	Map products = new HashMap();
    	Map shopCart =  new HashMap();
    	LinkedList<String> cartIds = new LinkedList<String>();
    	String userid = (String)request.getSession().getAttribute("userid");
    	String shop =request.getParameter("shop");
    	
    	
    	Connection con = null;
		try {
		    Class.forName(JDriver);
			con = DriverManager.getConnection(conURL, "root","123456"); // 连接数据库
			Statement s = con.createStatement(); 
			
			ResultSet rs = s.executeQuery("select * from t_goods;"); // 物品列表
			while (rs.next()) { 
				products.put(rs.getString("Id"), new Product(rs.getString("Id"),rs.getString("goods_name"),"",rs.getDouble("value")));
			}
			
			
			String cartId = "";
			rs = s.executeQuery("select id from t_cart where user_id='"+userid+"'"); 
			if(rs.absolute(1)){
				cartId = rs.getString("id");
			}
		    
			
			
			Statement ss = con.createStatement(); 
			ResultSet rsCart = ss.executeQuery("select goods_id from t_map where cart_id='"+cartId+"'"); //该购物车列表
			while (rsCart.next()) { 
				cartIds.add(rsCart.getString("goods_id"));
			}
			
			
	        String cart =request.getParameter("cart");
	        String[] proIds = null;
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
	         
	          //更新购物车
	          Statement s1 = con.createStatement();
	          s1.execute("delete from t_map where cart_id='"+cartId+"'");
	          
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
				
				request.setAttribute("cartId", cartId);
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
