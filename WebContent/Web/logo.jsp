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
<body>


<div id="logo" >
	<div id="logoch">
		欢迎,<s:property value="#session.sysUser.eluserName"/><a href="javascript:login();">退出</a></div>
</div>
<script>
function login()
{
	
	window.parent.location="login.jsp";
}
</script>
</body>
</html>