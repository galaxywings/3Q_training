<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>商铺商品展示页</title>
<link rel="stylesheet" href="resource/css/css3.css"/>
<script src="resource/js/jquery-1.11.1.js" type="text/javascript" ></script>
</head>
<body>
     <nav  id="title_nav">
       <span id="title_span">展示商铺1</span>
     </nav>
<section>
<section class="layout">
 <form id="goodsForm" method="post" action="shopping">
  <input name="nextaction" value="add" type="hidden" />
  <input type="hidden" name="cart"  value="" />
  <div class="row">
  <div class="goods">
    <div>
  	<img alt="农夫山泉" src="resource/img/water.jpg">
  	</div>
  	<div class="btns">
  	 <input type="hidden" value="1" name="proId"/>
  	 <a class="btn-buy" onclick="buyToCart(this)">加入购物车</a>
  	 <span>农夫山泉&nbsp;&nbsp;&nbsp;￥ 24.9</span>
  	 <a class="btn-buy" onclick="focusOn();"  style="float:right">关注</a>
  	</div>
  </div>
  
  <div class="goods">
     <div>
     <img alt="鼠标" src="resource/img/mouse.jpg">
     </div>
     <div class ="btns">
      <a class="btn-buy" onclick="buyToCart(this)">加入购物车</a>
      <input type="hidden" value="2" name="proId"/>
      <span>鼠标&nbsp;&nbsp;&nbsp;￥20.0</span>
       <a class="btn-buy" onclick="focusOn();" style="float:right">关注</a>
     </div>
  </div>
  
  <div class="goods">
    <div>
     <img alt="笔记本" src="resource/img/laptop.jpg">
    </div>
    <div  class ="btns">
      <a class="btn-buy" onclick="buyToCart(this)">加入购物车</a>
      <span>笔记本&nbsp;&nbsp;&nbsp;￥3599.0</span>
       <input type="hidden" value="3" name="proId"/>
       <a class="btn-buy" onclick="focusOn();" style="float:right">关注</a>
    </div>
  </div>
  
  </div>
  
    <div class="row">
  
  <div class="goods">
    <div>
  	<img alt="洗衣机" src="resource/img/xyj.jpg">
  	</div>
  	<div class="btns">
  	<input type="hidden" value="4" name="proId"/>
  	 <a class="btn-buy"  onclick="buyToCart(this)">加入购物车</a>
  	 <span>洗衣机&nbsp;&nbsp;&nbsp;￥ 4000</span>
  	 <a class="btn-buy" onclick="focusOn();" style="float:right">关注</a>
  	</div>
  </div>
  
  <div class="goods">
     <div>
     <img alt="饮水机" src="resource/img/ysj.jpg">
     </div>
     <div class ="btns">
      <a class="btn-buy" onclick="buyToCart(this)">加入购物车</a>
      <input type="hidden" value="5" name="proId"/>
      <span>饮水机&nbsp;&nbsp;&nbsp;￥280.0</span>
       <a class="btn-buy" onclick="focusOn();" style="float:right">关注</a>
     </div>
  </div>
  
  <div class="goods">
    <div>
     <img alt="电话机" src="resource/img/phone.jpg">
    </div>
    <div  class ="btns">
      <a class="btn-buy" onclick="buyToCart(this)">加入购物车</a>
      <input type="hidden" value="6" name="proId"/>
      <span>电话机&nbsp;&nbsp;&nbsp;￥78.0</span>
       <a class="btn-buy" onclick="focusOn();" style="float:right">关注</a>
    </div>
  </div>
  
  </div>
   </form>
 </section>
 
 <section class="login">
 <form action="">
 <table>
   <tr>
    <td>用户名</td><td><input type="text" value="" /></td>
   </tr>
   <tr>
     <td>密码</td><td><input type="password" value="" /></td>
   </tr>
   <tr><td colspan="2"><a class="btn-buy" style="width:80%">登录</a></td></tr>
   <tr><td colspan="2"><a class="btn-buy" onclick="goCart();" style="width:80%">去购物车</a></td></tr>
 </table>
 </form>
 
   <div class="logo">
  	<img alt="农夫山泉" src="resource/img/logo1.jpg" />
   </div>
 </section>
 
 </section>  
 

  </body>
<script type="text/javascript">
function focusOn(){
	alert("关注成功");
}

function buyToCart(obj){
	var goodsId = $(obj).parent().find("input[name=proId]").val();
	var cart = $("input[name=cart]").val();
	var ifExist = cart.indexOf(goodsId);
	if(ifExist!=-1){
		alert("该物品已在购物车中！");
	}else{
	$("input[name=cart]").val(cart+goodsId+",")
	   alert("已添加到购物车");
	}
}

function goCart(){
	var cart = $("input[name=cart]").val();
	if(cart==""){
		alert("请选择商品！");
	}else{
		$("#goodsForm").submit();
	}

}

</script>
</html>
