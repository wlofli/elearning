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
 <h6 class="position">位置：课程管理</h6>
	<h1 class="h1">课程列表</h1>
	<table  class="table table-hover " >
		<thead>
			<tr class="success">
				<td width="25%">课程名称</td>
				<td width="25%">课程组</td>
				<td width="25%">课程信息</td>
				<td width="25%">操作</td>
			</tr>
		</thead>
	 	<s:iterator value="courselist" id="obj">
		<tr >
			<td><s:property value="#obj.elcourseName"></s:property></td>
			<td><s:property value="#obj.elcourseGroup"></s:property></td>
			<td><s:property value="#obj.elcourseInfo"></s:property></td>
			<td><a href="Course!turnUpdateCourse?courseform.elcourseId=<s:property value="#obj.elcourseId"/>">修改课程</a>			
			</td>
		</tr>	
		</s:iterator> 
	</table>
</div>
</body>
</html>