<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"  %>
<%@ page language="java" import="shopping.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>购物车</title>
<link rel="stylesheet" href="resource/css/css3.css"/>
<script src="resource/js/jquery-1.11.1.js" type="text/javascript" ></script>
</head>
<body class="cart">
 <h1>购物车</h1>
 <form method="post" action="updateCart">

 <table class="cart" >
 <tr bgcolor="#FF8040">
 <td><input type="checkbox" value="" name="sam"/></td>
 <td>序号</td>
 <td>图片</td>
 <td>产品名称</td>
 <td>产品价格（¥）</td> 
 </tr>
 <% 
    Map shopCart = (Map)request.getAttribute("shopCart");
    String cartId = (String)request.getAttribute("cartId");
    String shop  =  request.getParameter("shop")==null?"":request.getParameter("shop");
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
  <td><input type="checkbox" value="<%=proId %>" name="proId"/></td>
  <td><%=order %></td>
  <td><img src="resource/img/<%=proId %>.jpg" ></td>
  <td><%=name %></td>
  <td><%=value %></td>
 </tr>
 <%
 	}
 %>
 
  <tr>
  <td colspan="4" align="right">总价</td><td style="color:red;"><%=total %></td>
 </tr>
 <tr>
  <td colspan="4"><a class="btn-buy" href="production<%=shop %>.jsp">返回商铺</a>&nbsp;</td><td><input name="submit" type="submit" value="删除所选商品" /></td>
 </tr>
</table>
  <input name="cartId" value="<%=cartId %>" type="hidden" />
</form>
</body>
</html>