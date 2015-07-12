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
<title>练习列表</title>
</head>
<body >
 <div id="content">
 <h6 class="position">位置:我的课程&gt;<s:property value="coursedata.elcourseName"/>&gt;作业&gt;<s:property value="exercise.elexName"/></h6>
 <h1 class="h1"><s:property value="coursedata.elcourseName"/></h1>
 <s:hidden name="coursedata.elcourseId"></s:hidden>
 <s:hidden name="exercise.elexId"></s:hidden>
 <div id="select">
 		<ul>
 			<li><span><a href="Notice!turnCoursentcStu?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>" >课程通知</a></span></li>
 			<li><span><a href="StuCourse!turnCourseInfo?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>">课程信息</a></span></li> 			
 			<li><span><a href="ExerciseStu!turnDownloadData?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>">课程文档</a></span></li> 			
 			<li><span><a href="ExerciseStu!turnExercise?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>">作业</a></span></li>
 			<li><span><a href="Chat!turnChatList?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>">讨论版</a></span></li>
 			<li><span><a href="StuCourse!turnUrllist?coursedata.elcourseId=<s:property value="coursedata.elcourseId"/>">外部链接</a></span></li>
 		</ul>
	</div>
<div id="stu_exerciseform">
	<div class="stu_exercise">
		 <h3>作业文件：</h3>
		 <p><a href="ExerciseDownload?exercise.elexId=<s:property value='exercise.elexId'/>">
			<s:property value='exercise.elexName'/>
			</a>
		</p>
		<s:if test="#isupload==null">
			<h3>作业状态：未提交</h3>
			<h3>上交文件：暂无</h3>
			<s:form action="ExerciseStu" method="POST" theme="simple"  enctype="multipart/form-data">
			<s:file name="exercisedetail">上传作业</s:file>
			<s:hidden name="coursedata.elcourseId"></s:hidden>
			<s:hidden name="exercise.elexId"></s:hidden>
			<div id="p8"><s:submit name="addexercisedetail"          method="addExerciseDetail"          value="上交"></s:submit>
			<s:submit name="turnexercise"    method="turnExercise"    value="返回"></s:submit></div>
			</s:form>
		</s:if>
		<s:else> 
			<h3>作业状态：已上交</h3>
			<h3>上交文件：</h3>
			<p><a href="ExerciseDetailDownload?edetail.elexdId=<s:property value='#isupload.elexdId'/>">
				<s:property value='#isupload.elexdName'/>
				</a>
			</p>
			 <s:form action="ExerciseStu" method="POST" theme="simple"  >
			<s:hidden name="coursedata.elcourseId"></s:hidden>
			<s:hidden name="exercise.elexId"></s:hidden>
			<div id="p8"><s:submit name="turnexercise"    method="turnExercise"    value="确定"></s:submit></div>
			</s:form>
		</s:else>
	</div>
</div>
</div> 
</body>
</html>