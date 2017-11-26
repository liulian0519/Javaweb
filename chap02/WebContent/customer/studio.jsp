<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="xupt.edu.ttms.model.Studio"%>
<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="false" errorPage="error.jsp"%>
    <%@ page import="java.util.List" %>
    <%@page import="xupt.edu.ttms.model.Employee"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>票务管理系统</title>
    <script src="js/jquery-2.1.0.js"></script>
    <link rel="stylesheet" type="text/css" href="css/search.css">
    <link rel="stylesheet" href="layui/css/layui.css">  
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="js/index.js"></script>
    <title>在此处插入标题</title>
</head>
<body>
    <div class="layui-layout layui-layout-admin">
    <div class="layui-header">
    <div class="layui-logo">剧院票务管理系统</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="images/person.png" class="layui-nav-img">
                管理员
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="login.jsp">退出</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed sty">
          <a href="cstudio">演出厅管理</a>
        </li>
               
      </ul>
    </div>
  </div>
  
  <div>
    <!-- 内容主体区域 -->




<form class="form-inline" action="cstudio" method="post">
    <div class="form-group">
            <button type="button" class="btn btn-info" data-toggle="modal" data-target="#exampleModal" data-whatever="@getbootstrap" 
                style="margin-left: 230px;margin-top: 20px;">添加</button>
    </div>

     <div class="form-group" id="search">
        <input type="search" class="form-control" placeholder="search...">
        <button type="submit" class="btn btn-info">搜索</button>
      </div>
</form>
     
      

    <div style="padding: 15px;">

      <table class="table table-bordered" id="tab" style="width: 1460px; margin-left: 200px;">
      
<tbody id="tbody">
    

      <!-- On cells (`td` or `th`) -->
      <tr class="active">
        <td >id</td>
        <td >name</td>
        <td >行数</td>
        <td >列数</td>
        <td >简介</td>       
        <td>座位</td>
      </tr>
       <%
    List<Studio> stu=(List<Studio>)request.getAttribute("studios");
    %>
      <%
        for(Studio studio:stu){
       %>
            <tr class="success">
                <td><%=studio.getStudio_id()%></td>
                <td><%=studio.getStudio_name()%></td>
                <td><%=studio.getStudio_row_count()%></td>
                <td><%=studio.getStudio_col_count()%></td>
                <td><%=studio.getStudio_introduction()%></td>
                <td >
                    <button class="layui-btn layui-btn-radius" onclick="Toseat1(this)"><i class="layui-icon"></i></button>
                </td>
           </tr>
        <%
        }
        %>
      </tbody>
    </table>
    </div>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © layui.com - 底部固定区域
  </div>
</div>
  <script src="layui/layui.js"></script>
    
</body>
</html>