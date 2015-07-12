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
<title>新闻添加</title>
</head>
<body >
 <div id="content">
 	<h6 class="position">位置:我的课程&gt;<s:property value="coursedata.elcourseName"/>&gt;讨论版&gt;修改</h6>
	<h1 class="h1"><s:property value="coursedata.elcourseName"/></h1>
	<s:hidden name="coursedata.elcourseId"></s:hidden>
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
	<div id="elform_cht">
		<s:form action="Chat" method="POST" theme="simple">			
			<s:hidden name="coursedata.elcourseId"></s:hidden>
			<s:hidden name="chat.elchId"/>
			<s:hidden name="chat.elcourseId"/>
			<s:hidden name="chat.elchReverse2"/>
			<s:hidden name="chat.elchTime"/>
	 		<div id="chtName">讨论名称：&nbsp;<s:textfield   name="chat.elchName"   size="40"  maxlength="16"></s:textfield></div>							
			<br><br>
			<div id="chtRevers1">允许回复：<s:select  list="#{'0':'是','1':'否' }" name="chat.elchReverse1"></s:select></div>			
			<div id="p8"><s:submit name="update"    method="updateChat"    value="修改"></s:submit>
						 <s:submit name="delete"    method="deleteChat"  value="删除"></s:submit>
			<s:submit name="back"    method="turnChatGrid"    value="返回"></s:submit></div>
			<div id="cht9"><font color="red"><s:property value="error"></s:property></font></div>
		</s:form>
	</div> 
</div>
</body>
</html>