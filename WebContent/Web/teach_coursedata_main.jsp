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
<script>
function turnadddatantc(){
	window.parent.content.location="Notice!turnAddCourseNotice?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>";
}	
</script>
</head>
<body >
 <div id="content">
 <h6 class="position">位置:我的课程&gt;<s:property value="coursedata.elcourseName"/>&gt;课程通知</h6>
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
	<table  class="table table-hover " >
		<thead>
			<tr class="success">
				<td width="40%">通知名称</td>
				<td width="30%">发布日期</td>
				<td width="30%">操作</td>
			</tr>
		</thead>
	 	<s:iterator value="coursenoticelist" id="obj">
		<tr >
			<td><s:property value="#obj.ntcTitle"></s:property></td>
			<td><s:date name="#obj.ntcDate" format="MM/dd/yy"></s:date></td>
			<td>
				<a href="Notice!turnUpdateCourseNotice?notice.ntcId=<s:property value='#obj.ntcId'/>&coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>">修改</a>		
			</td>
		</tr>	
		</s:iterator> 
	</table><br>
	<div id="addntc"><button type="button" onclick="javascript:turnadddatantc()" class="btn btn-primary">新增课程通知</button></div>
			
</div>
</body>
</html>