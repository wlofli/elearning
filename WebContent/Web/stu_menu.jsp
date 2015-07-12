<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link  rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/Web/elearning.css">
<link  rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/Web/bootstrap-theme.css">
<link  rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/Web/bootstrap.css">

<title>Insert title here</title>
<script>
function loadmycourse(){
	window.parent.content.location="../ExerciseStu!loadAllCourse";
}
function loadallnotice(){
	window.parent.content.location="../Notice!loadAllNotice2";
}	
</script>

</head>
<body >
<button type="button" onclick="javascript:loadmycourse();" class="btn btn-info btn-block">我的课程</button>
<button type="button" onclick="javascript:loadallnotice();"  class="btn btn-info btn-block">通知公告</button>

</body>
</html>