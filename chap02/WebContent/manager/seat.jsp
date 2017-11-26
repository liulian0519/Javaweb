<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8" isErrorPage="false" errorPage="error.jsp"%>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>票务管理系统</title>
  <script src="js/jquery-2.1.0.js"></script>
  <link rel="stylesheet" type="text/css" href="css/search.css">
  <link rel="stylesheet" href="layui/css/layui.css">  
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="css/main.css" />
  <link rel="stylesheet" type="text/css" href="css/seat.css" />
  <script src="bootstrap/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/seat.js" ></script>
<title>在此处插入标题</title>
</head>
<body>
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">layui 剧院票务管理系统</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="images/person.png" class="layui-nav-img">
          贤心
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="../login.jsp">退出</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
        
          <a href="javascript:;">座位管理</a>
         
        </li>
        
        
      </ul>
    </div>
  </div>
  
  <div class="layui-body" style="background: #F2DEDE;">
    <!-- 内容主体区域 -->

   <div id="main" style="margin-top: 60px;">
   <h2 class="top_title">PPX剧院座位管理</h2>
   <div class="demo">
        <div id="seat-map">
            <div class="front">屏幕</div>
        </div>
        <div class="booking-details">
            <p>影片：<span>星际穿越</span></p>
            <p>时间：<span>11月14日 21:00</span></p>
            <p>座位：</p>
            <ul id="selected-seats"></ul>
            <p>票数：<span id="counter">0</span></p>
            <p>总计：<b>￥<span id="total">0</span></b></p>

            <button class="checkout-button">确定购买</button>

            <div id="legend"></div>
        </div>
        <div style="clear:both"></div>
        
   </div>

<br />

   <button id="btn"><a href="../employee">返回</a></button>

<script src="layui/layui.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>


<script>
//Demo
layui.use('form', function(){
  var form = layui.form;
  
  //监听提交
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
});


</script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.seat-charts.min.js"></script>

</body>
</html>