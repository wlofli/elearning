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
<title>课程新增</title>
</head>
<body >
 <div id="content">
 <h6 class="position">位置：课程新增</h6>
 <h1 class="h1">课程新增</h1>
 <div id="elform_course">
 	<s:form action="Course" method="POST" theme="simple">
		<div id="c1"><s:textfield  name="courseform.elcourseName" maxlength="25">课程名称：</s:textfield></div>
		<div id="c2"><s:textfield  name="courseform.elcourseGroup" maxlength="10">课程组：</s:textfield></div>
		<div id="c3"><s:textarea   name="courseform.elcourseInfo" cols="78" rows="3">课程信息：</s:textarea></div>
		<div id="c4"><s:textarea	  name="courseform.elcoursePurport" cols="78" rows="13">课程大纲：</s:textarea></div>
		<div id="p8"><s:submit name="add"    method="addCourse"    value="新增"></s:submit>
		<s:submit name="loadallcourse"    method="loadAllCourse"    value="返回"></s:submit></div>
		<div id="p9"><font color="red"><s:property value="error"></s:property></font></div>
	</s:form>
</div>
</div> 
</body>
</html>