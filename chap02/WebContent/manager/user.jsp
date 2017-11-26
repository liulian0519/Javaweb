<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>票务管理系统</title>
  <script src="js/jquery-2.1.0.js"></script>
  <link rel="stylesheet" type="text/css" href="css/search.css">
  <link rel="stylesheet" href="layui/css/layui.css">  
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <script src="bootstrap/js/bootstrap.min.js"></script>
  <script src="js/user.js"></script>
  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="false" errorPage="error.jsp"%>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <%@ page import="java.util.List" %>
  <%@page import="xupt.edu.ttms.model.Employee"%>
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
        <li class="layui-nav-item ">
        
          <a href="studio">演出厅管理</a>
         
        </li>
        <li class="layui-nav-item layui-nav-itemed sty">
          <a href="employee">用户管理</a>
         
        </li>
        
      </ul>
    </div>
  </div>
  
  <div>
    <!-- 内容主体区域 -->


<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content" >
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">添加信息</h4>
      </div>
      <div class="modal-body">
        <form action="add" method="post" >
          <div class="form-group">
            <label for="recipient-name" class="control-label">no:
            </label> <label id="name1_img"></label>
            <span id="name1_tip"></span>
            <input type="text" class="form-control" id="recipient-name1" onblur="checkid()" name="no"
            value="<%=request.getParameter("no")==null ? "":request.getParameter("no")%>" >
           
          </div>
          <div class="form-group">
            <label for="recipient-name" class="control-label">name:
            </label> <label id="name1_img"></label>
            <span id="name1_tip"></span>
            <input type="text" class="form-control" id="recipient-name1" onblur="checkid()" name="name"
            value="<%=request.getParameter("name")==null ? "":request.getParameter("name")%>" >
           
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">telNum:</label>
            <label id="name2_img"></label>
            <span id="name2_tip"></span>
            <input type="text" class="form-control" id="recipient-name2" onblur="name2()" name="telNum"
            value="<%=request.getParameter("telNum")==null ? "":request.getParameter("telNum")%>">
           
          </div>
          
          <div class="form-group">
              <label for="message-text" class="control-label">address:</label>
              <label id="name3_img"></label>
              <span id="name3_tip"></span>
              <input type="text" class="form-control" id="recipient-name3" onblur="name3()" name="address"
              value="<%=request.getParameter("address")==null ? "":request.getParameter("address")%>">
            
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">email:</label>
             <label id="name4_img"></label>
            <span id="name4_tip"></span>
            <input type="text" class="form-control" id="recipient-name4" onblur="name4()" name="email"
            value="<%=request.getParameter("email")==null ? "":request.getParameter("email")%>">
          </div>
             

        </form>
      </div>
      <div class="modal-footer">
        <button id="add" type="submit" class="btn btn-default" data-dismiss="modal" onclick="add()">添加</button>
       
      </div>
    </div>
  </div>
</div>

<form class="form-inline" action="employee" method ="post">
    <div class="form-group">
            <button type="button" class="btn btn-info" data-toggle="modal" data-target="#exampleModal" data-whatever="@getbootstrap" 
                style="margin-left: 230px;margin-top: 20px;">添加</button>
    </div>

     <div class="form-group" id="search">
        <input type="search" class="form-control" placeholder="search...">
        <button type="submit" class="btn btn-info">搜索</button>
      </div>
    <div style="padding: 15px;">

      <table class="table table-bordered" id="tab" style="width: 1460px; margin-left: 200px;">
      
<tbody id="tbody">
      <!-- On cells (`td` or `th`) -->
      <tr class="active">
        <th>id</th>
        <th>no</th>
        <th>name</th>
        <th>telNum</th>
        <th>address</th>
        <th>email</th>
        <th>Modify</th>
        <th>Delete</th>
      </tr>
      <%
    List<Employee> emp=(List<Employee>)request.getAttribute("employees");
    %>
      <%
        for(Employee employee:emp){
       %>
            <tr class="success">
                <td><%=employee.getEmp_id()%></td>
                <td><%=employee.getEmp_no()%></td>
                <td><%=employee.getEmp_name()%></td>
                <td><%=employee.getEmp_tel_num()%></td>
                <td><%=employee.getEmp_addr()%></td>
                <td><%=employee.getEmp_email()%></td>
                <td >           
                <button id ="modify" class="layui-btn layui-btn-warm layui-btn-radius" onclick="ModifyRow(this)"><i class="layui-icon"></i><a></a></button>    
                </td>
                <td >
                <button class="layui-btn layui-btn-danger layui-btn-radius" onclick="deleteRow(this)"><i class="layui-icon"></i><a></a></button>
                </td>
           </tr>
        <%
        }
        %>
      </tbody>
    </table>
    </div>
    </form>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © ppx - 剧院票务管理系统
  </div>
</div>
  <script src="layui/layui.js"></script>
</body>
</html>