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

public class UpdateCart extends HttpServlet {
	private final static String JDriver = "com.mysql.jdbc.Driver"; // MySQL提供的JDBC驱动，要保证它在CLASSPATH里可见
	private final static String conURL = "jdbc:mysql://9.115.93.73:3306/3Q_training"; // 本地计算机上的MySQL数据库Company的URL
	private final static String updateCart = "delete from t_map where goods_id = ? and cart_id = ?";

	public void init() throws ServletException {

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] proIds = request.getParameterValues("proId");
		String cartId = request.getParameter("cartId");
		
		Map products = new HashMap();
		Map shopCart = new HashMap();
		Connection con = null;
		try {
			Class.forName(JDriver);
			con = DriverManager.getConnection(conURL, "root", "123456"); // 连接数据库
			Statement s = con.createStatement();

			PreparedStatement prest = con.prepareStatement(updateCart);
			for (int i = proIds.length - 1; i >= 0; i--) {
				prest.setString(1, proIds[i]);
				prest.setString(2, cartId);
				prest.addBatch();
			}
			prest.executeBatch();

			ResultSet rs = s.executeQuery("select * from t_goods;"); // 物品列表
			while (rs.next()) {
				products.put(rs.getString("Id"),new Product(rs.getString("Id"),rs.getString("goods_name"), "", rs.getDouble("value")));
			}

			Statement ss = con.createStatement(); 
			ResultSet rsCart = ss.executeQuery("select goods_id from t_map where cart_id='"+cartId+"'"); //该购物车列表
			while (rsCart.next()) {
				Product product = (Product)products.get(rsCart.getString("goods_id")); 
				shopCart.put(rsCart.getString("goods_id"), product);
			}
			
			rs.close();
			rsCart.close();
			s.close();
			ss.close();
			
			request.setAttribute("cartId", cartId);
		} catch (SQLException sql_e) {
			System.out.println(sql_e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		ServletContext context = getServletContext();
		request.setAttribute("shopCart", shopCart);
		RequestDispatcher dispatcher = context
				.getRequestDispatcher("/shoppingCart.jsp");
		dispatcher.forward(request, response);

	}
}
