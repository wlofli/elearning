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
</head>
<body >
<h6 class="position">位置:我的课程&gt;<s:property value="coursedata.elcourseName"/>&gt;外部链接&gt;新增</h6>
 <h1 class="h1"><s:property value="coursedata.elcourseName"/></h1>

 	<div id="select">
 		<ul>
 			<li><span><a href="Notice!turnCoursentc?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>" >课程通知</a></span></li>
 			<li><span><a href="TeachCourse!turnCourseInfo?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>">课程信息</a></span></li>
 			<li><span><a href="Data!turnUploadData?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>">课程文档</a></span></li>
 			<li><span><a href="Exercise!turnExercise?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>">作业</a></span></li>
 			<li><span><a href="Chat!turnChatGrid?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>">讨论版</a></span></li>
 			<li><span><a href="TeachCourse!turnUrllist?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>">外部链接</a></span></li>
 		</ul>
	</div>
<div id="urlform">
	<s:form action="TeachCourse" method="POST" theme="simple"> 
		<s:hidden     name="dataurl.eldtId"></s:hidden>
		<s:hidden name="coursedata.elcourseId"></s:hidden>
		<s:hidden name="dataurl.elcourseId"/>
		<div id="u1"><s:textfield   name="dataurl.eldtUrl" maxlength="100" size="80">链接名称：</s:textfield></div>
		<div id="u2"><s:textfield  name="dataurl.eldtName" maxlength="22" size="80">链接描述：</s:textfield></div>		
		<div id="p8"><s:submit name="add"    method="addDataUrl"    value="添加"></s:submit>
		<s:submit name="turnurllist"    method="turnUrllist"    value="返回"></s:submit></div>
	</s:form>
</div>
</body>
</html>