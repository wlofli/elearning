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
 	<h6 class="position">位置:我的课程&gt;<s:property value="coursedata.elcourseName"/>&gt;课程通知&gt;修改</h6>
	<h1 class="h1">修改通知</h1> 	
	<div id="elform_ntc">
		<s:form action="Notice" method="POST" theme="simple">
			<s:hidden name="coursedata.elcourseId"></s:hidden>
			<s:hidden name="notice.ntcId"></s:hidden>
			<s:hidden name="notice.ntcDelete"></s:hidden>
			<div id="ntctitle">标题：<s:textfield    name="notice.ntcTitle"   size="100"  maxlength="50"></s:textfield></div>
			<div id="ntccontent">内容：<s:textarea     name="notice.ntcContent"   cols="103" rows="20" ></s:textarea></div>
			<div id="ntcusername">编辑：<s:textfield  name="notice.ntcUsername"></s:textfield></div>
			<div id="ntcdate">日期：<s:date name="notice.ntcDate" format="MM/dd/yy"></s:date></div>
			<div id="p8"><s:submit name="update"    method="updateCourseNotice"    value="修改"></s:submit>
			<s:submit name="deltte"    method="deleteCourseNotice"    value="删除"></s:submit>
			<s:submit name="loadallnotice"    method="turnCoursentc"    value="返回"></s:submit></div>
			<div id="p9"><font color="red"><s:property value="error"></s:property></font></div>
		</s:form>
	</div> 
</div>
</body>
</html>