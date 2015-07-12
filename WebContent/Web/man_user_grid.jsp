<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link  rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/Web/elearning.css">
<link  rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/Web/bootstrap-theme.css">
<link  rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/Web/bootstrap.css">  
<title>Insert title here</title>
</head>
<link  rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/Web/elearning.css">
<body >
<div id="content">
<h6 class="position">位置:用户管理</h6> 
	<h1 class="h1">用户列表</h1>
	<table width="800"  cellspacing="0" class="table table-hover">
		<thead>
			<tr class="success">
				<td width=100>用户名</td>
				<td width=100>姓名</td>
				<td width=100>密码</td>
				<td width=100>班级</td>
				<td width=100>身份</td>
				<td width=100>电话</td>
				<td width=100>操作</td>
			</tr>
		</thead>
		<s:iterator value="userlist" id="obj">
		<tr>
			<td><s:property value="#obj.eluserLoginname"></s:property></td>
			<td><s:property value="#obj.eluserName"></s:property></td>
			<td><s:property value="#obj.eluserPassword"></s:property></td>
			<td><s:property value="#obj.eluserClass"></s:property></td>
			<s:if test="#obj.eluserIdentity==1">			
			<td><s:property value=" '学生'"></s:property></td>
			</s:if>
			<s:elseif test="#obj.eluserIdentity==2">			
			<td><s:property value=" '教师'"></s:property></td>
			</s:elseif>
			<s:else>
			<td><s:property value=" '管理员'"></s:property></td>
			</s:else>
			<td><s:property value="#obj.eluserPhone"></s:property></td>
			<td><a href="ElUser!turnUpdateEluser?useraction.eluserId=<s:property value="#obj.eluserId"/>">修改用户</a>				
			</td>
		</tr>	
		</s:iterator> 
	</table>
</div>
</body>
</html>