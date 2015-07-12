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
 <h6 class="position">位置:我的课程</h6>
 <h1 class="h1">课程列表</h1>
	<ul id="tchgrid">	
		 	<s:iterator value="courselist" id="obj">
		 		<li>	
				<a href="Notice!turnCoursentc?coursedata.elcourseId=<s:property value="#obj.elcourseId"/>">
					<s:property value="#obj.elcourseName"></s:property>	
				</a>			
				</li>								
			</s:iterator> 	
	</ul>	
</div>
</body>
</html>