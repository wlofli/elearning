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

function loadalluser(){
	window.parent.content.location="../ElUser!loadAllEluser";
}
function adduser(){
	window.parent.content.location="../ElUser!turnAddEluser";
}
function loadallcourse(){
	window.parent.content.location="../Course!loadAllCourse";
}
function addcourse(){
	window.parent.content.location="../Course!turnAddCourse";
}
function loadallnotice(){
	window.parent.content.location="../Notice!loadAllNotice";
}
function addnotice(){
	window.parent.content.location="../Notice!turnAddNotice";
}
	
</script>

</head>
<body >
	<button type="button" onclick="javascript:loadalluser();"  class="btn btn-info btn-block">用户管理</button>
	<button type="button"  onclick="javascript:adduser();" class="btn btn-primary btn-block">用户添加</button>
	<button type="button" onclick="javascript:loadallcourse();" class="btn btn-info btn-block">课程管理</button>
	<button type="button" onclick="javascript:addcourse();" class="btn btn-primary btn-block">课程添加</button>
	<button type="button" onclick="javascript:loadallnotice();"  class="btn btn-info btn-block">通知公告</button>
	<button type="button" onclick="javascript:addnotice();" class="btn btn-primary btn-block">通知添加</button>
	
</body>
</html>