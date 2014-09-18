<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>商品展示页</title>
<link rel="stylesheet" href="resource/css/css3.css"/>
</head>
<body>
 <div class="layout"> 
 <!-- title div  -->
  <div>
     <nav  id="title_nav">
       <span id="title_span">商品展示</span>
     </nav>
  </div>
  <!-- title div -->
  
  <!-- form div -->
  <div>
 <form method="post" action="shopping">
 <table>
 <tr>
 <td>
  <input type="checkbox" value="" name="sam"/></td><td>序号</td><td>产品名称</td><td>产品价格（¥）</td> 
 </tr>
  <input name="nextaction" value="add" type="hidden" />
 <tr>
  <td><input type="checkbox" value="1" name="proId"/></td><td>1</td> <td>农夫山泉</td> <td>2.0</td>
 </tr>
 <tr>
  <td><input type="checkbox" value="2" name="proId"/></td><td>2</td> <td>鼠标</td> <td>20.0</td> 
 </tr>
 <tr>
  <td><input type="checkbox" value="3" name="proId"/></td><td>3</td> <td>笔记本</td> <td>8.0</td>
 </tr>
 <tr>
  <td colspan="4" align="right">
    <input name="submit" type="submit" value="添加到购物车" />
  </td>
 </tr>
 </table>
 </form>
 </div>
 <!-- form div -->
 
 
 </div>
</body>
<script type="text/javascript">
</script>
</html>
