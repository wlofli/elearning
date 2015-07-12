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
<title>用户详细信息表</title>
</head>
<body >
<h6 class="position">位置：课程管理&gt;课程修改</h6>
<h1 class="h1">课程修改</h1>
<div id="elform_course">
	<s:form action="Course" method="POST" theme="simple"> 
		<s:hidden     name="courseform.elcourseId"></s:hidden>
		<div id="c1"><s:textfield   name="courseform.elcourseName" maxlength="25">课程名称：</s:textfield></div>
		<div id="c2"><s:textfield  name="courseform.elcourseGroup" maxlength="10">课程组：</s:textfield></div>
		<div id="c3"><s:textarea   name="courseform.elcourseInfo" cols="78" rows="3">课程信息：</s:textarea></div>
		<div id="c4"><s:textarea	  name="courseform.elcoursePurport" cols="78" rows="13">课程大纲：</s:textarea></div>
		<div id="c5">创建时间：<s:date name="courseform.elcourseDate" format="MM/dd/yy"></s:date></div>
		<div id="p8"><s:submit name="update"    method="updateElCourse"    value="修改"></s:submit>
		<s:submit name="delete"    method="deleteElCourse"    value="删除"></s:submit>
		<s:submit name="adduser"    method="turnaddUser"    value="添加用户"></s:submit>
		<s:submit name="deleteuser"    method="turndeleteUser"    value="删除用户"></s:submit>
		<s:submit name="loadallcourse"    method="loadAllCourse"    value="返回"></s:submit></div>
		<div id="p9"><font color="red"><s:property value="error"></s:property></font></div>
	</s:form>
</div>
</body>
</html>