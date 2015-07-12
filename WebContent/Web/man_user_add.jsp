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
<title>用户添加</title>
</head>
<body >
 <div id="content">
 <h6 class="position">位置:用户新增</h6> 
	<h1 class="h1">用户新增</h1>
	<div id="elform_user">
		<s:form action="ElUser" method="POST" theme="simple">
			<!--学号, 详细资料,姓名,密码,是否冻结,班级,身份,空值1,空值2<br>-->
			<div id="p1">用户名：<s:textfield   value="" name="useraction.eluserLoginname"  maxlength="20"></s:textfield></div> 
			<div id="p2"><s:textfield id="elformp2" value="" name="useraction.eluserName"  maxlength="10">姓名：</s:textfield></div>
			<div id="p3">密码：&nbsp;&nbsp;  <s:password  id="elformp3"		value="" name="useraction.eluserPassword"  maxlength="20"></s:password></div>
			<div id="p5"><s:textfield value="" name="useraction.eluserClass" maxlength="16" >班级：</s:textfield></div>
			<div id="p6">身份：&nbsp;&nbsp;<s:select    list="#{'1':'学生','2':'教师','3':'管理员'  }" name="useraction.eluserIdentity">  </s:select></div>
			<div id="p7"><s:textfield value="" name="useraction.eluserPhone" maxlength="20">电话：</s:textfield><br> 	</div>
			<div id="p8"><s:submit name="add"    method="addEluser"    value="新增"></s:submit>
			<s:submit name="loadAllEluser"    method="loadAllEluser"    value="返回"></s:submit></div>
			<div id="p9"><font color="red"><s:property value="error"></s:property></font></div>
		</s:form>
	</div> 
</div>
</body>
</html>