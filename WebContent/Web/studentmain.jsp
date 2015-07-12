<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link  rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/Web/elearning.css">
<link  rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/Web/bootstrap-theme.css">
<link  rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/Web/bootstrap.css">
<title>学生界面</title>
</head>


<frameset rows="100px,*" frameborder="NO" framespacing="1">
	<frame src="logo.jsp" marginwidth="0" marginheight="0" scrolling="no" noresize />
	<frameset cols="150px,*">
  		<frame src="stu_menu.jsp" marginwidth="0" marginheight="0" noresize/>
  		<frame src="stu_content.jsp" name="content" marginwidth="0" marginheight="0" />

	</frameset>
	
	<noframes>
		<body>
			<p>此网页使用了框架，但您的浏览器不支持框架。</p>
		</body>
	</noframes>

</frameset>
 

</html>