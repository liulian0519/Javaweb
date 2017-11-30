<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="xupt.se.ttms.model.User" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登陆信息管理</title>
<style>
body {width:100%}
.table th, .table td {  
text-align: center;
height:30px;
} 
</style>
</head>
<body>

<div style="height:75px;line-height:75px;font-size:25px;vertical-align: middle;text-align: center" class="bg-primary">XXX影院管理系统</div>

<div class="row" style="padding:10px 10px">

	<!-- 左导航栏 -->
	<%@include file="../nav.jsp" %>
    
	<div class="col-md-10" style="padding-top:10px">
	
		<!-- 查询块 -->
		<div class="search" >
			<form class="form-inline" name="myForm" action="UserServlet?method=search" method="post">
				<!-- <input type="hidden" name="method" value="search"/> -->
				<input type="text" class="form-control" name="emp_no" value="${search_emp_no}"/>
				<input type="submit" class="btn btn-primary" value="查   询" />&nbsp;&nbsp;
				<input type="button" class="btn btn-danger" value="增   加" onclick="alert('打开增加登陆用户页面!')"/>
			</form>
		</div>
		
		
		<!-- 员工信息显示-->
		<div style="padding-top:10px;">
			<table class="table table-bordered table-hover" style="text-align:center;">
		   		<tr>
		   			<th>编号</th>
		   			<th>密码</th>
		   			<th>用户类型</th>
		   			<th colspan=2>操作</th>
		   		</tr>
		   		<%
                ArrayList<User> list=(ArrayList<User>)request.getAttribute("list");
                if(list!=null && list.size()>0)
                {
                    for(int i=0;i<list.size();i++)
                    {
                        if(i%2==0)
                            out.println("<tr class='success'>");
                        else
                            out.println("<tr class='active'>");
                %>
                    <th><%=list.get(i).getUser_no()%></th>
                    <th><%=list.get(i).getUser_pass()%></th>
                    <th><%=list.get(i).getUser_type()%></th>
                    <th><a href="">修改</a></th>
                    <th><a href="">删除</a></th>
                  
                </tr>
                <%
                    }
                }
                %>
			</table>
		</div>
		
	</div>
</div>

</body>
</html>