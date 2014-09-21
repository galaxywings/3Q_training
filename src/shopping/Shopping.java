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


public class Shopping  extends HttpServlet {
	
	private final static String JDriver = "com.mysql.jdbc.Driver"; // MySQL提供的JDBC驱动，要保证它在CLASSPATH里可见
	private final static String conURL = "jdbc:mysql://localhost:3306/3Q_training"; // 本地计算机上的MySQL数据库Company的URL
	
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
    	
		try {
			Class.forName(JDriver);
			Connection con = DriverManager.getConnection(conURL, "root","123456"); // 连接数据库
			Statement s = con.createStatement(); // Statement类用来提交SQL语句
			
			
			ResultSet rs = s.executeQuery("select * from t_goods;"); // 提交查询，返回的表格保存在rs中
			while (rs.next()) { // ResultSet指针指向下一个“行”
//				System.out.println(rs.getInt("Id") + "\t"
//						+ rs.getString("goods_name")+ "\t"
//								+ rs.getBigDecimal("value"));
				products.put(rs.getString("Id"), new Product(rs.getString("Id"),rs.getString("goods_name"),"",rs.getDouble("value")));
			}
			
			rs.close();
			s.close();// 释放Statement对象
			con.close(); // 关闭到MySQL服务器的连接
		} catch (ClassNotFoundException cnf_e) { // 如果找不到驱动类
			System.out.println("Driver Not Found: " + cnf_e);
		} catch (SQLException sql_e) { // 都是SQLException
			System.out.println(sql_e);
		}
		
		String nextaction = request.getParameter("nextaction");
        String car =request.getParameter("cart");
        String[] proIds = car.split(",");
        ServletContext context = getServletContext();
        
        Map shopCart = (Map)request.getSession().getAttribute("shopCart");
        if(shopCart == null){
            shopCart = new HashMap();
        }       
        if(nextaction.equals("add")&&proIds!=null){
            for(int i=0;i<proIds.length;i++){
                Product product = (Product)products.get(proIds[i]);             
                if(shopCart.get(proIds[i])==null){//the product isn't in shopCart
                	shopCart.put(proIds[i], product);
                }                
            }
        }else if(nextaction.equals("del")&&proIds!=null){
            for(int i=0;i<proIds.length;i++){
            	 shopCart.remove(proIds[i]);
            }
        }           
        
        request.getSession().setAttribute("shopCart", shopCart);
        RequestDispatcher dispatcher = context.getRequestDispatcher("/shoppingCart.jsp");
        dispatcher.forward(request, response);      
	    }
	
}
