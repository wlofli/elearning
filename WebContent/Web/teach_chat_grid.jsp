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
<title>资料列表</title>
</head>
<script>
function addchat(){
	window.parent.content.location="Chat!turnAddChat?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>";
}	
</script>

<body >
<div id="content">
 <h6 class="position">位置:我的课程&gt;<s:property value="coursedata.elcourseName"/>&gt;讨论版</h6>
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
				<td width="40%">讨论名称</td>
				<td width="20%">创建日期</td>
				<td width="20%">详情</td>
				<td width="20%">操作</td>
			</tr>
		</thead>
	 	<s:iterator value="chatlist" id="obj">
		<tr >
			<td><s:property value="#obj.elchName"></s:property></td>
			<td><s:date name="#obj.elchTime" format="MM/dd/yy"></s:date></td>
			<td>
				<a href="Chat!turnChatDetailTch?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>&chat.elchId=<s:property value="#obj.elchId"/>&page=1">
					查看
				</a>		
			</td> 
			<td>
				<a href="Chat!turnUpdateChat?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>&chat.elchId=<s:property value="#obj.elchId"/>">
					修改
				</a>
			</td>
		</tr>	
		</s:iterator> 
	</table>	
	<div id="addntc"><button type="button" onclick="javascript:addchat()" class="btn btn-primary">新增讨论版</button></div>
</div> 
</body>
</html>