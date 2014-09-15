package shopping;

import java.io.IOException;
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
	   public void init()throws ServletException{      
	        
	        Map products = new HashMap();       
	        products.put("1", new Product("1","农夫山泉","",2.0));          
	        products.put("2", new Product("2","鼠标","",20.0));        
	        products.put("3", new Product("3","笔记本","",8.0));
	        ServletContext context = getServletContext();
	        context.setAttribute("products", products);     
	    }    
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        doPost(request, response);
		    }
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	        
    		String nextaction = request.getParameter("nextaction");
	        String proIds[] = request.getParameterValues("proId");
	        ServletContext context = getServletContext();
	        Map products = (Map) context.getAttribute("products");
	        
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
