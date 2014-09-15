<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"  %>
<%@ page language="java" import="shopping.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ShoppingCart</title>
</head>
<body>
 <h1>购物车</h1>
 <form method="post" action="shopping">
 <table border="1">
 <tr bgcolor="#996699">
 <td><input type="checkbox" value="" name="sam"/></td><td>序号</td><td>产品名称</td><td>产品价格（¥）</td> 
 </tr>
 <input name="nextaction" value="del" type="hidden" />
 <% 
    Map shopCart = (Map)request.getSession().getAttribute("shopCart");
 	Iterator it = shopCart.keySet().iterator(); 
 	int i = 0;
 	double total = 0.0;
 	while (it.hasNext()) { 
 		i++;
 		Product product  = (Product)shopCart.get(it.next().toString());
 		String proId = product.getProductId();
 		String name = product.getProductName();
 		String value = String.valueOf(product.getValue());
 		String order = String.valueOf(i);
 		total+= product.getValue();
 %>
 <tr>
  <td><input type="checkbox" value="<%=proId %>" name="proId"/></td><td><%=order %></td> <td><%=name %></td> <td><%=value %></td>
 </tr>
 <%
 	}
 %>
  <tr>
  <td colspan="3" align="right">总价</td><td><%=total %></td>
 </tr>
 <tr>
  <td colspan="4" align="right"><input name="submit" type="submit" value="删除所选商品" /></td>
 </tr>

</body>
</html>