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

<title>登入界面</title>

</head>
<body>
 <div id="login">

<div id="login_form">
	<s:form action="Login" method="post" theme="simple">
	<table>
	<tr>
		<td>用户名：</td>
		<td><s:textfield  label="用户名" name="user.eluserLoginname"></s:textfield></td>
	</tr>
	
	<tr>
		<td>密码：</td>
		<td><s:password   label="密码" name="user.eluserPassword" ></s:password></td>
	</tr>
	</table>	
	<div id="login9"><font color="red"><s:property value="error"></s:property></font></div>
	<div id="p8"><s:submit value="登入"/>
	<s:reset value="清空"/></div>
	</s:form>
</div>
</div>
</body>
</html>