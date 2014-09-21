<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>商铺商品展示页</title>
<link rel="stylesheet" href="resource/css/css3.css"/>
</head>
<body>
     <nav  id="title_nav">
       <span id="title_span">展示商铺1</span>
     </nav>
     
<div class="layout">
 <form method="post" action="shopping">
  <input name="nextaction" value="add" type="hidden" />

  <div class="row">
  
  <div class="goods">
    <div>
  	<img alt="农夫山泉" src="resource/img/water.jpg">
  	</div>
  	<div class="btns">
  	 <a class="btn-buy">加入购物车</a>
  	 <span>农夫山泉&nbsp;&nbsp;&nbsp;￥ 24.9</span>
  	 <a class="btn-buy" style="float:right">关注</a>
  	</div>
  </div>
  
  <div class="goods">
     <div>
     <img alt="鼠标" src="resource/img/mouse.jpg">
     </div>
     <div class ="btns">
      <a class="btn-buy">加入购物车</a>
      <input type="hidden" value="2" name="proId"/>
      <span>鼠标&nbsp;&nbsp;&nbsp;￥20.0</span>
       <a class="btn-buy" style="float:right">关注</a>
     </div>
  </div>
  
  <div class="goods">
    <div>
     <img alt="笔记本" src="resource/img/laptop.jpg">
    </div>
    <div  class ="btns">
      <a class="btn-buy">加入购物车</a>
      <input type="hidden" value="3" name="proId"/>
      <span>笔记本&nbsp;&nbsp;&nbsp;￥3599.0</span>
       <a class="btn-buy" style="float:right">关注</a>
    </div>
  </div>
  
  </div>
  
    <div class="row">
  
  <div class="goods">
    <div>
  	<img alt="洗衣机" src="resource/img/xyj.jpg">
  	</div>
  	<div class="btns">
  	 <a class="btn-buy">加入购物车</a>
  	 <span>洗衣机&nbsp;&nbsp;&nbsp;￥ 4000</span>
  	 <a class="btn-buy" style="float:right">关注</a>
  	</div>
  </div>
  
  <div class="goods">
     <div>
     <img alt="饮水机" src="resource/img/ysj.jpg">
     </div>
     <div class ="btns">
      <a class="btn-buy">加入购物车</a>
      <input type="hidden" value="2" name="proId"/>
      <span>饮水机&nbsp;&nbsp;&nbsp;￥280.0</span>
       <a class="btn-buy" style="float:right">关注</a>
     </div>
  </div>
  
  <div class="goods">
    <div>
     <img alt="电话机" src="resource/img/phone.jpg">
    </div>
    <div  class ="btns">
      <a class="btn-buy">加入购物车</a>
      <input type="hidden" value="3" name="proId"/>
      <span>电话机&nbsp;&nbsp;&nbsp;￥78.0</span>
       <a class="btn-buy" style="float:right">关注</a>
    </div>
  </div>
  
  </div>
   </form>
 </div>
 <footer>商品最终解释权归商铺所有</footer>
  </body>
<script type="text/javascript">
</script>
</html>
