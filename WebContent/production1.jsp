<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<%@ page language="java" import="java.util.*"  %>
<%@ page language="java" import="shopping.*" %>
<%@ page language="java" import="org.springframework.util.StringUtils" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>商铺商品展示页</title>
<link rel="stylesheet" href="resource/css/css3.css"/>
<script src="resource/js/jquery-1.11.1.js" type="text/javascript" ></script>
</head>
<body class="production">
     <nav  id="title_nav">
       <span id="title_span">展示商铺2</span>
     </nav>
<section>
<section class="layout">
 <form id="goodsForm" method="post" action="shopping?shop=1">
  <input name="nextaction" value="add" type="hidden" />
  <input type="hidden" name="cart"  value="" />
  <div class="row">
  <div class="goods">
    <div>
  	<img alt="户外鞋" src="resource/img/21.jpg">
  	</div>
  	<div class="btns">
  	 <input type="hidden" value="21" name="proId"/>
  	 <a class="btn-buy" onclick="buyToCart(this)">加入购物车</a>
  	 <span>户外鞋&nbsp;&nbsp;&nbsp;￥ 300</span>
  	 <a class="btn-buy" onclick="focusOn();"  style="float:right">关注</a>
  	</div>
  </div>
  
  <div class="goods">
     <div>
     <img alt="背包" src="resource/img/22.jpg">
     </div>
     <div class ="btns">
      <a class="btn-buy" onclick="buyToCart(this)">加入购物车</a>
      <input type="hidden" value="22" name="proId"/>
      <span>背包&nbsp;&nbsp;&nbsp;￥69.0</span>
       <a class="btn-buy" onclick="focusOn();" style="float:right">关注</a>
     </div>
  </div>
  
   <div class="goods">
     <div>
     <img alt="帐篷" src="resource/img/23.jpg">
     </div>
     <div class ="btns">
      <a class="btn-buy" onclick="buyToCart(this)">加入购物车</a>
      <input type="hidden" value="23" name="proId"/>
      <span>帐篷&nbsp;&nbsp;&nbsp;￥98.0</span>
       <a class="btn-buy" onclick="focusOn();" style="float:right">关注</a>
     </div>
  </div>
  </div>
   </form>
 </section>
 
 <section class="login">
 <form  id="userForm" method="post" action="login">
 <table>
<% 
 String userid = (String)request.getSession().getAttribute("userid");
 String type   = (String)request.getSession().getAttribute("type");
 String result = (String)request.getAttribute("result");
if(StringUtils.isEmpty(userid)){ 
%>
   <tr>
    <td>用户名</td><td><input type="text" name="userid" value="" style="width:80%"/></td>
   </tr>
   <tr>
     <td>密码</td><td><input type="password" name="password" value="" style="width:80%"/></td>
   </tr>
   <tr><td colspan="2"><a class="btn-buy" onclick="login()" style="width:80%">登录</a></td></tr>
   <tr><td colspan="2"><a class="btn-buy" href="production1.jsp" style="width:80%">去商铺1</a></td></tr>
 <% } else{ %>
   <tr><td colspan="2">欢迎你！<%=userid %></td></tr>
   <tr><td colspan="2"><a class="btn-buy" onclick="goCart();" style="width:80%">去购物车</a></td></tr>
   <tr><td colspan="2"><a class="btn-buy" href="production1.jsp" style="width:80%">去商铺1</a></td></tr>
 <% } %>
 </table>
 <input type="hidden" name="userid" value="<%=userid %>">
 </form>
 
   <div class="logo">
  	<img alt="logo" src="resource/img/logo2.jpg" />
   </div>
   <div>
    <span>
      本商铺出售各类户外用品。您的评论对我们非常重要，您收到货后麻烦先验货在签收，如果在商品使用过程中，出现任何问题，请不要轻易给我们中差评，联系我们在线客服或者027-84733006，我们都会第一时间及时为您处理的，您对宝贝和服务的满意，是我们一直的坚持，感谢您的支持！
    </span>
   </div>
 </section>
 
 </section>  
 

  </body>
<script type="text/javascript">
$(document).ready(function(){
	var result = "<%=result%>";
	if(result=="success"){
		alert("登录成功!");
	}else if(result=="fail"){
		alert("用户名或密码不正确!");
	}
})


function focusOn(){
	alert("关注成功");
}

function buyToCart(obj){
   if($("input[name=userid]").val()!=""){
		var goodsId = $(obj).parent().find("input[name=proId]").val();
		var cart = $("input[name=cart]").val();
		var ifExist = cart.indexOf(goodsId);
		if(ifExist!=-1){
			alert("该物品已在购物车中！");
		}else{
		$("input[name=cart]").val(cart+goodsId+",")
		   alert("已添加到购物车");
		}
   }else{
	   alert("请先登录");
	   return;
   }
}

function goCart(){
	$("#goodsForm").submit();
}

function login(){
	var userid = $("input[name=userid]").val();
	var password = $("input[name=password]").val();
	if(userid==""||password==""){
		alert("用户名密码不能为空");
	}else{
		$("#userForm").submit();
	}
}

</script>
</html>
