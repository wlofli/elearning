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
<body >
 <div id="content">
 <h6 class="position">位置:我的课程&gt;<s:property value="coursedata.elcourseName"/>&gt;外部链接</h6>
 <h1 class="h1"><s:property value="coursedata.elcourseName"/></h1>
 <s:hidden name="coursedata.elcourseId"></s:hidden>
 <div id="select">
 		<ul>
 			<li><span><a href="Notice!turnCoursentcStu?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>" >课程通知</a></span></li>
 			<li><span><a href="StuCourse!turnCourseInfo?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>">课程信息</a></span></li> 			
 			<li><span><a href="ExerciseStu!turnDownloadData?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>">课程文档</a></span></li> 			
 			<li><span><a href="ExerciseStu!turnExercise?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>">作业</a></span></li>
 			<li><span><a href="Chat!turnChatList?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>">讨论版</a></span></li>
 			<li><span><a href="StuCourse!turnUrllist?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>">外部链接</a></span></li>
 		</ul>
	</div>
	<div id="stu_urllist">
			<ul>
				<s:iterator value="urllist" id="obj">														
					<li>						
						<a href="<s:property value="#obj.eldtUrl"/>" target="_blank">
						<s:property value="#obj.eldtUrl"></s:property>	
						</a>
	 				</li>
					<li><s:property value="#obj.eldtName"/>	
					</li><br><br>
				</s:iterator>
			</ul>
	</div>
</div>
</body>
</html>