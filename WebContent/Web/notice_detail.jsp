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
function loadallnotice(){
	window.parent.content.location="Notice!loadAllNotice2";
}
</script>
</head>
<body >
<h6 class="position">位置:通知列表&gt;新闻内容</h6> 
<div id="ntc_detail">		
		<h2 class="h1"><s:property value="notice.ntcTitle"/></h2>
		<pre>${notice.ntcContent}</pre><br>
		<div id="ntc_date"><s:date name="notice.ntcDate" format="MM/dd/yy"></s:date></div>
		<div id="ntc_date_back"><button type="button" onclick="javascript:loadallnotice()" class="btn btn-primary">返回</button></div>
		<div id="ntc_username"><s:property value="notice.ntcUsername"/></div>
</div>
</body>
</html>