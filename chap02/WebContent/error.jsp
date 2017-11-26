<%@ page pageEncoding="UTF-8" isErrorPage="true" errorPage="error.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 <base href="<%=basePath%>">
  <title>您所访问的页面不存在！</title>
  <link rel="stylesheet" href="css/style.css"/>
<link rel="stylesheet" href="css/base.css"/>
 </head>

 <body>
  <div id="errorpage">
    <div class="tfans_error">
        <div class="logo"></div>
        <div class="errortans clearfix">
           
            <p><b>出错啦！</b></p>
            <p>${desc}</p> 
            
            <div class="bt" ><a href="login.jsp">返回首页</a></div>
        </div>
    </div>
</div>
 </body>
</html>