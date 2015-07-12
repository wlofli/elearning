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
<h6 class="position">位置:通知列表</h6>
<h1 class="h1">通知公告</h1>
<div id="ntc">	
	<ul class="elntc">		
			<s:iterator value="noticelist" id="obj">
				<li><span><s:date name="#obj.ntcDate" format="MM/dd/yy"></s:date></span>									
					<a href="Notice!turnNoticeDetail?notice.ntcId=<s:property value='#obj.ntcId'/>">
					<s:property value="#obj.ntcTitle"></s:property>	
					</a>														
				</li>				 		
			</s:iterator> 										
	</ul>
</div>
</body>
</html>